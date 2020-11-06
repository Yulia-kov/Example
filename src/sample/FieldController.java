package sample;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class FieldController {
    private int cubesRes;
    private double areaRes;

    ArrayList<Double> arrayListX = new ArrayList<>();
    ArrayList<Double> arrayListY = new ArrayList<>();

    ArrayList<Integer> arrayListXComp = new ArrayList<>();
    ArrayList<Integer> arrayListYComp = new ArrayList<>();

    ArrayList<Integer> arrayListXYComp = new ArrayList<>();
    ArrayList<Integer> arrayListYXComp = new ArrayList<>();

    WinnerCheck winnerCheck = new WinnerCheck();

    Alerts alerts = new Alerts();

    Changing changing = new Changing();


    int areaP = 0;
    int areaC = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Button cubesButton;


    @FXML
    private Button stopButton;

    @FXML
    private Canvas canvas;

    GraphicsContext gc;

    @FXML
    void coordinates(MouseEvent event) {

        if (cubesButton.isPressed() == false) {
            alerts.beforeDrawing();
        } else {

            double x = event.getX();
            double y = event.getY();
            arrayListX.add(x);
            arrayListY.add(y);

            gc = canvas.getGraphicsContext2D();
            gc.setStroke(Color.GREEN);
            gc.setLineWidth(3);

            if (arrayListX.size() >= 2) {
                for (int i = 0; i < arrayListX.size() - 1; i++) {
                    gc.strokeLine(
                            (changing.toRectX(arrayListX)).get(i),
                            (changing.toRectY(arrayListY)).get(i),
                            (changing.toRectX(arrayListX)).get(i + 1),
                            (changing.toRectY(arrayListY)).get(i + 1));

                }
            }
//            System.out.println(arrayListX);
//            System.out.println(arrayListY);

            if (changing.toRectX(arrayListX).size() == 5) {
                AreaCounting areaCounting = new AreaCounting();
                areaRes = areaCounting.toCount(arrayListX, arrayListY);
                System.out.println(areaRes);
            }
        }
    }


    @FXML
    void toCubes(MouseEvent event) {
        int result = (int) (Math.random() * 10) + 2;
        String res = Integer.toString(result);
        cubesButton.setText(res);
        cubesRes = result;

        areaP = areaP + result; // для победного сравнения

        alerts.cubes(res);

    }

    @FXML
    void stopPerson(MouseEvent event) {
        AreaControl areaControl = new AreaControl();
        Changing changing = new Changing();

        if (areaControl.toControl(areaRes, cubesRes) == false) {
            alerts.redrawing();


            gc.setStroke(Color.WHITE);
            for (int i = 0; i < arrayListX.size() - 1; i++) {
                gc.strokeLine(
                        (changing.toRectX(arrayListX)).get(i),
                        (changing.toRectY(arrayListY)).get(i),
                        (changing.toRectX(arrayListX)).get(i + 1),
                        (changing.toRectY(arrayListY)).get(i + 1));

            }

            gc.setStroke(Color.BLACK);
            gc.setLineWidth(1);
            for (int i = 0; i < arrayListX.size() - 1; i++) {
                gc.strokeLine(
                        (changing.toRectX(arrayListX)).get(i),
                        (changing.toRectY(arrayListY)).get(i),
                        (changing.toRectX(arrayListX)).get(i + 1),
                        (changing.toRectY(arrayListY)).get(i + 1));

            }


            if (changing.toRectX(arrayListX).size() == 5) {
                changing.toRectX(arrayListX).clear();
            }

            if (changing.toRectY(arrayListY).size() == 5) {
                changing.toRectY(arrayListY).clear();
            }


        } else {

            if (changing.toRectX(arrayListX).size() == 5) {
                changing.toRectX(arrayListX).clear();
            }

            if (changing.toRectY(arrayListY).size() == 5) {
                changing.toRectY(arrayListY).clear();
            }
            cubesButton.setText("Бросить кубики");


            int area = (int) (Math.random() * 10) + 2;
            areaC = areaC + area;

            AreaFromComp areaFromComp = new AreaFromComp();
            gc = canvas.getGraphicsContext2D();
            gc.setStroke(Color.RED);
            gc.setLineWidth(3.0);


//
            int xStart;
            int yStart;

            xStart = 0;
            yStart = 0;

            if (arrayListXComp.size() == 0) { // чтобы первый шаг рисовался из 0
                xStart = 0;
                yStart = 0;
                arrayListXComp.add(xStart);
                arrayListYComp.add(yStart);
                gc.strokeRect(xStart, yStart, (areaFromComp.toGetXY(area).get(0)), areaFromComp.toGetXY(area).get(1));
                arrayListXComp.add(areaFromComp.toGetXY(area).get(0));
                arrayListYComp.add(areaFromComp.toGetXY(area).get(1));

                //System.out.println(arrayListXComp.size());
            } else {

                int xMax = 0;
                int yMax = 0;


                for (int i = 1; i < arrayListYComp.size(); i = i + 2) {
                    yMax = yMax + arrayListYComp.get(i);
                }
                //System.out.println(yMax);

                for (int i = 1; i < arrayListXComp.size(); i = i + 2) {
                    xMax = xMax + arrayListXComp.get(i);
                }

                for (int i = 2; i < arrayListXComp.size(); i = i + 2) {
                    if (arrayListXComp.get(i) != 0) {
                        yMax = yMax - (arrayListYComp.get(i + 1));

                    }
                }

//                System.out.println(arrayListYComp);
//                System.out.println("ymax=" + yMax);


                arrayListXYComp.clear();
                for (int i = 2; i < arrayListYComp.size(); i = i + 2) {
                    if (arrayListXComp.get(i) == 0) {
                        xMax = xMax - (arrayListXComp.get(i + 1));
                        arrayListXYComp.add(arrayListXComp.get(i + 1));
                        arrayListYXComp.add(arrayListYComp.get(i + 1));

                    }
                }


//                System.out.println(arrayListXYComp);
//                System.out.println(arrayListXComp);
//                System.out.println("xmax=" + xMax);

                int xyMax = 0;
                for (int i = 0; i < arrayListXYComp.size(); i++) {
                    if (arrayListXYComp.get(i) > xyMax) {
                        xyMax = arrayListXYComp.get(i);
                    }
                }

                int yxMax = 0;
                for (int i = 0; i < arrayListXYComp.size(); i++) {
                    if (arrayListYXComp.get(i) > yxMax) {
                        yxMax = arrayListYXComp.get(i);
                    }
                }


                System.out.println(xyMax + " xymax");
                System.out.println(yxMax + " yxmax");


//////////////////
                if (xMax + (areaFromComp.toGetXY(area).get(0)) > 400) {
                    xMax = xyMax;
                    xStart = xMax;
                    //   yMax =yxMax;
                }

                if (yMax + ((areaFromComp.toGetXY(area).get(1))) > 400) {
                    // xMax = xyMax;
                    yMax = yxMax;
                    yStart = yMax;
                    //xStart = xMax;
                }


///////////////////

                if (areaFromComp.toGetXY(area).get(1) > arrayListYComp.get((arrayListYComp.size() - 1))) {
                    xStart = 0;
                    yStart = yMax;

                } else {
                    xStart = xMax;
                }

                gc.strokeRect(xStart, yStart, (areaFromComp.toGetXY(area).get(0)), areaFromComp.toGetXY(area).get(1));
                arrayListXComp.add(xStart);
                arrayListYComp.add(yStart);
                arrayListXComp.add(areaFromComp.toGetXY(area).get(0));
                arrayListYComp.add(areaFromComp.toGetXY(area).get(1));
            }

        }
        winnerCheck.toWin(areaP, areaC);

    }


    @FXML
    void toLose(MouseEvent event) {
        alerts.loosing();

    }

    @FXML
    void initialize() {

    }
}

