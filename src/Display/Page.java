package Display;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import PageElements.CartTotalLabel;
import PageElements.OptionHolder;
import PageElements.PageDescription;
import PageElements.PageHeader;
import SelectOptions.CartOption;
import SelectOptions.TarantulaOption;
import SelectOptions.TypeOption;

public class Page extends JPanel {

    // Declare components and title
    private String title;
    private String description;
    private PageHeader pageHeader;
    private PageDescription pageDescription;
    private OptionHolder optionHolder;
    private CartTotalLabel totalLabel;
    public AppFrame frame;

    // Getters and setters
    private void setCartTotalLabel(CartTotalLabel label) {totalLabel = label;}
    public CartTotalLabel getCartTotalLabel() {return totalLabel;}

    private void setTitle(String pageTitle) {title = pageTitle;}
    public String getTitle() {return title;}

    private void setDescription(String pageDescription) {description = pageDescription;}
    public String getDescription() {return description;}

    // Instaniate Page
    public Page(String title, String description, AppFrame appFrame) {
        setTitle(title);
        setDescription(description);
        frame = appFrame;
        pageHeader = new PageHeader(this);
        pageDescription = new PageDescription(this);
        optionHolder = new OptionHolder(this);

        // Add components
        add(pageHeader);
        add(pageDescription);
        add(optionHolder);
    }

    public void AddTotalLabel(CartTotalLabel totalLabel) {
        setCartTotalLabel(totalLabel);
        add(totalLabel);
    }

    public void UpdateHolder(TypeOption[] options) {
        remove(optionHolder);
        optionHolder = new OptionHolder(options, this);
        optionHolder.setLayout(new BoxLayout(optionHolder, BoxLayout.Y_AXIS));
        add(optionHolder);
    }

    public void UpdateHolder(TarantulaOption[] options) {
        remove(optionHolder);
        optionHolder = new OptionHolder(options, this);
        optionHolder.setLayout(new BoxLayout(optionHolder, BoxLayout.Y_AXIS));
        add(optionHolder);
    }

    public void UpdateHolder(CartOption[] options) {
        remove(optionHolder);
        optionHolder = new OptionHolder(options, this);
        optionHolder.setLayout(new BoxLayout(optionHolder, BoxLayout.Y_AXIS));
        add(optionHolder);
    }
}
