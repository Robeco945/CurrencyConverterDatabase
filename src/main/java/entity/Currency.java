package entity;

public class Currency {

    private String name, abreviation;
    private double toUSD;

    public Currency(String name, String abreviation, double toUSD) {
        this.name = name;
        this.abreviation = abreviation;
        this.toUSD = toUSD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }
    

    public double getToUSD() {
        return toUSD;
    }

    public void setToUSD(double toUSD) {
        this.toUSD = toUSD;
    }
}