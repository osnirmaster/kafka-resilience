package br.com.osnirmaster.consumer.app.domain.service;

import br.com.osnirmaster.consumer.app.domain.Customer;

public interface CustomerEligibility {
    boolean getEligibility(Customer customer);
}
