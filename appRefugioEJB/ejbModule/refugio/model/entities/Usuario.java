package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="apellido_usuario")
	private String apellidoUsuario;

	@Column(name="cedula_usuario", unique=true, length=10)
	private String cedulaUsuario;

	@Column(name="clave_usuario")
	private String claveUsuario;

	@Column(name="email_usuario")
	private String emailUsuario;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	@Column(name="telefono_usuario")
	private String telefonoUsuario;

	@Column(name="tipo_usuario")
	private String tipoUsuario;

	//bi-directional many-to-one association to RegistroAdopcion
	@OneToMany(mappedBy="usuario")
	private List<RegistroAdopcion> registroAdopcions;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidoUsuario() {
		return this.apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCedulaUsuario() {
		return this.cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTelefonoUsuario() {
		return this.telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<RegistroAdopcion> getRegistroAdopcions() {
		return this.registroAdopcions;
	}

	public void setRegistroAdopcions(List<RegistroAdopcion> registroAdopcions) {
		this.registroAdopcions = registroAdopcions;
	}

	public RegistroAdopcion addRegistroAdopcion(RegistroAdopcion registroAdopcion) {
		getRegistroAdopcions().add(registroAdopcion);
		registroAdopcion.setUsuario(this);

		return registroAdopcion;
	}

	public RegistroAdopcion removeRegistroAdopcion(RegistroAdopcion registroAdopcion) {
		getRegistroAdopcions().remove(registroAdopcion);
		registroAdopcion.setUsuario(null);

		return registroAdopcion;
	}

}