package juego.tetris.tetris;

/**
 * Created by JosueAndroid on 5/3/2018.
 */

public abstract class Forma {
    protected Celda celda1;
    protected Celda celda2;
    protected Celda celda3;
    protected Celda celda4;
    protected int posicion = 1;

    public Boolean rotarFigura(){return false;};

    protected void girar(){
        if(posicion < 4){
            posicion++;
        }else{
            posicion = 1;
        }
    }

    public void bajarNivel(){
        celda1.setFila(celda1.getFila()+1);
        celda2.setFila(celda2.getFila()+1);
        celda3.setFila(celda3.getFila()+1);
        celda4.setFila(celda4.getFila()+1);
    }

    public void moverIzquierda(){
        celda1.setColumna(celda1.getColumna()-1);
        celda2.setColumna(celda2.getColumna()-1);
        celda3.setColumna(celda3.getColumna()-1);
        celda4.setColumna(celda4.getColumna()-1);
    }

    public void moverDerecha(){
        celda1.setColumna(celda1.getColumna()+1);
        celda2.setColumna(celda2.getColumna()+1);
        celda3.setColumna(celda3.getColumna()+1);
        celda4.setColumna(celda4.getColumna()+1);
    }
}
