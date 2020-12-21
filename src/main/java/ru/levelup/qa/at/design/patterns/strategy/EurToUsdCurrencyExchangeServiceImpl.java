package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public class EurToUsdCurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private static final BigDecimal EXCHANGE_RATE = new BigDecimal(1.15);

    @Override
    public BigDecimal exchange(BigDecimal eurAmount) {
        return eurAmount.divide(EXCHANGE_RATE);
    }
}
