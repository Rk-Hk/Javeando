
package VistaCargando;

public class Hilo extends Thread {

    Splash ref;

    public Hilo(Splash ref) {
        this.ref = ref;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(150);
                ref.Llena_Barra();

            } catch (InterruptedException ex) {

            }
        }
    }

}