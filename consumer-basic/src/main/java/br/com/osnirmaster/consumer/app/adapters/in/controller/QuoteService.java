package br.com.osnirmaster.consumer.app.adapters.in.controller;

import br.com.osnirmaster.consumer.app.domain.Quote;
import br.com.osnirmaster.consumer.app.domain.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    public void createQuoteTest(final Quote quote ){
        quoteRepository.save(quote);
    }
}
