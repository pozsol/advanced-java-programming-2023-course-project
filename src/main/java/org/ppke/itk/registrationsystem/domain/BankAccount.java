package org.ppke.itk.registrationsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_number")
    private long accountNumber;

    @JsonBackReference
    @ManyToOne
    private Citizen citizen;
}
