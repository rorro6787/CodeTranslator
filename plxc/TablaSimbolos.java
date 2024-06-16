import java.util.*;
public class TablaSimbolos {
    private static HashMap<String, String> tc;
    
    public TablaSimbolos() {
        tc = new HashMap<String, String>();
    }
    public String buscar(String ident) {
        return tc.get(ident);
    }

    public void insertar(String ident, String tipo) {
        tc.put(ident, tipo);
    } 
} 