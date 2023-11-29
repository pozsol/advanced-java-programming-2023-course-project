package org.ppke.itk.registrationsystem.repository;

import org.ppke.itk.registrationsystem.domain.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {}
