package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Student {

    @Id
    private int sid;
    private String name;

    @OneToMany(mappedBy = "student")
    private List<Address> addresses;

    public Student() {
    }

    public Student(int sid, String name, List<Address> addresses) {
        this.sid = sid;
        this.name = name;
        this.addresses = addresses;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
