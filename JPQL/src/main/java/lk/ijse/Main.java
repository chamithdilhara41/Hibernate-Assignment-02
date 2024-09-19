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

        //insert query
        //no insert query in JPQL have to use save method

        // update query
        Query updateQuery = session.createQuery("UPDATE Student s SET s.name = :name WHERE s.sid = :sid");
        updateQuery.setParameter("name", "akintha chandinu");
        updateQuery.setParameter("sid", 1);
        updateQuery.executeUpdate();

        // delete query
        Query deleteQuery = session.createQuery("DELETE FROM Student s WHERE s.sid = :sid");
        deleteQuery.setParameter("sid", 1);
        deleteQuery.executeUpdate();

        // search by ID
        Query searchByIdQuery = session.createQuery("SELECT s FROM Student s WHERE s.sid = :sid", Student.class);
        searchByIdQuery.setParameter("sid", 1);
        Student foundStudent = (Student) searchByIdQuery.getSingleResult();

        if (foundStudent != null) {
            System.out.println("Found : " + foundStudent.getSid() + " | " + foundStudent.getName());
        } else {
            System.out.println("No records found");
        }

        //join query

        transaction.commit();
        session.close();
    }
}