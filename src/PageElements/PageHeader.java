package PageElements;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Display.Page;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageHeader extends JPanel {

    // Declare components 
    private JButton buttonHome;
    private JButton buttonCart;
    private JLabel labelTitle;

    // Instatiate CartOption
    public PageHeader(Page page) {

        // Instatiate components
        buttonHome = new JButton("Home");
        buttonCart = new JButton("Cart");
        labelTitle = new JLabel(page.getTitle());

        // When button is pressed switch page
        buttonHome.addActionListener(_ -> page.frame.SwitchPage("Home"));
        buttonCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page.frame.SwitchPage("Cart");
                page.frame.cart.UpdateHolder(page.frame.GetCart());
            }
        });

        // Add components
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(buttonHome);
        add(Box.createHorizontalGlue());
        add(labelTitle);
        add(Box.createHorizontalGlue());
        add(buttonCart);
    }
}
