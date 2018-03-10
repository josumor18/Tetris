package juego.tetris.tetris;

/**
 * Created by JosueAndroid on 5/3/2018.
 */

public class Celda {

    private int nivel;
    private int fila, fila_ant;
    private int columna, columnana_ant;

    public Celda(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila_ant() {
        return fila_ant;
    }

    public void setFila_ant(int fila_ant) {
        this.fila_ant = fila_ant;
    }

    public int getColumnana_ant() {
        return columnana_ant;
    }

    public void setColumnana_ant(int columnana_ant) {
        this.columnana_ant = columnana_ant;
    }
}
