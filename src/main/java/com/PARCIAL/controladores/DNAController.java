package com.PARCIAL.controladores;

import com.PARCIAL.dtos.DNARequest;
import com.PARCIAL.dtos.DNAResponse;
import com.PARCIAL.servicios.DNAService;
import com.PARCIAL.validacion.InvalidDNAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mutant")
public class DNAController {

    @Autowired
    private DNAService dnaService;

    @PostMapping
    public ResponseEntity<DNAResponse> isMutant(@RequestBody DNARequest dnaRequest) {
        try {
            // Verificación del ADN
            isValidDNA(dnaRequest.getDna());

            boolean isMutant = dnaService.isMutant(dnaRequest.getDna());
            // Crea la respuesta usando DNAResponse
            return ResponseEntity.ok(new DNAResponse(isMutant, isMutant ? "Es un mutante" : "No es un mutante"));
        } catch (InvalidDNAException e) {
            return ResponseEntity.badRequest().body(new DNAResponse(false, e.getMessage()));
        }
    }

    private void isValidDNA(String[] dna) {
        if (dna == null || dna.length == 0 || dna.length != dna[0].length()) {
            throw new InvalidDNAException("La matriz debe ser de tamaño NxN y no puede estar vacía");
        }
        for (String row : dna) {
            if (row.length() != dna.length || !row.matches("[ATCG]+")) {
                throw new InvalidDNAException("Cada fila debe contener solo caracteres A, T, C, G");
            }
        }
    }

    @GetMapping
    public ResponseEntity<String> getMutantInfo() {
        return ResponseEntity.ok("El endpoint /mutant está funcionando");
    }
}







