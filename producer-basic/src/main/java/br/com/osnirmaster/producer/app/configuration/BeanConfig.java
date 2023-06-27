package br.com.osnirmaster.producer.app.configuration;

import br.com.osnirmaster.producer.app.domain.repositories.QuoteRepository;
import br.com.osnirmaster.producer.app.domain.service.CommandBroker;
import br.com.osnirmaster.producer.app.domain.service.CoverTax;
import br.com.osnirmaster.producer.app.domain.service.CustomerEligibility;
import br.com.osnirmaster.producer.app.domain.service.GetCustomer;
import br.com.osnirmaster.producer.app.domain.usecase.GetQuoteCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    private final CoverTax coverTax;
    private final CustomerEligibility customerEligibility;
    private final GetCustomer getCustomer;
    private final CommandBroker commandBroker;
    @Autowired
    private QuoteRepository quoteRepository;

    public BeanConfig(
            CoverTax coverTax,
            CustomerEligibility customerEligibility,
            GetCustomer getCustomer,
            CommandBroker commandBroker)
             {
        this.coverTax = coverTax;
        this.customerEligibility = customerEligibility;
        this.getCustomer = getCustomer;
        this.commandBroker = commandBroker;

    }

    @Bean
    public GetQuoteCalculation getQuoteCalculation() {

        return new GetQuoteCalculation(quoteRepository, getCustomer, coverTax, customerEligibility, commandBroker );
    }

}
