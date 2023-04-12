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
public class TV {

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
//    private ColorsBD colorsBD;
    private String color;

    @Getter
    @Setter
    private double diagonal;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "category_id", nullable = false)
//    private CategoryTV categoryTV;
    private String catTV;

    @Getter
    @Setter
    private String technology;

    @Getter
    @Setter
    private Boolean isAvailability;

}
