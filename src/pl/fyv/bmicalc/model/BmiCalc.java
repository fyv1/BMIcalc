package pl.fyv.bmicalc.model;

import javafx.beans.property.DoubleProperty;


public class BmiCalc {

    private final DoubleProperty height;
    private final DoubleProperty mass;

    public BmiCalc(DoubleProperty height, DoubleProperty mass) {

        this.height = height;
        this.mass = mass;
    }

    public DoubleProperty score() {
        return null; //TODO

    }

}
