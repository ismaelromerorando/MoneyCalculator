package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ExchangeOperation;
import persistence.CurrencySetLoader;
import model.CurrencySet;
import swing.ApplicationFrame;

public class Application {

    public static void main(String[] args) {
        CurrencySet currencySet = new CurrencySetLoader().load();
        final ApplicationFrame frame = new ApplicationFrame(currencySet);
        frame.register("Calculate", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new ExchangeOperation(frame.getDialog()).execute();
            }
            
        });
    }
    
}