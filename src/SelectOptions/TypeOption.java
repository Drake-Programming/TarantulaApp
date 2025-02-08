package SelectOptions;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Display.Page;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypeOption extends JPanel{

    // Declare components 
    private Page page;
    private JButton buttonGoPage;
    private JLabel labelDescription;

    private void setPage(Page typePage) {page = typePage;}
    public Page getPage() {return page;}
    
    public TypeOption(Page page) {
        setPage(page);
        buttonGoPage = new JButton(page.getTitle());
        labelDescription = new JLabel(page.getDescription());

        buttonGoPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page.frame.SwitchPage(page.getTitle());
            }
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(buttonGoPage);
        add(labelDescription);
    }
}
