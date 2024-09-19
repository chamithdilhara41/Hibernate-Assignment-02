package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        // insert query
        Query insertQuery = session.createQuery("INSERT INTO Student (sid, name) VALUES (:sid, :name)");
        insertQuery.setParameter("sid", 1);
        insertQuery.setParameter("name", "akintha");
        insertQuery.executeUpdate();

        // update query
        Query updateQuery = session.createQuery("UPDATE Student SET name = :name WHERE sid = :sid");
        updateQuery.setParameter("name", "akintha chandinu");
        updateQuery.setParameter("sid", 1);
        updateQuery.executeUpdate();

        // delete query
        Query deleteQuery = session.createQuery("DELETE FROM Student WHERE sid = :sid");
        deleteQuery.setParameter("sid", 1);
        deleteQuery.executeUpdate();

        // search by ID
        Query<Student> searchByIdQuery = session.createQuery("FROM Student WHERE sid = :sid", Student.class);
        searchByIdQuery.setParameter("sid", 1);

        Student searchId = searchByIdQuery.uniqueResult();

        if (searchId != null) {
            System.out.println("Found : " + searchId.getSid() + "|" + searchId.getName());
        } else {
            System.out.println("No records found");
        }

        //join query

        transaction.commit();
        session.close();
    }
}