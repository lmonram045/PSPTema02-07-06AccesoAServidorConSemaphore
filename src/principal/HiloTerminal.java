package principal;

import java.util.concurrent.Semaphore;

/** Clase derivada de Thread que define un hilo que simula el acceso a un servidor web */
public class HiloTerminal extends Thread {
    private ServidorWeb servidor; // servidor al que se accede
    private Semaphore semaforo; // semáforo que controla el acceso al servidor

    /** Constructor de la clase HiloTerminal */
    public HiloTerminal(ServidorWeb servidor, Semaphore semaforo) {
        this.servidor = servidor;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                // En cada acceso se adquiere el recurso y si está ocupado se bloquea el hilo
                semaforo.acquire();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Adquirido el recurso, invoca a este método para simular el acceso al servidor incrementando la cuenta de accesos
            servidor.incrementaAccesos();
            // libera el recurso o permiso
            semaforo.release();
            this.yield(); // permite que otro hilo pueda ejecutarse
        }
    }
}
