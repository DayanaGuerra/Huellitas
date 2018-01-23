package refugio.model.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import refugio.model.entities.Usuario;




/**
 * Session Bean implementation class ManagerRefugio
 */
@Stateless
@LocalBean
public class ManagerRefugio {
	@PersistenceContext(unitName = "RefugioDS")
	private EntityManager em;
	@EJB
	private ManagerDAO managerdao;
	
//REGISTRAR-USUARIOS
	public void registrarUsuario(String apellido_usuario,String cedula_usuario, String clave_usuario, String email_usuario,
			String nombre_usuario, String telefono_usuario, String tipo_usuario)throws Exception{
		Usuario usua = findUsuario(cedula_usuario);
		if (usua != null) {
			throw new Exception("Ya está registrado");
		}
		Usuario u = new Usuario();		
		u.setApellidoUsuario(apellido_usuario);
		u.setCedulaUsuario(cedula_usuario);
		u.setClaveUsuario(clave_usuario);
		u.setEmailUsuario(email_usuario);
		u.setNombreUsuario(nombre_usuario);
		u.setTelefonoUsuario(telefono_usuario);
		u.setTipoUsuario(tipo_usuario);
		em.persist(u);		
	}
	public Usuario findUsuario(String cedula_usuario) throws Exception {
		Usuario u = em.find(Usuario.class, cedula_usuario);
		return u;
	}
	//ACTUALIZAR-USUARIOS
	public void actualizarUsuario(String apellido_usuario,String cedula_usuario, String clave_usuario, String email_usuario,
			String nombre_usuario, String telefono_usuario, String tipo_usuario)throws Exception{
		Usuario u= findUsuario(cedula_usuario);
		
		u.setApellidoUsuario(apellido_usuario);
		u.setCedulaUsuario(cedula_usuario);
		u.setClaveUsuario(clave_usuario);
		u.setEmailUsuario(email_usuario);
		u.setNombreUsuario(nombre_usuario);
		u.setTelefonoUsuario(telefono_usuario);
		u.setTipoUsuario(tipo_usuario);
		em.merge(u);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() {
		Query q = em.createQuery("select u from Usuario u order by u.apellido_usuario");
		List<Usuario> lista = q.getResultList();
		return lista;
	}
	public void eliminarUsuario(String cedula_usuario) throws Exception {

		Usuario u = findUsuario(cedula_usuario);
		if (u == null)
			throw new Exception("No existe el usuario especificado");
		managerdao.eliminar(Usuario.class, cedula_usuario);
	}
}

    


