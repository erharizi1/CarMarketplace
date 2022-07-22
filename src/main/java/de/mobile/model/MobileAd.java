package de.mobile.model;

import de.mobile.model.Category;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;


@Entity
@Data
public class MobileAd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Make name is required")
    @Column(name = "make")
    private String make;

    @NotEmpty(message = "Model name is required")
    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;


    @Column(name = "category")
    private Category category;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id", nullable=false)
    private MobileCustomer customer;


}
