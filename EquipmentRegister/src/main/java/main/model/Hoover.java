package main.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hoover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String serialNumber;

    @Getter
    @Setter
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "color_id", nullable = false)
    private String color;

    @Getter
    @Setter
    private double size;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private double dustContainerVolume;

    @Getter
    @Setter
    private int numberOfModes;

    @Getter
    @Setter
    private Boolean isAvailability;
}
