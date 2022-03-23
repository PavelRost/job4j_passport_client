package ru.job4j.domain;

import javax.persistence.*;
import java.util.Date;

public class Passport {

    private int id;
    private String name;
    private int serial;
    private int number;
    private Date validityPeriod;

    public Passport() {
    }

    public Passport(String name, int serial, int number, Date validityPeriod) {
        this.name = name;
        this.serial = serial;
        this.number = number;
        this.validityPeriod = validityPeriod;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serial=" + serial +
                ", number=" + number +
                ", validityPeriod=" + validityPeriod +
                '}';
    }
}
