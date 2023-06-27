package br.com.osnirmaster.producer.app.configuration.db.repositories;

import br.com.osnirmaster.producer.app.domain.Quote;
import br.com.osnirmaster.producer.app.domain.repositories.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class QuoteRepositoryFake implements QuoteRepository {
    @Override
    public Quote save(Quote quote) {
        log.info("store quote: {}", quote);
        return  quote;
    }
}
