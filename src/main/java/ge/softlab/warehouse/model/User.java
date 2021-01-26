package ge.softlab.warehouse.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String provider;
    @Column
    private String store;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private int quantity;
    @Column
    private int price;
    @Column
    private int pricePerProduct;

}
