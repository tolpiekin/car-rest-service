package ua.foxminded.volodymyrtolpiekin.carrestservice.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;
import ua.foxminded.volodymyrtolpiekin.carrestservice.models.*;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CSVLoadService {
    private final MakerService makerService;
    private final CategoryService categoryService;
    private final CarService carService;
    private final EVCarService evCarService;

    public CSVLoadService(MakerService makerService, CategoryService categoryService, CarService carService, EVCarService evCarService) {
        this.makerService = makerService;
        this.categoryService = categoryService;
        this.carService = carService;
        this.evCarService = evCarService;
    }

    @PostConstruct
    public void loadDataFromCSV() {

        try (CSVReader csvReader = new CSVReader(new FileReader("file.csv"))) {
            String[] values;
            csvReader.readNext();
            while ((values = csvReader.readNext()) != null) {
                if (!(values[0].equals(""))) {
                    String objectId = values[0];
                    String makerName = values[1];
                    int year = Integer.parseInt(values[2]);
                    String modelName = values[3];
                    String[] categoryNames = Arrays.copyOfRange(values, 4, values.length);

                    Maker maker = createMakerIfNotExist(makerName);
                    List<Category> category = createCategoryIfNotExists(categoryNames);

                    if (modelName.contains("EV")) {
                        createEVCarIfNotExists(maker, modelName, year, objectId, category);
                    } else {
                        createCarIfNotExists(maker, modelName, year, objectId, category);
                    }
                }
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createEVCarIfNotExists(Maker maker, String modelName, int year, String objectId, List<Category> category) {
        if (!evCarService.ifExistsByObjectId(objectId)) {
            EVCar evCar = new EVCar();
            evCar.setObjectId(objectId);
            evCar.setMaker(maker);
            evCar.setName(modelName);
            evCar.setYear(year);
            evCar.setCategory(category);
            evCarService.create(evCar);
        }
    }

    private void createCarIfNotExists(Maker maker, String modelName, int year, String objectId, List<Category> category) {
        if (!carService.ifExistsByObjectId(objectId)) {
            Car car = new Car();
            car.setObjectId(objectId);
            car.setMaker(maker);
            car.setName(modelName);
            car.setYear(year);
            car.setCategory(category);
            carService.create(car);
        }
    }

    private List<Category> createCategoryIfNotExists(String[] categories) {
        List<Category> categoriesList = new ArrayList<>();
        for(String category: categories) {
            if (categoryService.ifExistByName(category)) {
                categoriesList.add(categoryService.findByName(category));
            } else {
                Category newCategory = new Category();
                newCategory.setName(category);
                categoriesList.add(categoryService.create(newCategory));
            }
        }
        return categoriesList;
    }

    private Maker createMakerIfNotExist(String make) {
        if (makerService.ifExistsByName(make)) {
            return makerService.findByName(make);
        }else {
            Maker maker = new Maker();
            maker.setName(make);
            return makerService.create(maker);
        }
    }
}