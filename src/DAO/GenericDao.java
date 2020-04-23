package DAO;

import java.util.List;

import model.Usuario;

public interface GenericDao {
	public Usuario selectById(String Usuario);
	
	public List<Usuario> selectAll();
	public void insert(Usuario usuario);
	public void update (Usuario usuario);
	public void delete (Usuario usuario);
	

}
