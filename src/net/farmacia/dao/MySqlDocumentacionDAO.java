package net.farmacia.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.farmacia.entidad.Documentacion;
import net.farmacia.interfaces.DocumentacionDAO;

public class MySqlDocumentacionDAO implements DocumentacionDAO{
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
	public List<Documentacion> listaDocumentacion() {
		List<Documentacion> lista=new ArrayList<Documentacion>();
		//crear una sesión de la conexión "factory"
		SqlSession session=factory.openSession();
		try {
			lista=session.selectList("SQL_listarDocumentacion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
