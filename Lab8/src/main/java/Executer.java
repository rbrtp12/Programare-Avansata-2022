
import DAO.DbInsert;
import DAO.DbSelect;
import Views.CapitalsView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileNotFoundException;

public class Executer {
    public static void main(String args[]) throws FileNotFoundException {

        //DbInsert.insertContinent("Europa");
       /* DbInsert.insertContinent("Africa");
        DbInsert.insertContinent("South America");
        DbInsert.insertContinent("North America");
        DbInsert.insertContinent("Asia");
        DbInsert.insertContinent("Antarctica");
        DbInsert.insertContinent("Oceania");*/
        /*CapitalsView capital1 = new CapitalsView();
        CapitalsView capital2 = new CapitalsView();
        DbSelect.findCapitalById(capital1, 5);
        DbSelect.findCapitalById(capital2, 6);
        DbSelect.capitalsDistance(capital1, capital2);*/
        //DbInsert.insertCountryFromCSV("D:\\facultate\\an3\\Java\\Lab8\\concap.csv");
        //DbInsert.insertCapitalFromCSV("D:\\facultate\\an3\\Java\\Lab8\\concap.csv");
        //DbSelect.findCountryById(1);
    }
}
