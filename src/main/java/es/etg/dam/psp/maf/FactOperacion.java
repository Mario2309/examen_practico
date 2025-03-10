package es.etg.dam.psp.maf;

public interface FactOperacion{
    public static Operacion generarOperacion(int v1, int v2, String simb){
            switch (simb) {
                case "+":
                    return new Suma(v1, v2);
                case "-":
                    return new Resta(v1, v2);
                case "*":
                    return new Multiplicacion(v1, v2);
                case "/":
                    return new Division(v1, v2);
                default:
                    break;
            }
            return null;
        }
}
