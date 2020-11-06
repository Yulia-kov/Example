package sample;

import javafx.scene.control.Alert;

public class WinnerCheck {
    public void toWin(int p, int c){
        if ((p+c)*100/400>=80){
            if (p>c) {
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Вы выиграли");
                alert.setHeaderText(null);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Вы проиграли");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            System.exit(0);
        }
    }
}
