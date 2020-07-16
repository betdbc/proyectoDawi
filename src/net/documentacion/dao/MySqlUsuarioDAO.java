package net.documentacion.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.documentacion.entidad.Enlace;
import net.documentacion.entidad.Laboratorio;
import net.documentacion.entidad.Usuario;
import net.documentacion.interfaces.UsuarioDAO;

public class MySqlUsuarioDAO implements UsuarioDAO {
	SqlSessionFactory factory=null;
	{
		try {
			//variable para almacenar el nombre del archivo que tiene la conex. a la BD
			String archivo="ConfiguracionIbatis.xml";
			//leer el arhivo XML
			Reader reader=Resources.getResourceAsReader(archivo);
			//crear objeto seg�n el valor del objeto "reader"
			factory=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Usuario iniciarSesion(Usuario bean) {
		Usuario obj=null;
		//crear una sesi�n de la conexi�n "factory"
		SqlSession session=factory.openSession();
		try {
			obj=(Usuario) session.selectOne("SQL_InicarSesion",bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return obj;
	}

	@Override
	public List<Enlace> traerEnlancesPorUsuario(int codUsu) {
		List<Enlace> lista=new ArrayList<Enlace>();
		//crear una sesi�n de la conexi�n "factory"
		SqlSession session=factory.openSession();
		try {
			lista=session.selectList("SQL_TraerEnlacesPorUSuario",codUsu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return lista;
	}

}
