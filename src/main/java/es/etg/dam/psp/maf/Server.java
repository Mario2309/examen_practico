package es.etg.dam.psp.maf;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Server implements Constantes {
    public static void main(String[] args) throws IOException {
        GestorMensaje gestor = new GestorMensaje();
        ServerSocket server = new ServerSocket(PUERTO);
            
        do {
            Socket cliente = server.accept();
        
            int v1 = Integer.parseInt(gestor.recibir(cliente));
            String simb = gestor.recibir(cliente);
            int v2 = Integer.parseInt(gestor.recibir(cliente));

            
            Operacion operacion = FactOperacion.generarOperacion(v1, v2, simb);
            
            int resultado = operacion.operar();

            gestor.enviar(cliente, String.valueOf(resultado));

            int puntuaje =+ operacion.getTipo();

            gestor.enviar(cliente, String.valueOf(puntuaje));

            loggeo();

            cliente.close();
        } while (true);
    }


    private static void loggeo() throws SecurityException, IOException{
        Logger logger = Logger.getLogger(LOGGER);
        FileHandler fh = new FileHandler(FICHERO_LOG, true);
        SimpleFormatter formatter = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(formatter);

        logger.log(Level.INFO, OPERACION_REGISTRADA);
    }
}