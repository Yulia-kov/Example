package sample;

import java.util.ArrayList;

public class AreaFromComp {

    //длины прямоугольников для компа
    public ArrayList<Integer> toGetXY(Integer area) {
        int x=20;
        int y=20;
        ArrayList<Integer> areaXY = new ArrayList<>();

        switch (area) {
            case (2):
                x = 1*x;
                y = 2*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (3):
                x = 3*x;
                y = 1*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (4):
                x = 2*x;
                y = 2*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (5):
                x = 1*x;
                y = 5*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (6):
                x = 3*x;
                y = 2*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (7):
                x = 7*x;
                y = 1*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (8):
                x = 2*x;
                y = 4*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (9):
                x = 3*x;
                y = 3*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (10):
                x = 2*x;
                y = 5*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (11):
                x = 11*x;
                y = 1*y;
                areaXY.add(x);
                areaXY.add(y);
                break;
            case (12):
                x = 4*x;
                y = 3*y;
                areaXY.add(x);
                areaXY.add(y);
                break;

        }
        return areaXY;

    }
}
