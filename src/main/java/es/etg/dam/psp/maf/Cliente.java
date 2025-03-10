package es.etg.dam.psp.maf;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Constantes{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int salir = 1;
        GestorMensaje gestor = new GestorMensaje();
        
        Socket cliente = new Socket(HOST, PUERTO);
        do {
            System.out.print(VALOR_1);
            gestor.enviar(cliente, String.valueOf(sc.nextInt()));
            
            System.out.print(SIMBOLO);
            gestor.enviar(cliente, sc.next());
    
            System.out.print(VALOR_2);
            gestor.enviar(cliente, String.valueOf(sc.nextInt()));
            
            System.out.println(RESULTADO + gestor.recibir(cliente));

            System.out.println(PUNT_OP_SIM + gestor.recibir(cliente));
            System.out.println(PUNT_OP_COMP + gestor.recibir(cliente));

            System.out.println(SALIR);
            salir = sc.nextInt();
            gestor.enviar(cliente, String.valueOf(salir));

            if (salir == 0) {
                cliente.close();
            }
            
        } while (!cliente.isClosed());
        sc.close();


    }
}
