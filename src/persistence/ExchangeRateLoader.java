package persistence;

import java.util.ArrayList;
import model.Currency;
import model.ExchangeRate;

public class ExchangeRateLoader {
    ArrayList<String> currency;
    ArrayList<Double> rate;
    
    public ExchangeRate load(Currency from, Currency to) {
        setExchangeRate();
        return new ExchangeRate(from,to,calculateRate(from,to));
    }

    private void setExchangeRate() {
        addCurrency();
        addRate();
    }

    private void addCurrency() {
        currency = new ArrayList<>();
        currency.add("EUR");
        currency.add("USD");
        currency.add("GBP");
    }

    private void addRate() {
        rate = new ArrayList<>();
        rate.add(1.0);
        rate.add(1.244325);
        rate.add(0.79610815);
    }

    public double calculateRate(Currency from, Currency to) {
        return (1/rate.get(currency.indexOf(from.getCode()))) * rate.get(currency.indexOf(to.getCode()));
    }
    
}
