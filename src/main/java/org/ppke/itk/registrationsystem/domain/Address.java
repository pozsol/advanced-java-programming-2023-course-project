package org.ppke.itk.registrationsystem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String city;

    private String street;

    @Column(name = "house_number")
    private int houseNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "address")
    private Set<Citizen> citizens;
}
