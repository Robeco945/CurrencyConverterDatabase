package entity;
public class Converter{
    private double in;
    private double out;
    private String currencyIn;
    private String currencyOut;
    private double exchangeRate;

    public void setCurrencyIn(String currencyIn){
        this.currencyIn = currencyIn;
    }
    public void setCurrencyOut(String currencyOut){
        this.currencyOut = currencyOut;
    }
    public void setIn(double in){
        this.in = in;
    }
    public void setOut(double out){
        this.out = out;
    }
    public double getOut(){
        return out;
    }

    public void setExchangeRate(double er){
        exchangeRate = er;
    }
    public double getExchangeRate(){
        return exchangeRate;
    }
    public double convert(){
        out = in*exchangeRate;
        return out;
    }
}