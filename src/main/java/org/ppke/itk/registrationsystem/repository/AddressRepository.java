package org.ppke.itk.registrationsystem.repository;

import org.ppke.itk.registrationsystem.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {}
