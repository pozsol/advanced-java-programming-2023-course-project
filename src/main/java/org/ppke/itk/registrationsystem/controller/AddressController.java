package org.ppke.itk.registrationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.registrationsystem.domain.Address;
import org.ppke.itk.registrationsystem.repository.AddressRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping()
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Secured({"ROLE_ADMIN", "ROLE_VIEWER"})
    @GetMapping(value = "/{id}")
    public Address getAddressById(@PathVariable long id) {
        return addressRepository.findById(id).get();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public void addNewAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{id}")
    public void updateAddressById(@PathVariable long id,
                                  @RequestBody Address address) {
        if (addressRepository.findById(id).isPresent()) {
            address.setId(id);
            addressRepository.save(address);
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public void deleteAddressById(@PathVariable long id) {
        addressRepository.deleteById(id);
    }
}
