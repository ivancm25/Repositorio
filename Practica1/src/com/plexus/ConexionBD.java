package com.plexus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ConexionBD.
 */
public class ConexionBD {
    
    /** The host. */
    private static String host;
    
    /** The port. */
    private static String port;
    
    /** The db. */
    private static String db;
    
    /** The user. */
    private static String user;
    
    /** The password. */
    private static String password;
    
    /** The lista. */
    private static ArrayList<Connection> lista = null;
    
    /** The Constant NUMCON. */
    private static final int NUMCON = 10;
    
    /** The Constant NUMCONINC. */
    private static final int NUMCONINC = 2;    
    
    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger("LOG_BD");                                                   //https://www.vogella.com/tutorials/Logging/article.html
    
    /**
     * Instantiates a new conexion BD.
     */
    private ConexionBD() {
        
        LOG.setLevel(Level.INFO);
        cargarPropiedades();
        lista = new ArrayList<Connection>();
        crearConexions(NUMCON);
    }
    
    /**
     * Crear conexions.
     *
     * @param num the num
     */
    private static void crearConexions(int num) {        
        String cadeaConexion = "jdbc:mysql://" + host + ":" + port + "/" + db +"?serverTimeZone=Europe/Madrid";
        for (int i = 0; i < num; i++) {
            try {
                lista.add(DriverManager.getConnection(cadeaConexion, user, password));
            } catch (SQLException e) {                
                LOG.info("Erro creando conexión: " + e.getMessage());
            }
        }
    }
    
    /**
     * Obter conexion.
     *
     * @return the connection
     */
    public static Connection obterConexion() {
        
        if (lista == null) {
            new ConexionBD();
        }
        
        if (lista.size() == 0) {
            crearConexions(NUMCONINC);            
        }   
        
        Connection con = null;
        
        try {
            con = lista.remove(0);
        } catch(IndexOutOfBoundsException e) {
            LOG.info("Erro voltando conexión: " + e.getMessage());
        }
        return con;
    }
    
    /**
     * Devolver conexion.
     *
     * @param conn the conn
     */
    public static void devolverConexion(Connection conn) {
        lista.add(conn);
    }
    
    
    
    
    /**
     * Cargar propiedades.
     */
    private static void cargarPropiedades() {
          user = "root";
          password = "";
          db = "practica1";
          port = "3306";
          host = "localhost";            
            
    }

}
