package clases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Ventana extends JFrame{
	private final int ancho = 1280, alto = 720;
	private TableroPong tablero;
	JLabel Jugador_1 = new JLabel("0");
	JLabel Jugador_2 = new JLabel("0");
	//private Hilo hilo;
	public Ventana() {
		setTitle("Pong");
		setSize(ancho, alto);
		setLocationRelativeTo(null);
		setResizable(false);
		tablero = new TableroPong(this);
		add(tablero);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//hilo = new Hilo(tablero);
		//hilo.start();

		// Marcador de puntos:
		//Jugador 1:
		
		Jugador_1.setFont(new Font("Segoe UI", Font.BOLD, 40));
		Jugador_1.setHorizontalAlignment(SwingConstants.CENTER);
		Jugador_1.setForeground(new Color(255, 255, 255));
		Jugador_1.setBounds(560, 10, 50, 90);
		tablero.add(Jugador_1);
		
		//Jugador 2
		
		Jugador_2.setFont(new Font("Segoe UI", Font.BOLD, 40));
		Jugador_2.setHorizontalAlignment(SwingConstants.CENTER);
		Jugador_2.setForeground(new Color(255, 255, 255));
		Jugador_2.setBounds(610, 10, 50, 90);
		tablero.add(Jugador_2);
		
		tablero.iterarJuego();
	}

	public void setPuntuacionJugador1(int puntuacion) {
        Jugador_1.setText(String.valueOf(puntuacion));
       
    }

    public void setPuntuacionJugador2(int puntuacion) {
    	Jugador_2.setText(String.valueOf(puntuacion));
    }
}
