package dao;

import entity.*;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CurrenciesDao {

    public void persist(Currency cur) {
        EntityManager cu = datasource.MariaDbJpaConnection.getInstance();
        cu.getTransaction().begin();
        cu.persist(cur);
        cu.getTransaction().commit();
    }
    public Currency find(int id) {
        EntityManager cu = datasource.MariaDbJpaConnection.getInstance();
        Currency cur = cu.find(Currency.class, id);
        return cur;
    }
    public List<Currency> findAll() {
        EntityManager cu = datasource.MariaDbJpaConnection.getInstance();
        List<Currency> curr = cu.createQuery("select e from Currency e").getResultList();
        return curr;
    }
    public void update(Currency cur) {
        EntityManager cu = datasource.MariaDbJpaConnection.getInstance();
        cu.getTransaction().begin();
        cu.merge(cur);
        cu.getTransaction().commit();
    }
    public void delete(Currency cur) {
        EntityManager cu = datasource.MariaDbJpaConnection.getInstance();
        cu.getTransaction().begin();
        cu.remove(cur);
        cu.getTransaction().commit();
    }






   /* public List<Currency> getAllCurrencies() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT name, abreviation, toUSD FROM currency";
        List<Currency> currencies = new ArrayList<Currency>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString(1);
                String abreviation = rs.getString(2);
                double toUSD = rs.getDouble(3);
                Currency cur = new Currency(name, abreviation, toUSD);
                currencies.add(cur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;
    }

    public Currency getCurrency(int id) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT name, abreviation, toUSD FROM currency WHERE id=?";

        String name = null;
        String abreviation = null;
        double toUSD = 0;
        int count = 0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                name = rs.getString(1);
                abreviation = rs.getString(2);
                toUSD = rs.getDouble(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count==1) {
            return new Currency(name, abreviation, toUSD);
        }
        else {
            return null;
        }
    }

    /*public void persist(Currency cur) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO currency (name, abreviation, toUSD) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cur.getName());
            ps.setString(2, cur.getAbreviation());
            ps.setDouble(3, cur.getToUSD());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
}
