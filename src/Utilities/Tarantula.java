package Utilities;
import SelectOptions.TarantulaOption;

public class Tarantula {

    // Taratula Variables
    private String name;
    private int dollarAmount;
    private int count;
    private TarantulaOption tarantulaOption;

    // Getters
    public String getName() {return name;}
    public int getDollarAmount() {return dollarAmount;}
    public int getCount() {return count;}
    public TarantulaOption getTarantulaOption() {return tarantulaOption;}

    // Setters
    private void setName(String tarantulaName) {name = tarantulaName;}
    private void setDollarAmount(int tarantulaAmount) {dollarAmount = tarantulaAmount;}
    private void setTarantulaOption(TarantulaOption option) {tarantulaOption = option;}

    // Counts
    public void increaseCount() {count++;}
    public void decreaseCount() {
        if (count > 0) {
            count--;
        }
    }
    
    // Object
    public Tarantula(String name, int dollarAmount) {
        setName(name);
        setDollarAmount(dollarAmount);
    }

    public void AddOption(TarantulaOption option) {
        setTarantulaOption(option);
    }
}
