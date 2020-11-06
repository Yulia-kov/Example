package sample;

import java.util.ArrayList;

public class Changing {
    int a;

    // рисуем ровный прямоугольник по узлам сетки (те если чел криво тыкнул, то приводим к ближайшему узлу)

    public ArrayList<Double> toRectX(ArrayList<Double> arrayListX) {

        for (int i = 0; i < arrayListX.size(); i++) {
            if (((arrayListX.get(i)) % 20 == 0) == false) {
                if (((arrayListX.get(i)) % 20) >= 10) {
                    a = (int) (arrayListX.get(i) / 20);
                    arrayListX.set(i, (double) ((a * 20) + 20));
                } else {
                    a = (int) (arrayListX.get(i) / 20);
                    arrayListX.set(i, (double) ((a * 20)));
                }
            }
        }
        return arrayListX;

    }

    public ArrayList<Double> toRectY(ArrayList<Double> arrayListY) {

        for (int i = 0; i < arrayListY.size(); i++) {
            if (((arrayListY.get(i)) % 20 == 0) == false) {
                if (((arrayListY.get(i)) % 20) >= 10) {
                    a = (int) (arrayListY.get(i) / 20);
                    arrayListY.set(i, (double) ((a * 20) + 20));
                } else {
                    a = (int) (arrayListY.get(i) / 20);
                    arrayListY.set(i, (double) ((a * 20)));
                }
            }
        }
        return arrayListY;
    }
}

