package br.com.osnirmaster.consumer.app.adapters.out.api;

import br.com.osnirmaster.consumer.app.domain.Customer;
import br.com.osnirmaster.consumer.app.domain.service.GetCustomer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GetCustomerBank implements GetCustomer {
    @Override
    public Customer getCustomer(String customerId) {
        return new Customer(
                101010,
                "Osnir",
                "Teixeira",
                LocalDate.of(1988,12, 8),
                null
        );
    }
}
