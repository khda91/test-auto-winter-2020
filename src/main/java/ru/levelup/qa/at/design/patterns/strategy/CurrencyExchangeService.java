package ru.levelup.qa.at.design.patterns.strategy;

import java.math.BigDecimal;

public interface CurrencyExchangeService {

    BigDecimal exchange(BigDecimal amount);
}
