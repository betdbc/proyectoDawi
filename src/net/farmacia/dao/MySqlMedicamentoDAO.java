package net.farmacia.dao;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import net.farmacia.entidad.Medicamento;
import net.farmacia.entidad.Parametros;
import net.farmacia.interfaces.MedicamentoDAO;

public class MySqlMedicamentoDAO implements MedicamentoDAO {
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
	public int addMedicamento(Medicamento med) {
		int estado=-1;
		SqlSession session=factory.openSession();
		try {
			estado=session.insert("SQL_InsertarMedicamento",med);
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
	public int updateMedicamento(Medicamento med) {
		int estado=-1;
		SqlSession session=factory.openSession();
		try {
			estado=session.update("SQL_ActualizarMedicamento",med);
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
	public int deleteMedicamento(int id) {
		int estado=-1;
		SqlSession session=factory.openSession();
		try {
			estado=session.delete("SQL_EliminarMedicamento",id);
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
	public List<Medicamento> listMedicamento() {
		List<Medicamento> lista=new ArrayList<Medicamento>();
		SqlSession session=factory.openSession();
		try {
			lista=session.selectList("SQL_listarMedicamentos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return lista;
	}

	@Override
	public Medicamento findMedicamento(int id) {
		Medicamento bean=null;
		SqlSession session=factory.openSession();
		try {
			bean=(Medicamento) session.selectOne("SQL_fotoMedicamento",id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return bean;
	}

	@Override
	public int updateFotoMedicamento(Medicamento med) {
		int estado=-1;
		SqlSession session=factory.openSession();
		try {
			estado=session.update("SQL_ActualizarFotoMedicamento",med);
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
	public List<Medicamento> listMedicamentoAtNombre(String nom) {
		List<Medicamento> lista=new ArrayList<Medicamento>();
		SqlSession session=factory.openSession();
		try {
			lista=session.selectList("SQL_listarMedicamentosAtNombre",nom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return lista;
	}

	@Override
	public List<Medicamento> listConsultaMedicamentoLaboratorioPorTipo(Parametros bean) {
		List<Medicamento> lista=new ArrayList<Medicamento>();
		SqlSession session=factory.openSession();
		try {
			lista=session.selectList("SQL_listarMedicamentosAtLaboratorioAtTipo",bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return lista;
	}

	@Override
	public List<Medicamento> listConsultaMedicamentoPorLaboratorio(int codLab) {
		List<Medicamento> lista=new ArrayList<Medicamento>();
		SqlSession session=factory.openSession();
		try {
			lista=session.selectList("SQL_listarMedicamentosAtLaboratorio",codLab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return lista;
	}

}





