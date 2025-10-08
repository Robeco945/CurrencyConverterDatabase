package application;
import dao.CurrenciesDao;
import entity.Currency;
import view.ConverterGUI;
import entity.Converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConverterController{
    private Converter converter = new Converter();
    private ConverterGUI gui = new ConverterGUI();
    private Map<String, Currency> currencies;
    private CurrenciesDao dao = new CurrenciesDao();
    private double out;
    public ConverterController(ConverterGUI gui){
        this.gui = gui;

        currencies = new HashMap<>();
        List<Currency> currencyList = dao.findAll();

        for(Currency cur :  currencyList){
            currencies.put(cur.getAbreviation(),cur);
        }
    }



    /*public double convert(double in, String currencyIn, String currencyOut){
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
    }*/

    public double convert(double in, String currencyIn, String currencyOut){
        Currency from = currencies.get(currencyIn);
        Currency to = currencies.get(currencyOut);
        double exchangeRate = from.getToUSD() / to.getToUSD();
        converter.setExchangeRate(exchangeRate);
        converter.setIn(in);
        converter.setOut(out);
        return converter.convert();

    }





    private int i = 0;
    private int ii = 0;
    private final String[] currenciesChoice = {"EUR","USD","VND","GBP","JPY","CNY","CHF","AUD"};
    private final String[] currenciessChoice = {"EUR","USD","VND","GBP","JPY","CNY","CHF","AUD"};
    public String change1(){
        i = (i + 1) % 8;
        return currenciesChoice[i];
    }

    public String change2(){
        ii = (ii + 1) % 8;
        return currenciessChoice[ii];
    }

}