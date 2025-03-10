package es.etg.dam.psp.maf;

public abstract class Operacion {
    protected int valor1;
    protected int valor2;
    protected int tipo;

    
    
    public int getTipo() {
        return tipo;
    }


    public Operacion(int v1, int v2){
        this.valor1 = v1;
        this.valor2 = v2;
    };
    

    abstract int operar();
    
    public void setTipo(int tipo) {
        this.tipo += tipo;
    }
}
