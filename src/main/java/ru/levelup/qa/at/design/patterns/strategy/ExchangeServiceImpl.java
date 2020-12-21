package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public class ExchangeServiceImpl implements ExchangeService {

    private CurrencyExchangeService currencyExchangeService;

    public ExchangeServiceImpl(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @Override
    public BigDecimal exchange(BigDecimal amount) {
        return currencyExchangeService.exchange(amount);
    }
}
