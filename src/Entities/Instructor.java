package Entities;
//Object of our app
public class Instructor {
    protected  int id;
    protected  String name;
    protected  String surename;
    protected int age;
    protected String rank;
    protected  String city;
    protected String accname;
    protected String password;

    public Instructor(int id, String name, String surename, int age, String rank, String city,String accname,String password) {
        this.id = id;
        this.name = name;
        this.surename = surename;
        this.age = age;

        this.rank = rank;
        this.city = city;
        this.accname=accname;
        this.password=password;
    }

    public Instructor(String name, String surename, int age, String rank, String city,String accname,String password) {
        this.name = name;
        this.surename = surename;
        this.age = age;
        this.rank = rank;
        this.city = city;
        this.accname=accname;
        this.password=password;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setCity(String city) {
        this.city = city;
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

    public int getAge() {
        return age;
    }

    public String getRank() {
        return rank;
    }

    public String getCity() {
        return city;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccname() {
        return accname;
    }

    public String getPassword() {
        return password;
    }
}
