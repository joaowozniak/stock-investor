package com.stockinvestor.processor;

import com.stockinvestor.dto.InvestmentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class TopicProcessor {

    public InvestmentRequest process(InvestmentRequest investmentRequest) {
        log.info("Reading message from topic: {}", investmentRequest);
        return investmentRequest;
    }
}
