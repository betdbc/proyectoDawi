package net.farmacia.interfaces;
import java.util.List;
import net.farmacia.entidad.Enlace;
import net.farmacia.entidad.Usuario;

public interface UsuarioDAO {
	public Usuario iniciarSesion(Usuario bean);//String login,String clave
	public List<Enlace> traerEnlancesPorUsuario(int codUsu);
	
	
}
