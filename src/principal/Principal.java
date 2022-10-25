package principal;

import java.util.concurrent.Semaphore;

/** Se trata de simular el acceso simultáneo de 4 terminales (hilos) a un servidor web (objeto compartido) y llevar
 * la cuenta de accesos en cada instante. Desde cada terminal se simularán 10 accesos */
public class Principal {
    public static void main(String[] args) {
        // Semáforo para las secciones críticas de esta clase (permisos 1)
        Semaphore semaforo = new Semaphore(1);
        // Se crea un objeto ServidorWeb que será el recurso compartido
        ServidorWeb servidor = new ServidorWeb();
        // Se crean 4 hilos que simulan el acceso a un servidor web
        HiloTerminal hilo1 = new HiloTerminal(servidor, semaforo);
        HiloTerminal hilo2 = new HiloTerminal(servidor, semaforo);
        HiloTerminal hilo3 = new HiloTerminal(servidor, semaforo);
        HiloTerminal hilo4 = new HiloTerminal(servidor, semaforo);

        // Se inician los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
