package com.br.rmm.services;

import com.br.rmm.dtos.Customer;

public sealed interface MonitoringService permits MonitoringServiceImpl {
    String checkCustomer(Customer customer);
}
