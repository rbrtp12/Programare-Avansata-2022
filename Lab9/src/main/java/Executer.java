import REPOSITORY.CapitalsRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Executer {
    public static void main(String args[]) throws SQLException {

        CapitalsRepository capitalsRepository = new CapitalsRepository();

        //capitalsRepository.createCapital("Capitala mea", 12.00, 12.00, 1);
        System.out.println(capitalsRepository.findCapitalById(2).toString());
    }
}
