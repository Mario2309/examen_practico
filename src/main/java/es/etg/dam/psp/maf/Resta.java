package es.etg.dam.psp.maf;

public class Resta extends Operacion{

    private int tipoOp = 5;

    public Resta(int v1, int v2) {
        super(v1, v2);
        super.tipo = this.tipoOp;
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public int operar() {
        return valor1 - valor2;
    }

}
