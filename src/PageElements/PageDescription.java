package PageElements;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Display.Page;

public class PageDescription extends JPanel{
    private JLabel description;

    public PageDescription(Page page) {
        description = new JLabel(page.getDescription());
        add(description);
    }
}
