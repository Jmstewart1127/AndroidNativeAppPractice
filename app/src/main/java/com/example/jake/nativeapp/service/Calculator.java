package com.example.jake.nativeapp.service;

/**
 * Created by jake on 12/3/17.
 */

public class Calculator {

    public CharSequence first;
    public CharSequence second;
    public Boolean add;
    public Boolean subtract;

    public Calculator() {
        super();
    }

    public CharSequence getFirst() {
        return first;
    }

    public void setFirst(CharSequence first) {
        this.first = first;
    }

    public CharSequence getSecond() {
        return second;
    }

    public void setSecond(CharSequence second) {
        this.second = second;
    }

    public Boolean getAdd() {
        return add;
    }

    public void setAdd(Boolean add) {
        this.add = add;
    }

    public Boolean getSubtract() {
        return subtract;
    }

    public void setSubtract(Boolean subtract) {
        this.subtract = subtract;
    }

    public String add() {
        double one = Double.parseDouble(this.first.toString());
        double two = Double.parseDouble(this.second.toString());
        return String.valueOf(one + two);
    }

    public String subtract() {
        double one = Double.parseDouble(this.first.toString());
        double two = Double.parseDouble(this.second.toString());
        return String.valueOf(one - two);
    }

}
