package br.com.osnirmaster.consumer.app.domain.service;


import br.com.osnirmaster.consumer.app.domain.Customer;

public interface GetCustomer {

    Customer getCustomer(String customerId);
}
