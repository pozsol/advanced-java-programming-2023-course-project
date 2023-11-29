package org.ppke.itk.registrationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.registrationsystem.domain.DrivingLicense;
import org.ppke.itk.registrationsystem.repository.DrivingLicenseRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driving-licenses")
public class DrivingLicenseController {

    private final DrivingLicenseRepository drivingLicenseRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping()
    public List<DrivingLicense> getAllDrivingLicenses() {
        return drivingLicenseRepository.findAll();
    }

    @Secured({"ROLE_ADMIN", "ROLE_VIEWER"})
    @GetMapping(value = "/{id}")
    public DrivingLicense getDrivingLicenseById(@PathVariable long id) {
        return drivingLicenseRepository.findById(id).get();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public void addNewDrivingLicense(@RequestBody DrivingLicense drivingLicense) {
        drivingLicenseRepository.save(drivingLicense);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{id}")
    public void updateDrivingLicenseById(@PathVariable long id,
                                         @RequestBody DrivingLicense drivingLicense) {
        if (drivingLicenseRepository.findById(id).isPresent()) {
            drivingLicense.setId(id);
            drivingLicenseRepository.save(drivingLicense);
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public void deleteDrivingLicenseById(@PathVariable long id) {
        drivingLicenseRepository.deleteById(id);
    }
}
