package com.stockinvestor.controller;

import com.stockinvestor.dto.InvestmentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class InvestmentRequestController {

    private final KafkaTemplate<InvestmentRequest, InvestmentRequest> kafkaTemplate;

    public InvestmentRequestController(KafkaTemplate<InvestmentRequest, InvestmentRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/invest")
    ResponseEntity<?> requestInvestment(@RequestBody InvestmentRequest investmentRequest) {
        log.info("Publishing message through API");
        kafkaTemplate.send("investmentRequestInput", investmentRequest);
        log.info("Message sent via API");
        return ResponseEntity.status(HttpStatus.OK).body(investmentRequest);
    }
}
