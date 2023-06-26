package br.com.osnirmaster.consumer.app.domain.usecase;

import br.com.osnirmaster.consumer.app.domain.Customer;
import br.com.osnirmaster.consumer.app.domain.Quote;
import br.com.osnirmaster.consumer.app.domain.repositories.QuoteRepository;
import br.com.osnirmaster.consumer.app.domain.service.CommandBroker;
import br.com.osnirmaster.consumer.app.domain.service.CoverTax;
import br.com.osnirmaster.consumer.app.domain.service.CustomerEligibility;
import br.com.osnirmaster.consumer.app.domain.service.GetCustomer;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Slf4j
public class GetQuoteCalculation {

    private final QuoteRepository quoteRepository;
    private final GetCustomer getCustomer;
    private final CoverTax coverTax;
    private final CustomerEligibility customerEligibility;
    private final CommandBroker commandBroker;

    public GetQuoteCalculation(QuoteRepository quoteRepository,
                               GetCustomer getCustomer,
                               CoverTax coverTax,
                               CustomerEligibility customerEligibility,
                               CommandBroker commandBroker) {
        this.quoteRepository = quoteRepository;
        this.getCustomer = getCustomer;
        this.coverTax = coverTax;
        this.customerEligibility = customerEligibility;
        this.commandBroker = commandBroker;
    }

    public Quote insuranceQuote(Quote quote) throws ExecutionException, InterruptedException {

        Customer customer = getCustomer.getCustomer(quote.getCustomerId());
        if(customerEligibility.getEligibility(customer)) {

            quote.setCoverTax(coverTax.getCoverTax(quote.getproductCode()));
            quote.setQuoteId(UUID.randomUUID().toString());
            quote.sendContractForCaculation(commandBroker);

            log.info("Object Mapping {}", quote );
            log.info("in Storing...");
        }
        return quoteRepository.save(quote);
    }
}
