package clases;

import java.awt.Rectangle;
import java.awt.geom.*;

public class Pelota {
    private int x;
    private int y;
    public int puntuacion1 = 0;
	public int puntuacion2 = 0;
	private final int inicioX = 602;
	private final int inicioY = 312; 
	private boolean colisionIzquierda = false;
	private boolean colisionDerecha = false;
	public Ventana ventana;
    private int dx = 1, dy = 1;
    private final int ancho = 15, alto = 15;
    
    public Pelota(int x, int y, Ventana ventana){
        this.x = x;
        this.y = y;
        this.ventana = ventana;
    }

    public Rectangle2D getPelota(){
        return new Rectangle2D.Double(x, y, ancho, alto);
    }

    public void mover(Rectangle limites, boolean colisionP1, boolean colisionP2){
        x+=dx;
        y+=dy;
        if(colisionP1)
        {
            dx=-dx;
            x=40;
        }
        if(colisionP2)
        {
            dx=-dx;
            x=1200;
        }

        if(x>limites.getMaxX()-15) // hay q modifcarlo para que rebote cuando toque la paleta
        {
            dx=-dx;
            colisionDerecha = true;
            reiniciar();
        }
        if(y>limites.getMaxY()-15)
        {
            dy=-dy;
        }
        if(x<0) // hay q modifcarlo para que rebote cuando toque la paleta
        {
            dx=-dx;
            colisionIzquierda = true;
            reiniciar();
        }
        if(y<0)
        {
            dy=-dy;
        }
    }

    private void reiniciar() 
    {
        // ESTO HACE QUE LA PELOTA APAREZCA EN EL CENTRO DE LA MANTALLA
        x = inicioX;
        y = inicioY;

        // SI LA COLISION FUE EN LA PARED DE LA DERECHA
        if (colisionDerecha == true) {
            dx = -Math.abs(dx); // SE MOVERA A LA IZQUIERDA (POR ESO EL MENOS)
            colisionDerecha = false; // RESTABLECE EL ESTADO DE LA PARED PARA QUE PUEDA REPETIRSE CONSTANTEMENTE EL CODIGO
            puntuacion1 = puntuacion1+1;
            ventana.setPuntuacionJugador1(puntuacion1);
        }
        // SI LA COLISION FUE EN LA PARED DE LA DERECHA 
        else if (colisionIzquierda == true) {
            dx = Math.abs(dx); // SE MOVERA A LA DERECHA
            colisionIzquierda = false;// RESTABLECE EL ESTADO DE LA PARED PARA QUE PUEDA REPETIRSE CONSTANTEMENTE EL CODIGO
            puntuacion2 = puntuacion2+1;
            ventana.setPuntuacionJugador2(puntuacion2);
        }
    }

}
