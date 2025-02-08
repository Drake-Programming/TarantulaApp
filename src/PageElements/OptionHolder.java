package PageElements;
import javax.swing.JPanel;

import Display.Page;
import SelectOptions.CartOption;
import SelectOptions.TarantulaOption;
import SelectOptions.TypeOption;

public class OptionHolder extends JPanel{
    private Page page;

    private void setPage(Page holderPage) {page = holderPage;}
    public Page getPage() {return page;}

    public OptionHolder(Page page) {
        setPage(page);
    }

    // Instantiate Object and arrays
    public OptionHolder(TypeOption[] typeOptions, Page page) {
        setPage(page);
        //setTypeOptions(typeOptions);
        for (TypeOption option: typeOptions) {
            add(option);
        }
    }

    public OptionHolder(TarantulaOption[] tarantulaOptions, Page page) {
        setPage(page);
        //setTarantulaOptions(tarantulaOptions);
        for (TarantulaOption option: tarantulaOptions) {
            option.AddHolder(this);
            add(option);
        }
    }

    public OptionHolder(CartOption[] cartOptions, Page page) {
        setPage(page);
        //setCartOption(cartOptions);
        for (CartOption option: cartOptions) {
            option.AddHolder(this);
            add(option);
        }
    }
}
