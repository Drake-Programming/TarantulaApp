package SelectOptions;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PageElements.OptionHolder;
import Utilities.Tarantula;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarantulaOption extends JPanel {

    // Declare components 
    private JLabel labelName;
    private JLabel labelAmount;
    private JLabel labelCount;
    private JButton buttonBuy;
    private JButton buttonSell;
    private OptionHolder holder;
    private Tarantula tarantula;


    private void setHolder(OptionHolder optionHolder) {holder = optionHolder;}
    private void setTarantula(Tarantula optionTarantula) {tarantula = optionTarantula;}

    public OptionHolder getHolder() {return holder;}
    public Tarantula getTarantula() {return tarantula;}

    // Instatiate TarantulaOption
    public TarantulaOption(Tarantula tarantula) {

        // Instatiate components
        labelName = new JLabel(tarantula.getName());
        labelAmount = new JLabel("$" + tarantula.getDollarAmount());
        labelCount = new JLabel(String.valueOf(tarantula.getCount()));
        buttonBuy = new JButton("+");
        buttonSell = new JButton("-");
        setTarantula(tarantula);

        // When the buy button is pressed increase tarantula count and update label
        buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarantula.increaseCount();
                UpdateCountLabel();
                getHolder().getPage().frame.cart.getCartTotalLabel().UpdateTotal();
                if (tarantula.getCount() == 1){
                    //Add tarantula to site cart
                    getHolder().getPage().frame.cartTarantulas.add(tarantula);
                }
            }
        });

        // When the buy button is pressed decrease tarantula count and update label
        buttonSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tarantula.decreaseCount();
                UpdateCountLabel();
                getHolder().getPage().frame.cart.getCartTotalLabel().UpdateTotal();
                if (tarantula.getCount() == 0) {
                    //Remove tarantula from site cart
                    getHolder().getPage().frame.cartTarantulas.remove(tarantula);
                }
            }
        });

        // Add components
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(labelName);
        add(labelAmount);
        add(buttonBuy);
        add(buttonSell);
        add(labelCount);
    }

    public void AddHolder(OptionHolder holder) {
        setHolder(holder);
    }

    void UpdateCountLabel() {
        labelCount.setText(String.valueOf(tarantula.getCount()));
    }
}
