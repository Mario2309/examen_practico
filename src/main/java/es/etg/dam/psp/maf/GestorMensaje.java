package es.etg.dam.psp.maf;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GestorMensaje {
    public void enviar(Socket cliente, String msg) throws IOException{
        OutputStream aux = cliente.getOutputStream();
        DataOutputStream output = new DataOutputStream(aux);
        if (!msg.isEmpty()) {
            output.writeUTF(msg);
            output.flush();
        }
    }

    public void enviarNumero(Socket cliente, int msg) throws IOException{
        OutputStream aux = cliente.getOutputStream();
        DataOutputStream output = new DataOutputStream(aux);
        output.write(msg);
        output.flush();
    }

    public String recibir(Socket cliente) throws IOException{
        InputStream aux = cliente.getInputStream();
        DataInputStream input = new DataInputStream(aux);
        return input.readUTF();
    }
}
