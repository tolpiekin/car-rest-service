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

        try (CSVReader csvReader = new CSVReader(new FileReader("file.csv"));) {
            String[] values = csvReader.readNext();
            int evCarNo = 0;
            int carNo = 0;
            while ((values = csvReader.readNext()) != null) {
                if (values[0] != "") {
                    String objectId = values[0];
                    String make = values[1];
                    int year = Integer.valueOf(values[2]);
                    String model = values[3];
                    String[] categories = Arrays.copyOfRange(values, 4, values.length);

                    Maker maker = createMakerIfNotExist(make);
                    List<Category> category = createCategoryIfNotExists(categories);
                    CarModel carModel = createModelIfNotExists(model, maker);

                    if (model.contains("EV")) {
                        createEVCarIfNotExists(maker, carModel, year, objectId, category);
                        System.out.println("" + evCarNo++ + " EVCar: " + carModel.getName() + " created");
                    } else {
                        createCarIfNotExists(maker, carModel, year, objectId, category);
                        System.out.println("" + carNo++ + " Car: " + carModel.getName() + " created");
                    }
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private EVCar createEVCarIfNotExists(Maker maker, CarModel carModel, int year, String objectId, List<Category> category) {
        if (evCarService.ifExistsByObjectId(objectId)) {
            return evCarService.findByObjectId(objectId);
        } else {
            EVCar evCar = new EVCar();
            evCar.setObjectId(objectId);
            evCar.setMaker(maker);
            evCar.setModel(carModel);
            evCar.setYear(year);
            evCar.setCategory(category);
            return evCarService.create(evCar);
        }
    }

    private List<Category> createCategoryIfNotExists(String[] categories) {
        List<Category> categoriesList = new ArrayList<>();
        for(String category: categories) {
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

    private Car createCarIfNotExists(Maker maker, CarModel carModel, int year, String objectId, List<Category> category) {
        if (carService.ifExistsByObjectId(objectId)) {
            return carService.findByObjectId(objectId);
        } else {
            Car car = new Car();
            car.setObjectId(objectId);
            car.setMaker(maker);
            car.setModel(carModel);
            car.setYear(year);
            car.setCategory(category);
            return carService.create(car);
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