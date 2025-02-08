package PageElements;

import javax.swing.JLabel;
import Display.Page;
import SelectOptions.CartOption;

public class CartTotalLabel extends JLabel {
    private Page cartPage;
    CartOption[] options;

    // Getter/ Setter
    private void setPage(Page page) {cartPage = page;}
    Page getPage() {return cartPage;}

    // Instantiate Label
    public CartTotalLabel(Page cartPage) {
        setPage(cartPage);
    }

    // Updates label to show correct cart total
    public void UpdateTotal() {
        int count = 0;
        options = getPage().frame.GetCart();

        for (CartOption option: options) {
            count += option.getTarantula().getCount() * option.getTarantula().getDollarAmount();
        }
        setText("Total Cart: $" + count);
    }
}
