package br.com.osnirmaster.producer.app.adapters.out.api;

import br.com.osnirmaster.producer.app.domain.service.CoverTax;
import org.springframework.stereotype.Component;

@Component
public class CoverTaxProduct implements CoverTax {
    @Override
    public double getCoverTax(String productCode) {
        return 0.05;
    }
}
