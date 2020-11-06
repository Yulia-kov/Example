package sample;

public class AreaControl {

    //проверка плоащадей нарисованного и кубиков
    public boolean toControl(double d, int i){
        int di = (int)d;
        if(di==i){
            return true;
        }else {
            return false;
        }
    }
}
