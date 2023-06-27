package br.com.osnirmaster.producer.app.domain.service;

import br.com.osnirmaster.producer.app.domain.Customer;

public interface CustomerEligibility {
    boolean getEligibility(Customer customer);
}
