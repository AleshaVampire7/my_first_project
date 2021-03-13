package Entities;
//Object of our app
public class Student {
    protected int id;
    protected String name;
    protected String surename;
    protected String adress;
    protected String city;
    protected String distinct;
    protected String accname;
    protected String password;

    public Student(int id, String name, String surename, String adress, String city, String distinct,String accname,String password) {
        this.id = id;
        this.name = name;
        this.surename = surename;
        this.adress = adress;
        this.city = city;
        this.distinct = distinct;
        this.password=password;
        this.accname=accname;
    }

    public Student(String name, String surename, String adress, String city, String distinct,String accname,String password) {
        this.name = name;
        this.surename = surename;
        this.adress = adress;
        this.city = city;
        this.distinct = distinct;
        this.password=password;
        this.accname=accname;
    }

    public Student(int id,String name, String surename, String adress, String city, String distinct) {
        this.id=id;
        this.name = name;
        this.surename = surename;
        this.adress = adress;
        this.city = city;
        this.distinct = distinct;

    }


    public Student() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getDistinct() {
        return distinct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistinct(String distinct) {
        this.distinct = distinct;
    }

    public String getAccname() {
        return accname;
    }

    public String getPassword() {
        return password;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", distinct='" + distinct + '\'' +
                ", accname='" + accname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
