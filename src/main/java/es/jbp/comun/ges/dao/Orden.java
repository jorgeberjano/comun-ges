package es.jbp.comun.ges.dao;

import es.jbp.comun.ges.entidad.ConsultaGes;
import es.jbp.comun.utiles.sql.compatibilidad.FormateadorSql;

/**
 *
 * @author jorge
 */
public interface Orden {
    String getDescripcion();
    String generarSql(FormateadorSql formateadorSql, ConsultaGes consulta);
}
