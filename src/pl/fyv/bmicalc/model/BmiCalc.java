package pl.fyv.bmicalc.model;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;




public class BmiCalc {


    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    private final DoubleProperty height;

    public double getMass() {
        return mass.get();
    }

    public DoubleProperty massProperty() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass.set(mass);
    }

    private final DoubleProperty mass;

    public BmiCalc(DoubleProperty height, DoubleProperty mass) {
        this.height = height;
        this.mass = mass;
    }


    private DoubleBinding db = new DoubleBinding() {
        @Override
        protected double computeValue() {
            return getMass()/((getHeight())*getHeight()); // wzór na bmi
        }
    };

    public String interprete() {
        double score = db.get();
        if(12 < score && score < 18) return "Niedowaga";
        if(18 < score && score < 25) return "Norma";
        if(25 < score && score < 30) return "Nadwaga";
        if(30 < score && score < 40) return "Otyłość";
        if(40 < score && score < 43) return "Poważna otyłość";
        return "Nieznana wartość";
    }
}

