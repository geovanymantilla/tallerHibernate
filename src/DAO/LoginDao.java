package DAO;

import model.Usuario;

public class LoginDao {
	public String authenticateUser(Usuario usuario) {
		GenericDao usuarioDao = new UsuarioDao();
		Usuario u = usuarioDao.selectById(usuario.getUsuario());
		if(u!=null) {
			if(u.getClave().contentEquals(usuario.getClave())) {
				return "SUCCESS";
			}
		}
		return "ERROR";
		
	}
}
