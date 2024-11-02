package com.PARCIAL.controladores;

import com.PARCIAL.dtos.StatsResponse;
import com.PARCIAL.servicios.DNAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private DNAService dnaService;

    @GetMapping
    public ResponseEntity<StatsResponse> getStats() {

        StatsResponse statsResponse = dnaService.getStats();
        return ResponseEntity.ok(statsResponse);
    }
}


