package clases;

public class Hilo extends Thread{
    TableroPong tablero;
    public Hilo(TableroPong tablero)
    {
        this.tablero=tablero;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tablero.repaint();
        }
    }
}
