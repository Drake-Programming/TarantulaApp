package Display;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;

import SelectOptions.CartOption;
import Utilities.OptionMaker;
import Utilities.Tarantula;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
    private CardLayout pageLayout;
    private JPanel pagePanels;
    public List<Tarantula> cartTarantulas = new ArrayList<>();
    OptionMaker maker;
    public Page cart;

    // Gets cart from cart page
    public CartOption[] GetCart() {return maker.MakeCartOption(cartTarantulas);}

    // Adds page to frame
    public void add(Page page) {
        page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));
        pagePanels.add(page, page.getTitle());
        if (page.getTitle() == "Cart") {
            cart = page;
        }
    }

    // Switches page
    public void SwitchPage(String page) {
        pageLayout.show(pagePanels, page);
    }

    public AppFrame(String title) {
        super(title);
        maker = new OptionMaker();
        pageLayout = new CardLayout();
        pagePanels = new JPanel(pageLayout);

        // Set Window Defaults
        add(pagePanels);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);  // center on screen
        setSize(500, 600);

        // Makes the window scrollable
        JScrollPane scrollPane = new JScrollPane(
                pagePanels,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        // Use the scroll pane as the content pane
        setContentPane(scrollPane);
    }
}
