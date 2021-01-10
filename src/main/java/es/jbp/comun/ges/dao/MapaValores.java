package es.jbp.comun.ges.dao;

import es.jbp.comun.ges.entidad.CampoGes;
import es.jbp.comun.ges.entidad.ConsultaGes;
import es.jbp.comun.ges.utilidades.ConversionValores;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Clase que encapsula un mapa ordenado de valores de campos (idCampo-valor)
 * @author Jorge
 */
public class MapaValores {

    private LinkedHashMap<String, Object> mapa;
    
    public MapaValores() {   
        mapa = new LinkedHashMap();
    }

    public MapaValores(Map<String, Object> mapaValores) {
        this.mapa = new LinkedHashMap();
        this.mapa.putAll(mapaValores);
    }

    public LinkedHashMap<String, Object> getMapa() {
        return mapa;
    }
   
    public boolean isEmpty() {
        return mapa.isEmpty();
    }
    
    public Set<String> keySet() {
        return mapa.keySet();
    }
    
    public boolean contiene(String idCampo) {
        return mapa.containsKey(idCampo);
    }

    public void set(String idCampo, Object valor) {
        mapa.put(idCampo, valor);
    }

    public Object get(String idCampo) {
        return mapa.get(idCampo);
    }
    
    public String toString() {
        return formatear("%", "=");
    }
        
    public void parsear(String cadena, ConsultaGes consulta, String separadorCampos, String separadorNombreValor) {
        String[] partes = cadena.split(separadorCampos);
        for (String parte : partes) {
            String[] asignacion = parte.split(separadorNombreValor);
            if (asignacion.length == 2) {
                String id = asignacion[0];
                CampoGes campo = consulta.getCampoPorId(id); 
                if (campo == null) {
                        return;
                }
                //Object valor = campo.convertirValor(asignacion[1]);
                Object valor = asignacion[1];
                valor = ConversionValores.aValorBD(valor, campo);
                set(id, valor);
            }
        }
    }
    
    public String formatear(String separadorCampos, String separadorNombreValor) {
        StringBuilder builder = new StringBuilder();
        boolean vacia = true;
        for (String nombre : mapa.keySet()) {            
            Object valor = mapa.get(nombre);
            if (valor == null) {
                continue;
            }
            if (!vacia) {
                builder.append(separadorCampos);
            }
            builder.append(nombre);
            builder.append(separadorNombreValor);
            builder.append(valor.toString());
            vacia = false;
        }
        return builder.toString();
    }  
    
    
}
