package datasource;
import jakarta.persistence.*;

public class MariaDbJpaConnection {

    private static EntityManagerFactory cuf = null;
    private static EntityManager cu = null;

    public static EntityManager getInstance() {
        if (cu==null) {
            if (cuf==null) {
                cuf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
            }
            cu = cuf.createEntityManager();
        }
        return cu;
    }
}