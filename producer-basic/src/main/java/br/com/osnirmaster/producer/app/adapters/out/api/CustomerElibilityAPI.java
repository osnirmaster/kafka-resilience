package br.com.osnirmaster.producer.app.adapters.out.api;

import br.com.osnirmaster.producer.app.domain.Customer;
import br.com.osnirmaster.producer.app.domain.service.CustomerEligibility;
import org.springframework.stereotype.Component;

@Component
public class CustomerElibilityAPI implements CustomerEligibility {
    @Override
    public boolean getEligibility(Customer customer) {
        return true;
    }
}
