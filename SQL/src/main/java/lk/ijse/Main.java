package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //insert query
        NativeQuery query = session.createNativeQuery("INSERT INTO student (sid,name) VALUES (?1,?2)");
        query.setParameter(1, 1);
        query.setParameter(2, "akintha");
        query.executeUpdate();

        NativeQuery query1 = session.createNativeQuery("INSERT INTO address VALUES (?1,?2,?3,?4,?5)");
        query1.setParameter(1, 1);
        query1.setParameter(2, 32);
        query1.setParameter(3, "galle road");
        query1.setParameter(4, "galle city");
        query1.setParameter(5,1);
        query1.executeUpdate();

        //update query
        NativeQuery query2 = session.createNativeQuery("UPDATE student SET name=?2 WHERE id=?1");
        query2.setParameter(1, "akintha chandinu");
        query2.executeUpdate();

        //delete query
        NativeQuery query3 = session.createNativeQuery("DELETE FROM student WHERE id=?");
        query3.setParameter(1,1);
        query3.executeUpdate();

        //searchById
        NativeQuery query4 = session.createNativeQuery("SELECT * FROM student WHERE sid=?1", Student.class);
        query4.setParameter(1,1);

        Student searchId = (Student) query4.uniqueResult();

        if (searchId != null) {
            System.out.println("Found : "+searchId.getSid()+"|"+searchId.getName());
        }else {
            System.out.println("No records found");
        }

        //join query


        transaction.commit();
        session.close();
    }
}