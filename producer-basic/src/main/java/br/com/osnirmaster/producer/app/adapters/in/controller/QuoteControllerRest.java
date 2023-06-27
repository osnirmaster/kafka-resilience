package br.com.osnirmaster.producer.app.adapters.in.controller;

import br.com.osnirmaster.producer.app.adapters.in.dto.RequestQuote;
import br.com.osnirmaster.producer.app.domain.Quote;
import br.com.osnirmaster.producer.app.domain.usecase.GetQuoteCalculation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/insurance/quote")
public class QuoteControllerRest {

    @Autowired
    private GetQuoteCalculation getQuoteCalculation;

    @PostMapping
    public ResponseEntity price(@RequestBody RequestQuote request, UriComponentsBuilder uriBuilder) throws ExecutionException, InterruptedException {

        Quote quote = getQuoteCalculation.insuranceQuote(request.convertTo());
        URI uri = uriBuilder.path("/quote/{id}").buildAndExpand(quote.getQuoteId()).toUri();

        return ResponseEntity.created(uri).body(uri);
    }
}
