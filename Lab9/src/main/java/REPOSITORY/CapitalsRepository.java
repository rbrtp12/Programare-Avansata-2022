package REPOSITORY;

import UTIL.HibernateUtil;
import VIEWS.CapitalsEntity;
import VIEWS.CountriesEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CapitalsRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void createCapital(String name, double latitude, double longitude, int country) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "student");

        session.beginTransaction();

        CapitalsEntity capitalsEntity = new CapitalsEntity();
        capitalsEntity.setName(name);
        capitalsEntity.setLatitude(latitude);
        capitalsEntity.setLongitude(longitude);
        capitalsEntity.setCountry(country);

        session.persist(capitalsEntity);
        session.getTransaction().commit();
        session.close();

    }

    public CapitalsEntity findCapitalById(int id) throws SQLException {
        Session session = null;
        CapitalsEntity capital = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            capital =  session.get(CapitalsEntity.class,
                    id);
            Hibernate.initialize(capital);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return capital;

    }


}
