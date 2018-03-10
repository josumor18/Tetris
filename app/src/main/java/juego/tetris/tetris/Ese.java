package juego.tetris.tetris;

/**
 * Created by JosueAndroid on 6/3/2018.
 */

public class Ese extends Forma {

    public Ese() {
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
        celda3.setColumna(4);
        celda4.setColumna(5);
    }

    @Override
    public Boolean rotarFigura() {
        if(celda1.getFila() >= 0 && celda2.getFila() >= 0 && celda3.getFila() >= 0 && celda4.getFila() >= 0){
            switch(posicion){
                case 1:
                    if((celda1.getFila()-2 >= 0
                            && celda2.getFila()-1 >= 0 && celda2.getColumna()-1 >= 0
                            && celda4.getFila()+1 < 18 && celda4.getColumna()-1 >= 0)
                            && (!(MainActivity.matriz[celda1.getFila()-2][celda1.getColumna()])
                            && !(MainActivity.matriz[celda2.getFila()-1][celda2.getColumna()-1])
                            && !(MainActivity.matriz[celda4.getFila()+1][celda4.getColumna()-1]))){
                        celda1.setFila(celda1.getFila()-2);
                        celda2.setFila(celda2.getFila()-1);
                        celda2.setColumna(celda2.getColumna()-1);
                        celda4.setFila(celda4.getFila()+1);
                        celda4.setColumna(celda4.getColumna()-1);

                        girar();
                        return true;
                    }
                    break;
                case 2:
                    if((celda1.getFila()+2 < 18
                            && celda2.getFila()+1 < 18 && celda2.getColumna()+1 < 10
                            && celda4.getFila()-1 >= 0 && celda4.getColumna()+1 < 10)
                            && (!(MainActivity.matriz[celda1.getFila()+2][celda1.getColumna()])
                            && !(MainActivity.matriz[celda2.getFila()+1][celda2.getColumna()+1])
                            && !(MainActivity.matriz[celda4.getFila()-1][celda4.getColumna()+1]))){
                        celda1.setFila(celda1.getFila()+2);
                        celda2.setFila(celda2.getFila()+1);
                        celda2.setColumna(celda2.getColumna()+1);
                        celda4.setFila(celda4.getFila()-1);
                        celda4.setColumna(celda4.getColumna()+1);

                        posicion = 1;//No se llama a la función girar() porque solo tiene dos giros y no 4...
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
