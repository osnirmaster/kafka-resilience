package br.com.osnirmaster.consumer.app.adapters.out.api;

import br.com.osnirmaster.consumer.app.domain.service.CoverTax;
import org.springframework.stereotype.Component;

@Component
public class CoverTaxProduct implements CoverTax {
    @Override
    public double getCoverTax(String productCode) {
        return 0.05;
    }
}
