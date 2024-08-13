package clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel; 

public class TableroPong extends JPanel implements KeyListener {

    Pelota pelota;
    Paleta paleta1 = new Paleta(20, 280); 
    Paleta paleta2 = new Paleta(1220, 280);

    public TableroPong(Ventana ventana) {

		pelota = new Pelota(602, 312, ventana);
        setBackground(Color.BLACK);
        setLayout(null);
        addKeyListener(this); 
        setFocusable(true); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        dibujar(g2); // pelota
        actualizar();

        Graphics2D g3 = (Graphics2D) g; // paleta 1
        g3.setColor(Color.WHITE);
        g3.fill(new Rectangle2D.Double(paleta1.getX(), paleta1.getY(), 20, 100));

        Graphics2D g4 = (Graphics2D) g; // paleta 2
        g4.setColor(Color.WHITE);
        g4.fill(new Rectangle2D.Double(paleta2.getX(), paleta2.getY(), 20, 100));

        Graphics2D g5 = (Graphics2D) g; // Linea Punteada del centro
        g5.setColor(Color.WHITE);
        float guiones1[] = {12, 12};
        int ancho = 2;
        g5.setStroke(new BasicStroke(ancho, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, guiones1, 0));
        g5.drawLine(610, 710, 610, 0);

        // Bordes de la cancha:
        Graphics2D g6 = (Graphics2D) g;
        g6.setColor(Color.WHITE);
        g6.fill(new Rectangle2D.Double(0, 0, 1280, 5)); // superior

        Graphics2D g7 = (Graphics2D) g;
        g7.setColor(Color.WHITE);
        g7.fill(new Rectangle2D.Double(0, 0, 5, 720)); // izquierdo

        Graphics2D g8 = (Graphics2D) g;
        g8.setColor(Color.WHITE);
        g8.fill(new Rectangle2D.Double(0, 678, 1280, 6)); // inferior

        Graphics2D g9 = (Graphics2D) g;
        g9.setColor(Color.WHITE);
        g9.fill(new Rectangle2D.Double(1260, 0, 5, 720)); // derecho
    }

    public void dibujar(Graphics2D g) {
        g.fill(pelota.getPelota());
    }

    public void actualizar() {
        pelota.mover(getBounds(), colision(paleta1.getPaleta()), colision(paleta2.getPaleta()));
        paleta1.mover(getBounds());
        paleta2.mover(getBounds());
    }

    public void iterarJuego() {
        while (true) {
            repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

	//colision entre tu vieja y las paletas

	private boolean colision(Rectangle2D r)
	{
		return pelota.getPelota().intersects(r);
	}

    // de aca para abajo es todo lo del teclado
    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_W) {
            paleta1.dibujar_en_y(-2);//que buena que esta la mama de ozores
        }
        if (tecla == KeyEvent.VK_S) {
            paleta1.dibujar_en_y(2);
        }
        if (tecla == KeyEvent.VK_UP) {
            paleta2.dibujar_en_y(-2);
        }
        if (tecla == KeyEvent.VK_DOWN) {
            paleta2.dibujar_en_y(2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_W || tecla == KeyEvent.VK_S) {
            paleta1.dibujar_en_y(0);
        }
        if (tecla == KeyEvent.VK_UP || tecla == KeyEvent.VK_DOWN) {
            paleta2.dibujar_en_y(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
