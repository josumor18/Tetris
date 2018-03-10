package juego.tetris.tetris;

/**
 * Created by JosueAndroid on 5/3/2018.
 */

public class Cubo extends Forma{

    public Cubo() {
        celda1 = new Celda(-1);
        celda2 = new Celda(-1);
        celda3 = new Celda(-2);
        celda4 = new Celda(-2);
        celda1.setFila(-1);
        celda2.setFila(-1);
        celda3.setFila(-2);
        celda4.setFila(-2);
        celda1.setColumna(3);
        celda2.setColumna(4);
        celda3.setColumna(3);
        celda4.setColumna(4);
    }
}
