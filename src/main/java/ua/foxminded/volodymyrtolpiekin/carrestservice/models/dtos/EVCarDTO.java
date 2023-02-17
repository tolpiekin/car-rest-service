package ua.foxminded.volodymyrtolpiekin.carrestservice.models.dtos;

public class EVCarDTO {
    private Long id;
    private CarModelDTO model;
    private int year;
    private BodyDTO body;
    private MakerDTO maker;
    private ElectricMotorDTO engine;
    private TractionBatteryDTO battery;
    private ReducerDTO reducer;
    private OnBoardChargerDTO charger;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EVCarDTO evCarDTO = (EVCarDTO) o;
        return id.equals(evCarDTO.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id == null ? 0 : id.hashCode());
        return result;
    }
}
