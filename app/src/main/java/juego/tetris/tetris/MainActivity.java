package juego.tetris.tetris;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GridLayout tablero;
    public static Figura matrizF[][] = new Figura[18][10];
    public static Boolean matriz[][] = new Boolean[18][10];
    private Button btnJugar;
    private ImageButton btnIzquierda, btnDerecha, btnRotar;
    private TextView txtScore;
    ImageView c1,c2,c3,c4, fondo_mover;
    Boolean fin;
    Figura figura;
    Forma forma;
    Boolean colocada = true;
    private int puntaje = 0;


    public void jugarClicked(View view){
        crearTablero();
        btnJugar.setVisibility(View.INVISIBLE);
        btnDerecha.setVisibility(View.VISIBLE);
        btnRotar.setVisibility(View.VISIBLE);
        btnIzquierda.setVisibility(View.VISIBLE);

        puntaje = 0;
        txtScore.setText("Puntuación: 0");

        jugar();
    }

    public void rotarClicked(View view){
        int posA1 = ((forma.celda1.getFila()) * 20) + (forma.celda1.getColumna() + 3);
        int posA2 = ((forma.celda2.getFila()) * 20) + (forma.celda2.getColumna() + 3);
        int posA3 = ((forma.celda3.getFila()) * 20) + (forma.celda3.getColumna() + 3);
        int posA4 = ((forma.celda4.getFila()) * 20) + (forma.celda4.getColumna() + 3);

        if(forma.rotarFigura()){
            int pos1 = (forma.celda1.getFila() * 20) + (forma.celda1.getColumna() + 3);
            int pos2 = (forma.celda2.getFila() * 20) + (forma.celda2.getColumna() + 3);
            int pos3 = (forma.celda3.getFila() * 20) + (forma.celda3.getColumna() + 3);
            int pos4 = (forma.celda4.getFila() * 20) + (forma.celda4.getColumna() + 3);

            cambiarColor();

            colocarFondo(posA1);
            colocarFondo(posA2);
            colocarFondo(posA3);
            colocarFondo(posA4);
            dibujarCuadro(pos1, c1);
            dibujarCuadro(pos2, c2);
            dibujarCuadro(pos3, c3);
            dibujarCuadro(pos4, c4);
        }

    }

    public void movIzquierda(View view) {
        if (forma.celda1.getColumna() > 0 && forma.celda2.getColumna() > 0 && forma.celda3.getColumna() > 0 && forma.celda4.getColumna() > 0 && !colocada) {


            if(!hayConflictoColumna(forma, -1)){
                forma.moverIzquierda();
                int pos1 = (forma.celda1.getFila() * 20) + (forma.celda1.getColumna() + 3);
                int posA1 = ((forma.celda1.getFila()) * 20) + (forma.celda1.getColumna() + 3 + 1);
                int pos2 = (forma.celda2.getFila() * 20) + (forma.celda2.getColumna() + 3);
                int posA2 = ((forma.celda2.getFila()) * 20) + (forma.celda2.getColumna() + 3 + 1);
                int pos3 = (forma.celda3.getFila() * 20) + (forma.celda3.getColumna() + 3);
                int posA3 = ((forma.celda3.getFila()) * 20) + (forma.celda3.getColumna() + 3 + 1);
                int pos4 = (forma.celda4.getFila() * 20) + (forma.celda4.getColumna() + 3);
                int posA4 = ((forma.celda4.getFila()) * 20) + (forma.celda4.getColumna() + 3 + 1);

                cambiarColor();
                if (pos1 > 0) {
                    colocarFondo(posA1);
                }
                if (pos2 > 0) {
                    colocarFondo(posA2);
                }
                if (pos3 > 0) {
                    colocarFondo(posA3);
                }
                if (pos4 > 0) {
                    colocarFondo(posA4);
                }
                if (pos1 > 0) {
                    dibujarCuadro(pos1, c1);
                }
                if (pos2 > 0) {
                    dibujarCuadro(pos2, c2);
                }
                if (pos3 > 0) {
                    dibujarCuadro(pos3, c3);
                }
                if (pos4 > 0) {
                    dibujarCuadro(pos4, c4);
                }
            }
        }
    }

    public void movDerecha(View view) {
        if (forma.celda1.getColumna() < 9 && forma.celda2.getColumna() < 9 && forma.celda3.getColumna() < 9 && forma.celda4.getColumna() < 9 && !colocada) {

            if(!hayConflictoColumna(forma,1)){
                forma.moverDerecha();
                int pos1 = (forma.celda1.getFila() * 20) + (forma.celda1.getColumna() + 3);
                int posA1 = ((forma.celda1.getFila()) * 20) + (forma.celda1.getColumna() + 3 - 1);
                int pos2 = (forma.celda2.getFila() * 20) + (forma.celda2.getColumna() + 3);
                int posA2 = ((forma.celda2.getFila()) * 20) + (forma.celda2.getColumna() + 3 - 1);
                int pos3 = (forma.celda3.getFila() * 20) + (forma.celda3.getColumna() + 3);
                int posA3 = ((forma.celda3.getFila()) * 20) + (forma.celda3.getColumna() + 3 - 1);
                int pos4 = (forma.celda4.getFila() * 20) + (forma.celda4.getColumna() + 3);
                int posA4 = ((forma.celda4.getFila()) * 20) + (forma.celda4.getColumna() + 3 - 1);

                cambiarColor();
                if (pos1 > 0) {
                    colocarFondo(posA1);
                }
                if (pos2 > 0) {
                    colocarFondo(posA2);
                }
                if (pos3 > 0) {
                    colocarFondo(posA3);
                }
                if (pos4 > 0) {
                    colocarFondo(posA4);
                }
                if (pos1 > 0) {
                    dibujarCuadro(pos1, c1);
                }
                if (pos2 > 0) {
                    dibujarCuadro(pos2, c2);
                }
                if (pos3 > 0) {
                    dibujarCuadro(pos3, c3);
                }
                if (pos4 > 0) {
                    dibujarCuadro(pos4, c4);
                }
            }
        }
    }

    private void colocarFondo(int pos){
        fondo_mover = new ImageView(getApplicationContext());
        fondo_mover.setImageResource(R.drawable.fondo7);
        tablero.removeViewAt(pos);
        tablero.addView(fondo_mover, pos);
    }

    private void dibujarCuadro(int pos, ImageView c){
        tablero.removeViewAt(pos);
        tablero.addView(c, pos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablero = findViewById(R.id.tablero);
        txtScore = findViewById(R.id.txtScore);
        txtScore.setText("Puntuación: 0");
        btnJugar = findViewById(R.id.btnJugar);
        btnJugar.setText("Jugar");
        btnIzquierda = findViewById(R.id.btnIzquierda);
        btnIzquierda.setImageResource(R.drawable.izquierda);
        btnDerecha= findViewById(R.id.btnDerecha);
        btnDerecha.setImageResource(R.drawable.derecha);
        btnRotar= findViewById(R.id.btnRotar);
        btnRotar.setImageResource(R.drawable.rotar);

        crearTablero();
    }

    private void crearTablero(){
        tablero.removeAllViews();

        for(int i = 0; i < 18; i++){
            for(int j = 0; j < 10; j++){
                matriz[i][j] = false;
                matrizF[i][j] = null;
            }
        }

        for(int i = 0; i < 400; i++){
            ImageView fondo = new ImageView(this);
            if((i%20) <= 2 || (i%20) >= 13 || i > 360){
                fondo.setImageResource(R.drawable.fondo_blanco0);
            }else{
                fondo.setImageResource(R.drawable.fondo7);
            }

            tablero.addView(fondo);
        }
    }

    private Figura generarFigura(){
        int pick = new Random().nextInt(Figura.values().length);
        return Figura.values()[pick];
    }

    private void jugar() {
        colocada = true;
        fin = false;
        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {


            int i = 0;
            @Override
            public void run() {
                if(colocada){
                    figura = generarFigura();
                }

                if (figura == Figura.Cubo) {
                    if(colocada){
                        forma = new Cubo();
                        colocada = false;
                    }
                }
                if (figura == Figura.Ele) {
                    if(colocada){
                        forma = new Ele();
                        colocada = false;
                    }
                }
                if (figura == Figura.Ese) {
                    if(colocada){
                        forma = new Ese();
                        colocada = false;
                    }
                }
                if (figura == Figura.Jota) {
                    if(colocada){
                        forma = new Jota();
                        colocada = false;
                    }
                }
                if (figura == Figura.Palito) {
                    if(colocada){
                        forma = new Palito();
                        colocada = false;
                    }
                }
                if (figura == Figura.Te) {
                    if(colocada){
                        forma = new Te();
                        colocada = false;
                    }
                }
                if (figura == Figura.Zeta) {
                    if(colocada){
                        forma = new Zeta();
                        colocada = false;
                    }
                }
                cambiarColor();

                Boolean conflicto = hayConflictoFila(forma);
                if(conflicto){
                    colocada = true;
                    revisarLineas();
                }else{
                    bajarFigura(forma);
                }

                handler.postDelayed(this, 700);
                if(fin){
                    handler.removeCallbacks(this);
                    btnDerecha.setVisibility(View.INVISIBLE);
                    btnIzquierda.setVisibility(View.INVISIBLE);
                    btnRotar.setVisibility(View.INVISIBLE);
                    btnJugar.setVisibility(View.VISIBLE);
                }
            }
        };
        handler.postDelayed(runnable, 1000);

    }

    private void bajarFigura(Forma forma) {

        forma.bajarNivel();
        int pos1 = (forma.celda1.getFila() * 20) + (forma.celda1.getColumna() + 3);
        int posA1 = ((forma.celda1.getFila() - 1) * 20) + (forma.celda1.getColumna() + 3);
        int pos2 = (forma.celda2.getFila() * 20) + (forma.celda2.getColumna() + 3);
        int posA2 = ((forma.celda2.getFila() - 1) * 20) + (forma.celda2.getColumna() + 3);
        int pos3 = (forma.celda3.getFila() * 20) + (forma.celda3.getColumna() + 3);
        int posA3 = ((forma.celda3.getFila() - 1) * 20) + (forma.celda3.getColumna() + 3);
        int pos4 = (forma.celda4.getFila() * 20) + (forma.celda4.getColumna() + 3);
        int posA4 = ((forma.celda4.getFila() - 1) * 20) + (forma.celda4.getColumna() + 3);

        if (pos1 > 20) {
            fondo_mover = new ImageView(getApplicationContext());
            fondo_mover.setImageResource(R.drawable.fondo7);
            tablero.removeViewAt(posA1);
            tablero.addView(fondo_mover, posA1);
        }
        if (pos2 > 20) {
            fondo_mover = new ImageView(getApplicationContext());
            fondo_mover.setImageResource(R.drawable.fondo7);
            tablero.removeViewAt(posA2);
            tablero.addView(fondo_mover, posA2);
        }
        if (pos3 > 20) {
            fondo_mover = new ImageView(getApplicationContext());
            fondo_mover.setImageResource(R.drawable.fondo7);
            tablero.removeViewAt(posA3);
            tablero.addView(fondo_mover, posA3);
        }
        if (pos4 > 20) {
            fondo_mover = new ImageView(getApplicationContext());
            fondo_mover.setImageResource(R.drawable.fondo7);
            tablero.removeViewAt(posA4);
            tablero.addView(fondo_mover, posA4);
        }

        if(pos1>0){
            tablero.removeViewAt(pos1);
            tablero.addView(c1, pos1);
        }
        if(pos2>0){
            tablero.removeViewAt(pos2);
            tablero.addView(c2, pos2);
        }
        if(pos3>0){
            tablero.removeViewAt(pos3);
            tablero.addView(c3, pos3);
        }
        if(pos4>0){
            tablero.removeViewAt(pos4);
            tablero.addView(c4, pos4);
        }

    }

    private Boolean hayConflictoFila(Forma forma){
        if(forma.celda1.getFila() == 17 || forma.celda2.getFila() == 17 || forma.celda3.getFila() == 17 || forma.celda4.getFila() == 17){
            llenarMatriz(forma);
            return true;
        }else{
            if(forma.celda1.getFila() >= -1){
                if(matriz[forma.celda1.getFila()+1][forma.celda1.getColumna()]){
                    llenarMatriz(forma);
                    return true;
                }
            }

            if(forma.celda2.getFila() >= -1){
                if(matriz[forma.celda2.getFila()+1][forma.celda2.getColumna()]){
                    llenarMatriz(forma);
                    return true;
                }
            }

            if(forma.celda3.getFila() >= -1){
                if(matriz[forma.celda3.getFila()+1][forma.celda3.getColumna()]){
                    llenarMatriz(forma);
                    return true;
                }
            }

            if(forma.celda4.getFila() >= -1){
                if(matriz[forma.celda4.getFila()+1][forma.celda4.getColumna()]){
                    llenarMatriz(forma);
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean hayConflictoColumna(Forma forma, int mov){
        if((mov==1 && (forma.celda1.getColumna() == 9 || forma.celda2.getColumna() == 9 || forma.celda3.getColumna() == 9 || forma.celda4.getColumna() == 9)) || ((mov==-1 && (forma.celda1.getColumna() == 0 || forma.celda2.getColumna() == 0 || forma.celda3.getColumna() == 0 || forma.celda4.getColumna() == 0)))){
            //llenarMatriz(forma);
            return true;
        }else{
            if(forma.celda1.getColumna() >= 0 && forma.celda1.getColumna() <= 9){
                if(forma.celda1.getFila() >= 0){
                    if(matriz[forma.celda1.getFila()][forma.celda1.getColumna()+mov]){
                        //llenarMatriz(forma);
                        return true;
                    }
                }
            }

            if(forma.celda2.getColumna() >= 0 && forma.celda2.getColumna() <= 9){
                if(forma.celda2.getFila() >= 0){
                    if(matriz[forma.celda2.getFila()][forma.celda2.getColumna()+mov]){
                        //llenarMatriz(forma);
                        return true;
                    }
                }
            }

            if(forma.celda3.getColumna() >= 0 && forma.celda3.getColumna() <= 9){
                if(forma.celda3.getFila() >= 0){
                    if(matriz[forma.celda3.getFila()][forma.celda3.getColumna()+mov]){
                        //llenarMatriz(forma);
                        return true;
                    }
                }
            }

            if(forma.celda4.getColumna() >= 0 && forma.celda4.getColumna() <= 9){
                if(forma.celda4.getFila() >= 0){
                    if(matriz[forma.celda4.getFila()][forma.celda4.getColumna()+mov]){
                        //llenarMatriz(forma);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void llenarMatriz(Forma forma){
        if(forma.celda1.getFila() >= 0 && forma.celda2.getFila() >= 0 && forma.celda3.getFila() >= 0 && forma.celda4.getFila() >= 0){
            matriz[forma.celda1.getFila()][forma.celda1.getColumna()] = true;
            matriz[forma.celda2.getFila()][forma.celda2.getColumna()] = true;
            matriz[forma.celda3.getFila()][forma.celda3.getColumna()] = true;
            matriz[forma.celda4.getFila()][forma.celda4.getColumna()] = true;
            matrizF[forma.celda1.getFila()][forma.celda1.getColumna()] = figura;
            matrizF[forma.celda2.getFila()][forma.celda2.getColumna()] = figura;
            matrizF[forma.celda3.getFila()][forma.celda3.getColumna()] = figura;
            matrizF[forma.celda4.getFila()][forma.celda4.getColumna()] = figura;
        }else{
            fin = true;
        }
    }

    private void revisarLineas() {
        for (int i = 17; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (!matriz[i][j]) {
                    break;
                }
                if (j == 9) {
                    puntaje+= 10;
                    eliminarFila(i);
                    i++;
                }
            }
        }
    }

    private void eliminarFila(int fila){
        for(int i = fila; i > 0; i--){
            for(int j = 0; j < 10; j++){
                matriz[i][j] = matriz[i-1][j];
                matrizF[i][j] = matrizF[i-1][j];

                int pos = (i*20)+(j+3);
                ImageView cuadritoArriba = new ImageView(getApplicationContext());
                if(matrizF[i-1][j] == Figura.Cubo){
                    cuadritoArriba.setImageResource(R.drawable.c_amarillo0);
                }else if(matrizF[i-1][j] == Figura.Ele){
                    cuadritoArriba.setImageResource(R.drawable.c_naranja0);
                }else if(matrizF[i-1][j] == Figura.Ese){
                    cuadritoArriba.setImageResource(R.drawable.c_rojo0);
                }else if(matrizF[i-1][j] == Figura.Jota){
                    cuadritoArriba.setImageResource(R.drawable.c_rosado0);
                }else if(matrizF[i-1][j] == Figura.Palito){
                    cuadritoArriba.setImageResource(R.drawable.c_azul0);
                }else if(matrizF[i-1][j] == Figura.Te){
                    cuadritoArriba.setImageResource(R.drawable.c_morado0);
                }else if(matrizF[i-1][j] == Figura.Zeta){
                    cuadritoArriba.setImageResource(R.drawable.c_verde0);
                }else{
                    cuadritoArriba.setImageResource(R.drawable.fondo7);
                }
                tablero.removeViewAt(pos);
                tablero.addView(cuadritoArriba, pos);
            }
        }
        for(int j = 0; j < 10; j++){
            matriz[0][j] = false;
            matrizF[0][j] = null;

            fondo_mover = new ImageView(getApplicationContext());
            fondo_mover.setImageResource(R.drawable.fondo7);
            tablero.removeViewAt(j+3);
            tablero.addView(fondo_mover, j+3);
        }

        txtScore.setText("Puntuación: " + puntaje);

    }

    private void cambiarColor(){
        if (figura == Figura.Cubo) {
            c1 = new ImageView(getApplicationContext());
            c2 = new ImageView(getApplicationContext());
            c3 = new ImageView(getApplicationContext());
            c4 = new ImageView(getApplicationContext());
            c1.setImageResource(R.drawable.c_amarillo0);
            c2.setImageResource(R.drawable.c_amarillo0);
            c3.setImageResource(R.drawable.c_amarillo0);
            c4.setImageResource(R.drawable.c_amarillo0);
        }
        if (figura == Figura.Ele) {
            c1 = new ImageView(getApplicationContext());
            c2 = new ImageView(getApplicationContext());
            c3 = new ImageView(getApplicationContext());
            c4 = new ImageView(getApplicationContext());
            c1.setImageResource(R.drawable.c_naranja0);
            c2.setImageResource(R.drawable.c_naranja0);
            c3.setImageResource(R.drawable.c_naranja0);
            c4.setImageResource(R.drawable.c_naranja0);
        }
        if (figura == Figura.Ese) {
            c1 = new ImageView(getApplicationContext());
            c2 = new ImageView(getApplicationContext());
            c3 = new ImageView(getApplicationContext());
            c4 = new ImageView(getApplicationContext());
            c1.setImageResource(R.drawable.c_rojo0);
            c2.setImageResource(R.drawable.c_rojo0);
            c3.setImageResource(R.drawable.c_rojo0);
            c4.setImageResource(R.drawable.c_rojo0);
        }
        if (figura == Figura.Jota) {
            c1 = new ImageView(getApplicationContext());
            c2 = new ImageView(getApplicationContext());
            c3 = new ImageView(getApplicationContext());
            c4 = new ImageView(getApplicationContext());
            c1.setImageResource(R.drawable.c_rosado0);
            c2.setImageResource(R.drawable.c_rosado0);
            c3.setImageResource(R.drawable.c_rosado0);
            c4.setImageResource(R.drawable.c_rosado0);
        }
        if (figura == Figura.Palito) {
            c1 = new ImageView(getApplicationContext());
            c2 = new ImageView(getApplicationContext());
            c3 = new ImageView(getApplicationContext());
            c4 = new ImageView(getApplicationContext());
            c1.setImageResource(R.drawable.c_azul0);
            c2.setImageResource(R.drawable.c_azul0);
            c3.setImageResource(R.drawable.c_azul0);
            c4.setImageResource(R.drawable.c_azul0);
        }
        if (figura == Figura.Te) {
            c1 = new ImageView(getApplicationContext());
            c2 = new ImageView(getApplicationContext());
            c3 = new ImageView(getApplicationContext());
            c4 = new ImageView(getApplicationContext());
            c1.setImageResource(R.drawable.c_morado0);
            c2.setImageResource(R.drawable.c_morado0);
            c3.setImageResource(R.drawable.c_morado0);
            c4.setImageResource(R.drawable.c_morado0);
        }
        if (figura == Figura.Zeta) {
            c1 = new ImageView(getApplicationContext());
            c2 = new ImageView(getApplicationContext());
            c3 = new ImageView(getApplicationContext());
            c4 = new ImageView(getApplicationContext());
            c1.setImageResource(R.drawable.c_verde0);
            c2.setImageResource(R.drawable.c_verde0);
            c3.setImageResource(R.drawable.c_verde0);
            c4.setImageResource(R.drawable.c_verde0);
        }
    }
}
