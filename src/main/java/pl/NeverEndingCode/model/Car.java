package pl.NeverEndingCode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.NeverEndingCode.enums.car.BodyType;
import pl.NeverEndingCode.enums.car.EngineType;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car extends Vehicle {
    @Column(name = "engine_type")
    private EngineType engineType;
    @Column(name = "body_type")
    private BodyType bodyType;
    @Column(name = "number_of_seats")
    private int numberOfSeats;
    @Embedded
    private Audit audit = new Audit();

    public void updateFrom(final Car source) {
        super.updateFrom(source);
        this.engineType = source.engineType;
        this.bodyType = source.bodyType;
        this.numberOfSeats = source.numberOfSeats;
    }

}
