package sample;

import javafx.scene.control.Alert;

public class Alerts {

    public void loosing() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Игра окончена. ПК победил!");
        alert.showAndWait();
        System.exit(0);
    }

    public void redrawing() {
        Alert alertArea = new Alert(Alert.AlertType.ERROR);
        alertArea.setTitle("Ошибка");
        alertArea.setHeaderText(null);
        alertArea.setContentText("Нарисованная площадь не соответсует кубикам, перерисуйте");

        alertArea.showAndWait();
    }

    public void cubes(String res) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Значение кубиков");
        alert.setHeaderText(null);
        alert.setContentText(res);

        alert.showAndWait();
    }

    public void beforeDrawing() {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText("Сначала бросьте кубик");

        alert.showAndWait();
    }

    public void rules(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Правила игры:");
        alert.setHeaderText(null);
        alert.setContentText("1) бросить кубики" +
                "\n2) нарисовать прямоугольник площадью, полученной по результатам кубиков" +
                "\n3) нажать кнопку 'Закончить ход'" +
                "\n4) при желании сдаться нажмите кнопку 'Cдаться' ");

        alert.showAndWait();
    }

}
