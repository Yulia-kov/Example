package sample;

import java.util.ArrayList;

public class AreaCounting {

    //значение площади для человека

    public double toCount(ArrayList<Double> arLX, ArrayList<Double> arLY) {
        double a;
        double b;
        a = Math.abs(arLX.get(1) - arLX.get(0));
        if (a == 0) {
            a = Math.abs(arLX.get(2) - arLX.get(1));
        }

        b = Math.abs(arLY.get(1) - arLY.get(0));
        if (b == 0) {
            b = Math.abs(arLY.get(2) - arLY.get(1));
        }


        double areaRez = a * b;
        areaRez=areaRez/400;
        return areaRez;
    }
}
