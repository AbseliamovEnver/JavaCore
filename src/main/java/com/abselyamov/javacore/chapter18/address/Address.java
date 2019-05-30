package com.abselyamov.javacore.chapter18.address;

/**
 * @author Enver on 30.05.2019 23:26.
 * @project javacore
 */
public class Address {
    private String name;
    private String street;
    private String city;
    private String state;
    private String code;

    public Address(String name, String street, String city, String state, String code) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address:\n" +
                "name: \t" + name + "\n" +
                "street:\t" + street + "\n" +
                "city:\t" + city + "\n" +
                "state:\t" + state + "\n" +
                "code:\t" + code + "\n";
    }
}
