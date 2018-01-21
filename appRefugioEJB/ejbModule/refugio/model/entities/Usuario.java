package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Array;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario", unique=true, nullable=false)
	private Integer idUsuario;

	@Column(name="apellido_usuario", length=2147483647)
	private String apellidoUsuario;

	@Column(name="cedula_usuario", length=2147483647)
	private String cedulaUsuario;

	@Column(name="clave_usuario", length=20)
	private Array claveUsuario;

	@Column(name="email_usuario", length=2147483647)
	private String emailUsuario;

	@Column(name="nombre_usuario", nullable=false, length=100)
	private Array nombreUsuario;

	@Column(name="telefono_usuario", length=2147483647)
	private String telefonoUsuario;

	@Column(name="tipo_usuario", nullable=false, length=2)
	private Array tipoUsuario;

	//bi-directional many-to-one association to Registro
	@OneToMany(mappedBy="usuario")
	private List<Registro> registros;

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

	public Array getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(Array claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Array getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(Array nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTelefonoUsuario() {
		return this.telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public Array getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(Array tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public Registro addRegistro(Registro registro) {
		getRegistros().add(registro);
		registro.setUsuario(this);

		return registro;
	}

	public Registro removeRegistro(Registro registro) {
		getRegistros().remove(registro);
		registro.setUsuario(null);

		return registro;
	}

}