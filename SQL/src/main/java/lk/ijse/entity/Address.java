package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
    @Id
    private int aid;
    private String no;
    private String road;
    private String city;

    @ManyToOne
    private Student student;

    public Address() {
    }

    public Address(int aid, String no, String road, String city, Student student) {
        this.aid = aid;
        this.no = no;
        this.road = road;
        this.city = city;
        this.student = student;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", no='" + no + '\'' +
                ", road='" + road + '\'' +
                ", city='" + city + '\'' +
                ", student=" + student +
                '}';
    }
}
