package com.project.crm.model;


import java.util.Date;
/**
 * Created by 1 on 09.11.2017.
 */
public class RegisteredUser extends User {



    private String fio;
    private String telephone;
    private String dateOfBith;
    private String sex;
    private String city;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateOfBith() {
        return dateOfBith;
    }

    public void setDateOfBith(String dateOfBith) {
        this.dateOfBith = dateOfBith;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
