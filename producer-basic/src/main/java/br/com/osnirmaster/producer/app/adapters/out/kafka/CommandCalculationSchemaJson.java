package br.com.osnirmaster.producer.app.adapters.out.kafka;


import br.com.osnirmaster.producer.app.domain.CreditContract;
import br.com.osnirmaster.producer.app.domain.Quote;

public class CommandCalculationSchemaJson {

    private String customerId;
    private String quoteId;
    private String productCode;
    private Double coverTax;
    private CreditContract creditContract;


    public CommandCalculationSchemaJson(@org.jetbrains.annotations.NotNull Quote quote){
        this.customerId = quote.getCustomerId();
        this.quoteId = quote.getQuoteId();
        this.productCode = quote.getproductCode();
        this.coverTax = quote.getCoverTax();
    }


    public void addCreditContract(CreditContract contract){
        this.creditContract = contract;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public Double getCoverTax() {
        return coverTax;
    }

    public CreditContract getCreditContract() {
        return creditContract;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
