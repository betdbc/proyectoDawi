package net.documentacion.dao;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.documentacion.entidad.Laboratorio;
import net.documentacion.interfaces.LaboratorioDAO;
public class MySqlLaboratorioDAO implements LaboratorioDAO {
	//crear un objeto que permita obtener la conexi�n con la base de datos que se encuentra 
	//en el archivo ConfiguracionIbatis.xml
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
	public int addLaboratorio(Laboratorio lab) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLaboratorio(Laboratorio lab) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLaboratorio(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Laboratorio> listLaboratorio() {
		List<Laboratorio> lista=new ArrayList<Laboratorio>();
		//crear una sesi�n de la conexi�n "factory"
		SqlSession session=factory.openSession();
		try {
			lista=session.selectList("SQL_listarLaboratorios");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return lista;
	}

	@Override
	public Laboratorio findLaboratorio(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
