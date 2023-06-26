package br.com.osnirmaster.consumer.app.adapters.out.api;

import br.com.osnirmaster.consumer.app.domain.Customer;
import br.com.osnirmaster.consumer.app.domain.service.CustomerEligibility;
import org.springframework.stereotype.Component;

@Component
public class CustomerElibilityAPI implements CustomerEligibility {
    @Override
    public boolean getEligibility(Customer customer) {
        return true;
    }
}
