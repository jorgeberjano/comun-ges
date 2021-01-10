package es.jbp.comun.ges.dao;

/**
 * Contrato para las clases que implementan la paginación
 * @author jberjano
 */
public interface Pagina {
    
    Integer getIndicePrimerElemento();

    Integer getNumeroElementos();
   
}
