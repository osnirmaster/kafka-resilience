package br.com.osnirmaster.producer.app.domain.repositories;

import br.com.osnirmaster.producer.app.domain.Quote;

public interface QuoteRepository {
    Quote save(Quote quote);
}
