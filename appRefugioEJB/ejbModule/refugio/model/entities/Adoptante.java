package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the adoptante database table.
 * 
 */
@Entity
@Table(name="adoptante")
@NamedQuery(name="Adoptante.findAll", query="SELECT a FROM Adoptante a")
public class Adoptante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_adoptante", unique=true, nullable=false)
	private Integer idAdoptante;

	@Column(name="apellido_adoptante", length=2147483647)
	private String apellidoAdoptante;

	@Column(name="cedula_adoptante", length=2147483647)
	private String cedulaAdoptante;

	@Column(length=2147483647)
	private String celular;

	@Column(length=2147483647)
	private String direccion;

	private Integer edad;

	@Column(length=2147483647)
	private String email;

	@Column(name="nombre_adoptante", length=2147483647)
	private String nombreAdoptante;

	@Column(length=2147483647)
	private String ocupacion;

	@Column(length=2147483647)
	private String telefono;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="adoptante")
	private List<Reserva> reservas;

	public Adoptante() {
	}

	public Integer getIdAdoptante() {
		return this.idAdoptante;
	}

	public void setIdAdoptante(Integer idAdoptante) {
		this.idAdoptante = idAdoptante;
	}

	public String getApellidoAdoptante() {
		return this.apellidoAdoptante;
	}

	public void setApellidoAdoptante(String apellidoAdoptante) {
		this.apellidoAdoptante = apellidoAdoptante;
	}

	public String getCedulaAdoptante() {
		return this.cedulaAdoptante;
	}

	public void setCedulaAdoptante(String cedulaAdoptante) {
		this.cedulaAdoptante = cedulaAdoptante;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreAdoptante() {
		return this.nombreAdoptante;
	}

	public void setNombreAdoptante(String nombreAdoptante) {
		this.nombreAdoptante = nombreAdoptante;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setAdoptante(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setAdoptante(null);

		return reserva;
	}

}