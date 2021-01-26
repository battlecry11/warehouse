package ge.softlab.warehouse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String provider;

}
