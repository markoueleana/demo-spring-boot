package com.luv2code.thymeleafdemo.student;

public class Student {

    String firstName;
    String lastName;
    String country;

    String favoritelanguage;
    public String getFavoritelanguage() {
        return favoritelanguage;
    }

    public void setFavoritelanguage(String favoritelanguage) {
        this.favoritelanguage = favoritelanguage;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
