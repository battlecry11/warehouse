package ge.softlab.warehouse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String store;
}
