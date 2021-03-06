package net.documentacion.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import net.documentacion.entidad.Colegio;
import net.documentacion.entidad.Documentacion;
import net.documentacion.interfaces.ColegioDAO;

public class MySqlColegioDAO implements ColegioDAO{
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
		
		//LISTAR TODOS LOS COLEGIOS
		@Override
		public List<Colegio> listaColegio() {
			List<Colegio> lista=new ArrayList<Colegio>();
			//crear una sesi�n de la conexi�n "factory"
			SqlSession session=factory.openSession();
			try {
				lista=session.selectList("SQL_listarColegios");
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				session.close();
			}
			return lista;
		}
		
		
		
		//REGISTRAR COLEGIO
		@Override
		public int saveColegio(Colegio col) {
			int estado=-1;
			SqlSession session=factory.openSession();
			try {
				estado=session.insert("SQL_InsertarColegio",col);
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
		public List<Colegio> listacombo() {
			List<Colegio> lista=new ArrayList<Colegio>();
			//crear una sesi�n de la conexi�n "factory"
			SqlSession session=factory.openSession();
			try {
				lista=session.selectList("SQL_listarColegiosCombo");
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				session.close();
			}
			return lista;
		}
		
		
		
		
	
}
