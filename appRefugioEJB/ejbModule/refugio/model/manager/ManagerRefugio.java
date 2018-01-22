package refugio.model.manager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import refugio.model.entities.Usuario;

/**
 * Session Bean implementation class ManagerRefugio
 */
@Stateless
@LocalBean
public class ManagerRefugio {
	@PersistenceContext(unitName = "RefugioDS")
	private EntityManager em;

    /**
     * Default constructor. 
     */

	public void registrarUsuario(String apellido_usuario,String cedula_usuario, String clave_usuario, String email_usuario,
			String nombre_usuario, String telefono_usuario, String tipo_usuario)throws Exception{
		if(cedula_usuario==null)
			throw new Exception ("Debe ingresar la cédula");
		Usuario u= new Usuario ();
		
		u.setApellidoUsuario(apellido_usuario);
		u.setCedulaUsuario(cedula_usuario);
		u.setClaveUsuario(clave_usuario);
		u.setEmailUsuario(email_usuario);
		u.setNombreUsuario(nombre_usuario);
		u.setTelefonoUsuario(telefono_usuario);
		u.setTipoUsuario(tipo_usuario);
		em.persist(u);
		
	}
     
    

}
