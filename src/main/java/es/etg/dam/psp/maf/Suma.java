package es.etg.dam.psp.maf;

public class Suma extends Operacion{
    
    private int tipoOp = 1;

    public Suma(int v1, int v2) {
        super(v1, v2);
        super.tipo = this.tipoOp;
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public int operar() {
        return valor1 + valor2;
    }



}
