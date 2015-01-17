package control;

import persistence.ExchangeRateLoader;
import model.Currency;
import model.Exchange;
import model.ExchangeRate;
import model.Money;
import process.Exchanger;
import ui.MoneyDisplay;
import ui.ExchangeDialog;

public class ExchangeOperation {
    
    private final ExchangeDialog dialog;

    public ExchangeOperation(ExchangeDialog dialog) {
        this.dialog = dialog;
    }
    
    public void execute() {
        Exchange exchange = readExchange();
        dialog.setTextToNull();
        ExchangeRate exchangeRate = readExchangeRate(exchange.getMoney().getCurrency(), exchange.getCurrency());
        Money money = exchangeMoney(exchange.getMoney(),exchangeRate);
        displayMoney(money);
    }

    private Exchange readExchange() {
        return dialog.getExchange();
    }
    
     private ExchangeRate readExchangeRate(Currency from, Currency to) {
        return new ExchangeRateLoader().load(from,to);
    }
    
    private Money exchangeMoney(Money money, ExchangeRate exchangeRate) {
        return new Exchanger(money,exchangeRate).calculate();
    }

    private void displayMoney(Money money) {
        new MoneyDisplay(money);
    }
}
