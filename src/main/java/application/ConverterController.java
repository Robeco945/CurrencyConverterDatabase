package application;
import view.ConverterGUI;
import entity.Converter;

public class ConverterController{
    private Converter converter = new Converter();
    private ConverterGUI gui = new ConverterGUI();

    private double out;

    public ConverterController(ConverterGUI gui){
        this.gui = gui;
    }
    public double convert(double in, String currencyIn, String currencyOut){
        if(currencyIn.equals("EUR") && currencyOut.equals("VND")){
            converter.setExchangeRate(30000);
            converter.setIn(in);
            out = converter.convert();
        }
        else if(currencyIn.equals("VND") && currencyOut.equals("EUR")){
            converter.setExchangeRate((double) 1 /30000);
            converter.setIn(in);
            out = converter.convert();
        }
        else if(currencyIn.equals("USD") && currencyOut.equals("VND")){
            converter.setExchangeRate(26400);
            converter.setIn(in);
            out = converter.convert();
        }
        else if(currencyIn.equals("VND") && currencyOut.equals("USD")){
            converter.setExchangeRate((double) 1 /26400);
            converter.setIn(in);
            out = converter.convert();
        }
        else if(currencyIn.equals("USD") && currencyOut.equals("EUR")){
            converter.setExchangeRate(1/1.18);
            converter.setIn(in);
            out = converter.convert();
        }
        else if(currencyIn.equals("EUR") && currencyOut.equals("USD")){
            converter.setExchangeRate(1.18);
            converter.setIn(in);
            out = converter.convert();
        }
        else if(currencyIn.equals(currencyOut)){
            converter.setExchangeRate(1);
            converter.setIn(in);
            out = converter.convert();
        }
        return out;
    }
    private int i = 0;
    private int ii = 0;
    private final String[] currencies = {"EUR","USD","VND"};
    private final String[] currenciess = {"EUR","USD","VND"};

    public String change1(){
        i = (i + 1) % 3;
        return currencies[i];
    }

    public String change2(){
        ii = (ii + 1) % 3;
        return currenciess[ii];
    }

}