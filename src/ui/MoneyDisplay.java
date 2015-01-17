package ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Money;

public class MoneyDisplay extends JFrame{
    Money money;

    public MoneyDisplay(Money money) {
        super("Exchange");
        setDetails();
        this.setLocationRelativeTo(null);
        createComponents(money);
    }

    private void createComponents(Money money) {
        MoneyDisplay.this.add(new JLabel(writeMoney(money)),BorderLayout.WEST);
    }

    private void setDetails() {
        MoneyDisplay.this.setDefaultCloseOperation(MoneyDisplay.DISPOSE_ON_CLOSE);
        MoneyDisplay.this.setSize(250,100);
        MoneyDisplay.this.setVisible(true);
    }
    
    private String writeMoney(Money money) {
       if(String.valueOf(money.getAmount()).contains(".") && money.getAmount() != 0.0) {
            return(String.valueOf(money.getAmount()).substring(0, String.valueOf(money.getAmount()).indexOf(".") + 3)
            + " " + money.getCurrency().getCode());
        } else {
            return (String.valueOf(money.getAmount()) + "0 " + money.getCurrency().getCode());
        }
    }
}
