package dto;

public enum Fuel {

    DIESEL("Diesel"), PETROL("Petrol"), HYBRID("Hybrid"),
    ELECTRIC("Electric"), GAS("Gas");
    private final String fuel;

    Fuel(String fuel) {
        this.fuel = fuel;
    }
    public String getFuel() {
        return fuel;
    }

}