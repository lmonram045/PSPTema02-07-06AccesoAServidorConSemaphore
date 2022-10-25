package principal;

/** Clase que simula los accesos a un servidor web */
public class ServidorWeb {
    private int numAccesos;

    /** Constructor de la clase ServidorWeb, inicializa la cuenta de accesos a 0 */
    public ServidorWeb() {
        this.numAccesos = 0;
    }

    /** Método sincronizado (monitor) que simula el acceso a un servidor web */
    public void incrementaAccesos() {
        // Mostramos el hilo que entra en el Servidor para comprobar el funcionamiento
        System.out.println("Hilo " + Thread.currentThread().getName() + " ------ entra en el Servidor");
        this.numAccesos++; // se incrementa la cuenta de accesos
        // Mostramos el número de accesos
        System.out.println(numAccesos + " accesos al servidor");
    }
}
