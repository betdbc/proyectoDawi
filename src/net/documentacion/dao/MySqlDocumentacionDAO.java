package net.documentacion.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.documentacion.entidad.Documentacion;
import net.documentacion.interfaces.DocumentacionDAO;

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
	
	@Override
	public int addDocumentacion(Documentacion doc) {
		int estado=-1;
		SqlSession session=factory.openSession();
		try {
			estado=session.insert("SQL_InsertarDocumentacion",doc);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return estado;
	}
	@Override
	public int updateDocumentacion(Documentacion doc) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteDocumentacion(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
