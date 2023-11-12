package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.EntryCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;
    @NotNull(message = "is required")
    @Min(value = 17, message = "Ooops, looks like you are younger than expected!")
    @Max(value = 100, message = "Ooops, looks like you are older than expected!")
    private Integer age;
    @Pattern(regexp = "^[a-zA-z0-9]{5}", message = "only 5 characters allowed")
    private String postalCode;
    @EntryCode
    private String entryCode;

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
