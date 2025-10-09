package application;
import dao.CurrenciesDao;
import dao.TransactionDao;
import entity.Currency;
import entity.Transaction;
import view.ConverterGUI;
import entity.Converter;

import java.util.*;

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

        if(from == null || to == null) {
            throw new IllegalArgumentException("Currency not found!");
        }

        double exchangeRate = from.getToUSD() / to.getToUSD();
        converter.setExchangeRate(exchangeRate);
        converter.setIn(in);
        double result = converter.convert();

        // Save transaction
        TransactionDao txDao = new TransactionDao();
        txDao.persist(new Transaction(in, from, to));

        return result;
    }






    private int i = 0;
    private int ii = 0;
    ArrayList<String> currenciesChoice = new ArrayList<>(Arrays.asList("EUR","USD","VND","GBP","JPY","CNY","CHF","AUD"));
    ArrayList<String> currenciessChoice = new ArrayList<>(Arrays.asList("EUR","USD","VND","GBP","JPY","CNY","CHF","AUD"));
    public void addtoBut1(String abre){
        currenciesChoice.add(abre);
    }
    public void addtoBut2(String abre){
        currenciessChoice.add(abre);
    }
    public String change1(){
        i = (i + 1) % currenciesChoice.size();
        return currenciesChoice.get(i);
    }

    public String change2(){
        ii = (ii + 1) % currenciessChoice.size();
        return currenciessChoice.get(ii);
    }

}