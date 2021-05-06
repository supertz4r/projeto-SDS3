package com.sds3.dsvendas.controllers;

import com.sds3.dsvendas.dto.SaleDTO;
import com.sds3.dsvendas.dto.SalesSuccessDTO;
import com.sds3.dsvendas.dto.SalesSumDTO;
import com.sds3.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/sales-by-seller")
    public ResponseEntity<List<SalesSumDTO>> amountGroupedBySeller() {
        List<SalesSumDTO> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SalesSuccessDTO>> successGroupedBySeller() {
        List<SalesSuccessDTO> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }
}