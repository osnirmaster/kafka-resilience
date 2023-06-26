package br.com.osnirmaster.consumer.app.domain.repositories;

import br.com.osnirmaster.consumer.app.domain.Quote;
import br.com.osnirmaster.consumer.app.domain.QuoteId;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository {
    Quote save(Quote quote);
}
