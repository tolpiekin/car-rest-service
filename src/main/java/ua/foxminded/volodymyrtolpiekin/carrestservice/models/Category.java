package ua.foxminded.volodymyrtolpiekin.carrestservice.models;

public enum Category {
    CONVERTIBLE, COUPE, HATCHBACK, PICKUP, SEDAN, SUV, SUV1992, SUV2020, VAN, WAGON;

    public String getSize() {

        switch (this) {
            case CONVERTIBLE:
                return "Convertible";
            case COUPE:
                return "Coupe";
            case HATCHBACK:
                return "Hatchback";
            case PICKUP:
                return "Pickup";
            case SEDAN:
                return "Sedan";
            case SUV1992:
                return "SUV1992";
            case SUV2020:
                return "SUV2020";
            case SUV:
                return "SUV";
            case VAN:
                return "Van/Minivan";
            case WAGON:
                return "Wagon";
            default:
                return null;
        }
    }
}
