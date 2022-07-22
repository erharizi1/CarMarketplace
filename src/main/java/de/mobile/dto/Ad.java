package de.mobile.dto;

import de.mobile.model.Category;
import de.mobile.model.MobileCustomer;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Make name is required")
    private String make;

    @NotEmpty(message = "Model name is required")
    private String model;

    @NotEmpty(message = "description")
    private String description;

 //  @NotNull(message = "Category is required")
    private Category category;

    private BigDecimal price;

    @NotNull(message = "customer is required")
    private MobileCustomer customer;


}
