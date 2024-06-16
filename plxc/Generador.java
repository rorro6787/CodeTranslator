public class Generador {

    public void variable(String variable, String valor) {
        if(valor.charAt(0) == '\'') {
            char valorAux = valor.charAt(1);
            int aux = (int) valorAux;
            valor = "" + aux;
        }
        System.out.println("\t" + variable + " = " + valor + ";");
    }

    public void variableCast(String variable, String valor, String cast) {
        System.out.println("\t" + variable + " = (" + cast + ") " + valor + ";");
    }
    
    public void etiqueta(String etiqueta) {
        System.out.println(etiqueta + ":");
    }

    public void salto(String etiqueta) {
        System.out.println("\tgoto " + etiqueta + ";");
    } 

    public void suma(String variable, String a, String b) {
        System.out.println("\t" + variable + " = " + a + " + " + b + ";");
    }

    public void sumaReal(String variable, String a, String b) {
        System.out.println("\t" + variable + " = " + a + " +r " + b + ";");
    }

    public void sumaChar(String variable, String a, String b) {
        if(a.charAt(0) == '\'') {
            char valorAux = a.charAt(1);
            int aux = (int) valorAux;
            a = "" + aux;
        }
        if(b.charAt(0) == '\'') {
            char valorAux = b.charAt(1);
            int aux = (int) valorAux;
            b = "" + aux;
        }
        System.out.println("\t" + variable + " = " + a + " + " + b + ";");
    }

    public void resta(String variable, String a, String b) {
        System.out.println("\t" + variable + " = " + a + " - " + b + ";");
    }

    public void restaReal(String variable, String a, String b) {
        System.out.println("\t" + variable + " = " + a + " -r " + b + ";");
    }

    public void restaChar(String variable, String a, String b) {
        if(a.charAt(0) == '\'') {
            char valorAux = a.charAt(1);
            int aux = (int) valorAux;
            a = "" + aux;
        }
        if(b.charAt(0) == '\'') {
            char valorAux = b.charAt(1);
            int aux = (int) valorAux;
            b = "" + aux;
        }
        System.out.println("\t" + variable + " = " + a + " - " + b + ";");
    }

    public void producto(String variable, String a, String b) {
        System.out.println("\t" + variable + " = " + a + " * " + b + ";");
    }

    public void productoReal(String variable, String a, String b) {
        System.out.println("\t" + variable + " = " + a + " *r " + b + ";");
    }

    public void productoChar(String variable, String a, String b) {
        if(a.charAt(0) == '\'') {
            char valorAux = a.charAt(1);
            int aux = (int) valorAux;
            a = "" + aux;
        }
        if(b.charAt(0) == '\'') {
            char valorAux = b.charAt(1);
            int aux = (int) valorAux;
            b = "" + aux;
        }
        System.out.println("\t" + variable + " = " + a + " * " + b + ";");
    }

    public void division(String variable, String a, String b) {
        System.out.println("\t" + variable + " = " + a + " / " + b + ";");
    }

    public void divisionReal(String variable, String a, String b) {
        System.out.println("\t" + variable + " = " + a + " /r " + b + ";");
    }

    public void divisionChar(String variable, String a, String b) {
        if(a.charAt(0) == '\'') {
            char valorAux = a.charAt(1);
            int aux = (int) valorAux;
            a = "" + aux;
        }
        if(b.charAt(0) == '\'') {
            char valorAux = b.charAt(1);
            int aux = (int) valorAux;
            b = "" + aux;
        }
        System.out.println("\t" + variable + " = " + a + " / " + b + ";");
    }

    public void negativo(String variable, String a) {
        System.out.println("\t" + variable + " = -" + a + ";");
    }

    public void print(String argumento) {
        System.out.println("\tprint " + argumento + ";");
    }

    public void printC(String argumento) {
        if(argumento.charAt(0) == '\'') {
            char argumentoAux = argumento.charAt(1);
            int aux = (int) argumentoAux;
            argumento = "" + aux;
        }
        System.out.println("\tprintc " + argumento + ";");
    }

    public void ifMenor(String a, String b, String etiqueta) {
        System.out.println("\tif (" + a + " < " + b + ") goto " + etiqueta + ";");
    }
    
    public void ifIgual(String a, String b, String etiqueta) {
        System.out.println("\tif (" + a + " == " + b + ") goto " + etiqueta + ";");
    }

    public void errorHalt() {
        System.out.println("\terror;\n\thalt;");
        System.exit(-1);
    }
}