package entity;
import jakarta.persistence.*;
@Entity
@Table(name="currency")

public class Currency {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="name")
    private String name;
    @Column(name = "abreviation")
    private String abreviation;
    private double toUSD;

    public Currency(String name, String abreviation, double toUSD) {
        this.name = name;
        this.abreviation = abreviation;
        this.toUSD = toUSD;
    }

    public Currency(){}
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