package de.mobile.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@Entity
public class MobileCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotEmpty(message = "First name is required")
    @Pattern(regexp="^[a-zA-Z0-9]+$",message="name is invalid")
    @Column(name = "firstName")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="name is invalid")
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "companyName")
    private String companyName;

    @NotEmpty(message = "Email is required")
    @Email
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy="customer")
    private Set<MobileAd> ads;

}
