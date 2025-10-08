import dao.CurrenciesDao;
import entity.Currency;
import view.ConverterGUI;
public class Curvert {
    public static void main(String[] arg){
        CurrenciesDao cur = new CurrenciesDao();
        //cur.persist(new Currency("newName", "abre", 20));
        ConverterGUI.launch(ConverterGUI.class);
    }
}
