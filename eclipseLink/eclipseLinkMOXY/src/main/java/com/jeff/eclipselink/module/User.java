package com.jeff.eclipselink.module;

/**
 * Created by Jeff.Ma on 7/13/2017.
 */
public class User extends ExtensibleBase{
    private String firstName;
    private String lastName;

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
