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
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("file.csv"));) {
            String[] values = null;
            String[] header = csvReader.readNext();
            while ((values = csvReader.readNext()) != null) {
                System.out.println(List.of(values));
                if (values[0] == "" || values[1] == "" || values[2] == "" || values[3] == "" || values[4] == "" )
                    continue;
                String objectId = values[0];
                String make = values[1];
                int year = Integer.valueOf(values[2]);
                String model = values[3];
                String[] categories = Arrays.copyOfRange(values, 4, values.length - 1);

                System.out.println(List.of(categories));
                Maker maker = createMakerIfNotExist(make);
                List<Category> category = createCategoryIfNotExists(categories);
                CarModel carModel = createModelIfNotExists(model, maker, category);

                if (model.contains("EV"))
                    createEVCarIfNotExists(maker, carModel, year, objectId);
                else
                    createCarIfNotExists(maker, carModel, year, objectId);

            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private EVCar createEVCarIfNotExists(Maker maker, CarModel carModel, int year, String objectId) {
        if (evCarService.ifExistsByObjectId(objectId)) {
            return evCarService.findByObjectId(objectId);
        } else {
            EVCar evCar = new EVCar();
            evCar.setObjectId(objectId);
            evCar.setMaker(maker);
            evCar.setModel(carModel);
            evCar.setYear(year);
            return evCarService.create(evCar);
        }
    }

    private List<Category> createCategoryIfNotExists(String[] categories) {
        List<Category> categoriesList = new ArrayList<>();
        for(String category: categories) {
            System.out.println(category);
            if (categoryService.existByName(category)) {
                categoriesList.add(categoryService.findByName(category));
            } else {
                Category newCategory = new Category();
                newCategory.setName(category);
                categoriesList.add(categoryService.create(newCategory));
            }
        }
        return categoriesList;
    }

    private Car createCarIfNotExists(Maker maker, CarModel carModel, int year, String objectId) {
        if (carService.ifExistsByObjectId(objectId)) {
            return carService.findByObjectId(objectId);
        } else {
            Car car = new Car();
            car.setObjectId(objectId);
            car.setMaker(maker);
            car.setModel(carModel);
            car.setYear(year);
            return carService.create(car);
        }
    }

    private CarModel createModelIfNotExists(String name, Maker maker, List<Category> category) {
        if (carModelService.ifExistsByName(name)) {
            return carModelService.findByName(name);
        } else {
            CarModel carModel = new CarModel();
            carModel.setMaker(maker);
            carModel.setName(name);
            carModel.setCategory(category);
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