import javax.swing.SwingUtilities;
import Display.AppFrame;
import Display.Page;
import PageElements.CartPrintButton;
import PageElements.CartTotalLabel;
import SelectOptions.CartOption;
import SelectOptions.TarantulaOption;
import SelectOptions.TypeOption;
import Utilities.OptionMaker;

public class App {
    // Make application frame
    AppFrame frame;

    // Make application pages
    Page homePage;
    Page cartPage;
    Page arborealPage;
    Page terrestrialPage;
    Page fossorialPage;

    // Name arrays for Tarantulas
    String[] arborealNames  = {
        "Common Pinktoe", "Gooty Sapphire Ornamental", "Indian Ornamental", "Venezuelan Suntiger", "Peru Purple Pinktoe", "Ecuador Purple Pinktoe",
        "Antilles Pinktoe", "Highland Ornamental", "Lowland Ornamental", "Wessels Tiger Ornamental", "Trinidad Chevron", "Panama Blond",
        "Costa Rican Orange Mouth"
    };
    String[] terrestrialNames = {
        "Chilean Rose Hair", "Mexican Red Knee", "Curly Hair Tarantula", "Brazilian Black", "Arizona Blonde", "Mexican Fireleg", 
        "Honduran Curly Hair", "Chaco Golden Knee", "Pink Zebra Beauty", "Green Bottle Blue", "Brazilian Giant White Knee", "Salmon Pink Birdeater",
        "Brazilian Red & White", "Ecuadorian Birdeater", "Goliath Birdeater", "Burgundy Goliath Birdeater"
    };
    String[] fossorialNames = {
        "Cobalt Blue Tarantula", "Chinese Earth Tiger", "King Baboon", "Mombasa Golden Starburst", "Socotra Island Blue Baboon", "Thailand Black",
        "Golden Blue Leg Baboon", "Rear-Horned Baboon", "Straight-Horned Baboon", "Vietnam Blue"
    };

    // Price arrays for tarantulas
    int[] arborealPrices = {130, 210, 190, 120, 300, 200, 100, 160, 170, 150, 300, 350, 120};
    int[] terrestrialPrices = {40, 50, 25, 150, 80, 120, 140, 35, 400, 150, 160, 120, 50, 200, 130, 45};
    int[] fossorialPrices = {80, 150, 50, 90, 120, 210, 110, 170, 130, 70};

    OptionMaker maker;
    CartTotalLabel cartTotal;
    TarantulaOption[] arborealOptions;
    TarantulaOption[] terrestrialOptions;
    TarantulaOption[] fossorialOptions;
    TypeOption[] typeOptions;
    CartOption[] cartOptions;
    CartPrintButton printButton;
    
    public App() {
        // Instaniate Application
        frame = new AppFrame("Tarantula Sellers");
        homePage = new Page("Home", "Buy our tarantulas! They come far and wide!", frame);
        cartPage = new Page("Cart", null, frame);
        arborealPage = new Page("Arboreal", "Arboreal Tarantulas live above the ground", frame);
        terrestrialPage = new Page("Terrestrial", "Terrestrial Tarantulas live on the ground", frame);
        fossorialPage = new Page("Fossorial", "Fossorial Tarantulas live underneath the ground", frame);
        Page[] pages = {arborealPage, terrestrialPage, fossorialPage};
        
        maker = new OptionMaker();
        arborealOptions = maker.Make(arborealNames, arborealPrices);
        terrestrialOptions = maker.Make(terrestrialNames, terrestrialPrices);
        fossorialOptions = maker.Make(fossorialNames, fossorialPrices);
        typeOptions = maker.Make(pages);

        // Update pages with vertical option holders
        arborealPage.UpdateHolder(arborealOptions);
        terrestrialPage.UpdateHolder(terrestrialOptions);
        fossorialPage.UpdateHolder(fossorialOptions);
        homePage.UpdateHolder(typeOptions);

        // Add cart total label
        cartTotal = new CartTotalLabel(cartPage);
        cartPage.AddTotalLabel(cartTotal);

        // Add Buy button to cart
        printButton = new CartPrintButton(cartPage);
        cartPage.add(printButton);

        frame.add(homePage);
        frame.add(arborealPage);
        frame.add(terrestrialPage);
        frame.add(fossorialPage);
        frame.add(cartPage);
    }
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}
