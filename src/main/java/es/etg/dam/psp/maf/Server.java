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
        int puntuajeOpSimple = 0;
        int puntuajeOpCompl = 0;
        do {
            
            Socket cliente = server.accept();
            do {
        
                int v1 = Integer.parseInt(gestor.recibir(cliente));
                String simb = gestor.recibir(cliente);
                int v2 = Integer.parseInt(gestor.recibir(cliente));

                
                Operacion operacion = FactOperacion.generarOperacion(v1, v2, simb);
                
                int resultado = operacion.operar();
                
                gestor.enviar(cliente, String.valueOf(resultado));

                if (operacion.getTipo() == 5) {
                    puntuajeOpSimple++;
                } else{
                    puntuajeOpCompl++;
                }
                
                gestor.enviar(cliente, String.valueOf(puntuajeOpSimple));
                gestor.enviar(cliente, String.valueOf(puntuajeOpCompl));
                
                loggeo(resultado);
                
                int salir = Integer.valueOf(gestor.recibir(cliente));
                
                if (salir == 0) {
                    cliente.close();
                }
            } while (!cliente.isClosed());
            server.close();
        }while (!server.isClosed());
    }


    private static void loggeo(int resultado) throws SecurityException, IOException{
        Logger logger = Logger.getLogger(LOGGER);
        FileHandler fh = new FileHandler(FICHERO_LOG, true);
        SimpleFormatter formatter = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(formatter);

        logger.log(Level.INFO, RESULTADO + resultado);
    }
}