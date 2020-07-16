package net.documentacion.interfaces;
import java.util.List;

import net.documentacion.entidad.Enlace;
import net.documentacion.entidad.Usuario;

public interface UsuarioDAO {
	public Usuario iniciarSesion(Usuario bean);//String login,String clave
	public List<Enlace> traerEnlancesPorUsuario(int codUsu);
	
	
}
