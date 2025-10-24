package com.br.rmm.services;

import com.br.rmm.dtos.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public final class MonitoringServiceImpl implements MonitoringService {

    Logger log = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper mapper;

    public MonitoringServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String checkCustomer(Customer customer) {
        if("mariana".equalsIgnoreCase(customer.name())){
            log.error("parameter name entered is not expected");
            throw new IllegalArgumentException("parameter name entered is not expected");
        }

        if(customer.age() <= 18){
            log.warn("the customer is under 18 years old");
        }

        log.info("customer name and age are ok, validation performed successfully");
        return parseResponse("ok");
    }

    private String parseResponse(String body){
        try {
            return mapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            log.error("Error parse Response");
            throw new RuntimeException("Error parse Response", e);
        }
    }
}
