package es.jbp.comun.ges.dao.r2dbc;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;

/**
 *
 * @author jorge
 */
public class GestorConexioneReactivas {

    public String driver;
    public String database;
    public String user;
    public String password;

    public ConnectionFactory getConectionFactory() {

        ConnectionFactoryOptions options
                = ConnectionFactoryOptions.builder()
                        .option(ConnectionFactoryOptions.DRIVER, driver)
                        .option(ConnectionFactoryOptions.DATABASE, database)
                        .option(ConnectionFactoryOptions.USER, user)
                        .build();

        return ConnectionFactories.find(options);
    }
}
