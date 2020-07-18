package net.documentacion.fabrica;
import net.documentacion.interfaces.ClienteDAO;
import net.documentacion.interfaces.ColegioDAO;
import net.documentacion.interfaces.DocumentacionDAO;
import net.documentacion.interfaces.IngresoDAO;
import net.documentacion.interfaces.LaboratorioDAO;
import net.documentacion.interfaces.MedicamentoDAO;
import net.documentacion.interfaces.TipoMedicamentoDAO;
import net.documentacion.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	// los posibles orígenes de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    // Existirá un método get por cada DAO que exista en el sistema
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    // registramos nuestros daos
    public abstract DocumentacionDAO getDocumentacionDAO();
    public abstract ColegioDAO getColegioDAO();
    public abstract IngresoDAO getIngresoDAO();
    
    
    public abstract LaboratorioDAO getLaboratorioDAO();
    public abstract MedicamentoDAO getMedicamentoDAO();
    public abstract TipoMedicamentoDAO getTipoMedicamentoDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract ClienteDAO getClienteDAO(); 
 
    
    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case XML:
        	    //return new XmlDAOFactory();
        	case ORACLE:
        	    //return new OracleDAOFactory();
        	/*case DB2:
        	    return new Db2DAOFactory();
        	case SQLSERVER:
        	    return new SqlServerDAOFactory();
        	case XML:
        	    return new XmlDAOFactory();*/
        	default:
        	    return null;
        }
     }
}
