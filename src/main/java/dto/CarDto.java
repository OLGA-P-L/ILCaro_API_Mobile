package dto;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CarDto {
    private String serialNumber; //": "string",
    private String manufacture; //": "string",
    private String model; //": "string",
    private String year; //": "string",
    private String fuel; //": "string",
    //Fuel fuel;
    private int seats; //": 0,
    private String carClass; //": "string",
    private double pricePerDay;//": 0,
    private String about; //: "string",
    private String city; //": "string",
    private double lat; //": 0,
    private double lng; //": 0,
    private String image; //": "string",
    private String owner; //": "string",
    private List<BookedDto> bookedPeriods;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return seats == carDto.seats && Double.compare(pricePerDay, carDto.pricePerDay) == 0 && Double.compare(lat, carDto.lat) == 0 && Double.compare(lng, carDto.lng) == 0 && Objects.equals(serialNumber, carDto.serialNumber) && Objects.equals(manufacture, carDto.manufacture) && Objects.equals(model, carDto.model) && Objects.equals(year, carDto.year) && Objects.equals(fuel, carDto.fuel) && Objects.equals(carClass, carDto.carClass) && Objects.equals(about, carDto.about) && Objects.equals(city, carDto.city) && Objects.equals(image, carDto.image) && Objects.equals(owner, carDto.owner) && Objects.equals(bookedPeriods, carDto.bookedPeriods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, manufacture, model, year, fuel, seats, carClass, pricePerDay, about, city, lat, lng, image, owner, bookedPeriods);
    }
}
