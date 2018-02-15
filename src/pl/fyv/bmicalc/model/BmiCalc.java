package pl.fyv.bmicalc.model;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;


public class BmiCalc {

    private final IntegerProperty height;
    private final IntegerProperty mass;

    private final StringProperty output = null;

    public BmiCalc(IntegerProperty height, IntegerProperty mass) {

        this.height = height;
        this.mass = mass;
    }

    IntegerBinding db = new IntegerBinding() {
        @Override
        protected int computeValue() {
            return mass.get()/(height.get()*height.get()); // wzór na bmi
        }
    };

    public void interprete(IntegerBinding score) {
        int db = score.get();
        if(12 < db && db < 18) output.set("Niedowaga");
        if(18 < db && db < 25) output.set("Norma");
        if(25 < db && db < 30) output.set("Nadwaga");
        if(30 < db && db < 40) output.set("Otyłość");
        if(40 < db && db < 43) output.set("Poważna otyłość");
    }
}

