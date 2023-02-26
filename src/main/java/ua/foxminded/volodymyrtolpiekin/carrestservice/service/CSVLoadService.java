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
    private final CarModelService carModelService;
    private final CategoryService categoryService;
    private final CarService carService;
    private final EVCarService evCarService;

    public CSVLoadService(MakerService makerService, CarModelService carModelService, CategoryService categoryService, CarService carService, EVCarService evCarService) {
        this.makerService = makerService;
        this.carModelService = carModelService;
        this.categoryService = categoryService;
        this.carService = carService;
        this.evCarService = evCarService;
    }

    @PostConstruct
    public void loadDataFromCSV() {

        try (CSVReader csvReader = new CSVReader(new FileReader("file.csv"))) {
            String[] values;
            int carCounter = 0;
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
                    CarModel carModel = createModelIfNotExists(modelName, maker);

                    if (modelName.contains("EV")) {
                        createEVCarIfNotExists(maker, carModel, year, objectId, category);
                    } else {
                        createCarIfNotExists(maker, carModel, year, objectId, category);
                    }
                    carCounter++;
                }
            }
            System.out.println(carCounter + "cars were added.");
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createEVCarIfNotExists(Maker maker, CarModel carModel, int year, String objectId, List<Category> category) {
        if (!evCarService.ifExistsByObjectId(objectId)) {
            EVCar evCar = new EVCar();
            evCar.setObjectId(objectId);
            evCar.setModel(carModel);
            evCar.setYear(year);
            evCar.setCategory(category);
            evCarService.create(evCar);
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

    private void createCarIfNotExists(Maker maker, CarModel carModel, int year, String objectId, List<Category> category) {
        if (!carService.ifExistsByObjectId(objectId)) {
            Car car = new Car();
            car.setObjectId(objectId);
            car.setModel(carModel);
            car.setYear(year);
            car.setCategory(category);
            carService.create(car);
        }
    }

    private CarModel createModelIfNotExists(String name, Maker maker) {
        if (carModelService.ifExistsByName(name)) {
            return carModelService.findByName(name);
        } else {
            CarModel carModel = new CarModel();
            carModel.setName(name);
            carModel.setMaker(maker);
            return carModelService.create(carModel);
        }
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