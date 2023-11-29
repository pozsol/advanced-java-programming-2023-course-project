package org.ppke.itk.registrationsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @JsonBackReference
    @ManyToOne
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "citizen")
    private Set<BankAccount> bankAccounts;

    @JsonManagedReference
    @OneToOne
    private DrivingLicense drivingLicense;

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                ", bankAccounts=" + bankAccounts +
                ", drivingLicense=" + drivingLicense +
                '}';
    }
}
