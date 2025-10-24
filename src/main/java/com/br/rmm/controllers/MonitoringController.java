package com.br.rmm.controllers;

import com.br.rmm.dtos.Customer;
import com.br.rmm.services.MonitoringService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/monitoring")
public class MonitoringController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MonitoringService monitoringService;
    private final Counter helloCounter;

    public MonitoringController(MonitoringService monitoringService, MeterRegistry registry) {
        this.monitoringService = monitoringService;
        this.helloCounter = Counter.builder("hello_requests_total")
                .description("Número total de requisições /hello")
                .register(registry);
    }

    @PostMapping
    public ResponseEntity<String> monitoring(@Valid @RequestBody Customer customer) {
        logger.info("teste log loki");
        helloCounter.increment();
        monitoringService.checkCustomer(customer);

        return ResponseEntity.ok(monitoringService.checkCustomer(customer));
    }
}
