package com.connectis.manager;

public class Domain {

    private String address;

    public Domain(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "\n{domain='" + address + "'";
    }
}
