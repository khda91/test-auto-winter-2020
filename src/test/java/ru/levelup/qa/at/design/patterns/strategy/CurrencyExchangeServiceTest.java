package ru.levelup.qa.at.design.patterns.strategy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CurrencyExchangeServiceTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
                {new RubToUsdCurrencyExchangeServiceImpl(), 155.0d, 2.0d },
                {new EurToUsdCurrencyExchangeServiceImpl(), 2.3d, 2.0d },
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testName(CurrencyExchangeService currencyExchangeService, Double amount, Double expected) {
        ExchangeService exchangeService = new ExchangeServiceImpl(currencyExchangeService);
        BigDecimal actual = exchangeService.exchange(new BigDecimal(amount));
        assertEquals(actual, new BigDecimal(expected));
    }
}
