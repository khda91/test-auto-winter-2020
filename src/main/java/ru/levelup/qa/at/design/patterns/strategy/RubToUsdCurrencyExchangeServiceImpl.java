package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public class RubToUsdCurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private static final BigDecimal EXCHANGE_RATE = new BigDecimal(77.5);

    @Override
    public BigDecimal exchange(BigDecimal rubAmount) {
        return rubAmount.divide(EXCHANGE_RATE);
    }
}
