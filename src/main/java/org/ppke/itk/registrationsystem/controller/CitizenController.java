package org.ppke.itk.registrationsystem.controller;

import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import java.io.ByteArrayOutputStream;
import org.ppke.itk.registrationsystem.domain.Citizen;
import org.ppke.itk.registrationsystem.repository.CitizenRepository;
import org.ppke.itk.registrationsystem.util.GeneratePdfFromCitizen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/citizens")
public class CitizenController {

    private final CitizenRepository citizenRepository;

    @Secured({"ROLE_ADMIN", "ROLE_VIEWER"})
    @GetMapping()
    public List<Citizen> getAllCitizens(@RequestParam(required = false, defaultValue = "100") int limit,
                                        @RequestParam(required = false, defaultValue = "asc") String sort) {
        if (!sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc")) {
            throw new IllegalArgumentException("Invalid sorting parameter!");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "lastName") : Sort.by(Sort.Direction.DESC, "lastName");

        Page<Citizen> citizens = citizenRepository.findAll(PageRequest.of(0, limit, sortParam));

        return citizens.toList();
    }

    @Secured({"ROLE_ADMIN", "ROLE_VIEWER"})
    @GetMapping(value = "/{id}")
    public Citizen getCitizenById(@PathVariable long id) {
        return citizenRepository.findById(id).get();
    }

    @Secured({"ROLE_ADMIN", "ROLE_VIEWER"})
    @GetMapping(value = "/{id}/pdf")
    public ResponseEntity<byte[]> getCitizenPdfById(@PathVariable long id) throws DocumentException, IOException {

        Citizen citizen = citizenRepository.findById(id).get();

        ByteArrayOutputStream pdfStream = GeneratePdfFromCitizen.generatePdf(citizen);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=citizen.pdf");
        headers.setContentLength(pdfStream.size());

        return new ResponseEntity<>(pdfStream.toByteArray(), headers, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public void addNewCitizen(@RequestBody Citizen citizen) {
        citizenRepository.save(citizen);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{id}")
    public void updateCitizenById(@PathVariable long id,
                                  @RequestBody Citizen citizen) {
        if (citizenRepository.findById(id).isPresent()) {
            citizen.setId(id);
            citizenRepository.save(citizen);
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public void deleteCitizenById(@PathVariable long id) {
        citizenRepository.deleteById(id);
    }
}
