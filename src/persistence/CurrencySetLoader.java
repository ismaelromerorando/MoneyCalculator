package persistence;

import model.Currency;
import model.CurrencySet;

public class CurrencySetLoader {
    private final CurrencySet currencySet;
    
    public CurrencySetLoader() {
        currencySet = new CurrencySet();
    }
    
    public CurrencySet load() {
        currencySet.add(new Currency("EUR","Euro","€"));
        currencySet.add(new Currency("USD", "Dollar", "$"));
        currencySet.add(new Currency("GBP", "Pound", "£"));
        return currencySet;
    }
}
