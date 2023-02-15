package com.stockinvestor.config;

import com.stockinvestor.dto.InvestmentRequest;
import com.stockinvestor.processor.TopicProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class StreamConfig {

    @Bean
    public Function<InvestmentRequest, InvestmentRequest> consumerFunction(final TopicProcessor topicProcessor) {
        return topicProcessor::process;
    }
}
