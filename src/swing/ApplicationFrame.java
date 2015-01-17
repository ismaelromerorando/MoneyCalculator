package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.CurrencySet;
import ui.ExchangeDialog;

public class ApplicationFrame extends JFrame {
    
    private final CurrencySet currencySet;
    private final Map<String,ActionListener> receivers;
    private ExchangeDialog exchangeDialog;

    public ApplicationFrame(CurrencySet currencySet) {
        super("Money Calculator");
        this.setLocationRelativeTo(null);
        this.currencySet = currencySet;
        this.receivers = new HashMap<>();       
        this.setSize(300,150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        this.setVisible(true);
    }

    public void register(String command, ActionListener actionListener) {
        this.receivers.put(command, actionListener);
    }

    public ExchangeDialog getDialog() {
        return exchangeDialog;
    }

    private void createComponents() {
        this.add(createDialog());
        this.add(createToolbarPanel(), BorderLayout.SOUTH);
    }
    
    private JPanel createToolbarPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createCalculateButton());
        return panel;
    }
    
    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(createListener("Calculate"));
        return button;
    }

    private ActionListener createListener(final String text) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                receivers.get(text).actionPerformed(event);
            }
        };
    }

    private JPanel createDialog() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencySet);
        this.exchangeDialog = panel;
        return panel;
    }

}
