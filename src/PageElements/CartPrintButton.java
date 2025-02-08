package PageElements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Display.Page;
import SelectOptions.CartOption;

public class CartPrintButton extends JButton {
    private Page cartPage;
    CartOption[] options;
    
    // Getter/ Setter
    private void setPage(Page page) {cartPage = page;}
    Page getPage() {return cartPage;}

    // Instantiate Button
    public CartPrintButton(Page cartPage) {
        setPage(cartPage);
        setText("Buy");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintReceipt();
                DownloadReceipt();
            }
        });
    }

    // Print receipt in console
    public void PrintReceipt() {
       options = getPage().frame.GetCart();
       System.out.println("Bought:");
        String name;
        int count;
        int amount;
        int grandTotal = 0;

       for (CartOption option: options) {
        name = option.getTarantula().getName();
        count = option.getTarantula().getCount();
        amount = option.getTarantula().getDollarAmount();
        grandTotal += (count * amount);

        System.out.printf("%d %s total: $%d\n", count, name, count * amount);
       }
       System.out.printf("Grand Total: $%d", grandTotal);
    }

    // Print receipt into txt file
    public void DownloadReceipt() {
        options = getPage().frame.GetCart();
        try (PrintWriter writer = new PrintWriter(new FileWriter("receipt.txt"))) {
            writer.println("Bought:");
            int grandTotal = 0;

            for (CartOption option : options) {
                String name = option.getTarantula().getName();
                int count = option.getTarantula().getCount();
                int amount = option.getTarantula().getDollarAmount();
                int total = count * amount;
                grandTotal += total;

                writer.printf("%d %s total: $%d%n", count, name, total);
            }
            writer.printf("Grand Total: $%d", grandTotal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
