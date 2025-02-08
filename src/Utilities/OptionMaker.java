package Utilities;
import java.util.List;

import Display.Page;
import SelectOptions.CartOption;
import SelectOptions.TarantulaOption;
import SelectOptions.TypeOption;

public class OptionMaker {

    // Makes an array TypeOptions out of an array Pages
    public TypeOption[] Make(Page[] pages) {

        TypeOption[] typeOptions = new TypeOption[pages.length];

        for (int i = 0; i < pages.length; i++) {
            typeOptions[i] = new TypeOption(pages[i]);
        }
        return typeOptions;
    }

    // Makes an array TarantulaOptions out of an array Tarantulas
    public TarantulaOption[] Make(Tarantula[] tarantulas) {
        
        TarantulaOption[] TarantulaOptions = new TarantulaOption[tarantulas.length];

        for (int i = 0; i < tarantulas.length; i++) {
            TarantulaOptions[i] = new TarantulaOption(tarantulas[i]);
            tarantulas[i].AddOption(TarantulaOptions[i]);
        }
        return TarantulaOptions;
    }

    // Makes an array Tarantulas out of arrays of names and dollar amounts
    public TarantulaOption[] Make(String[] names, int[] dollarAmount) {
        
        Tarantula[] tarantulas = new Tarantula[names.length];

        for (int i = 0; i < names.length; i++) {
            tarantulas[i] = new Tarantula(names[i], dollarAmount[i]);
        }
        return Make(tarantulas);
    }

    // Makes an array CartOptions out of an array Tarantulas
    public CartOption[] MakeCartOption(List<Tarantula> tarantulas) {
        
        CartOption[] cartOptions = new CartOption[tarantulas.size()];

        for (int i = 0; i < tarantulas.size(); i++) {
            cartOptions[i] = new CartOption(tarantulas.get(i));
        }
        return cartOptions;
    }
}
