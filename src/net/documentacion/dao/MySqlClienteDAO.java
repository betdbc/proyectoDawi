package net.documentacion.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.documentacion.entidad.Cliente;
import net.documentacion.entidad.Laboratorio;
import net.documentacion.interfaces.ClienteDAO;

public class MySqlClienteDAO implements ClienteDAO {
	//crear un objeto que permita obtener la conexión con la base de datos que se encuentra 
	//en el archivo ConfiguracionIbatis.xml
	SqlSessionFactory factory=null;
	{
		try {
			//variable para almacenar el nombre del archivo que tiene la conex. a la BD
			String archivo="ConfiguracionIbatis.xml";
			//leer el arhivo XML
			Reader reader=Resources.getResourceAsReader(archivo);
			//crear objeto según el valor del objeto "reader"
			factory=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Cliente> listaClientes() {
		List<Cliente> lista=new ArrayList<Cliente>();
		//crear una sesión de la conexión "factory"
		SqlSession session=factory.openSession();
		try {
			lista=session.selectList("SQL_listarClientes");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return lista;
	}

}
