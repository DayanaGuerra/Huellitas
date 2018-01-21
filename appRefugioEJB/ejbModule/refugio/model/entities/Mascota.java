package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mascota database table.
 * 
 */
@Entity
@Table(name="mascota")
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mascota", unique=true, nullable=false)
	private Integer idMascota;

	@Column(length=2147483647)
	private String caracteristicas;

	@Column(name="condiciones_actuales", length=2147483647)
	private String condicionesActuales;

	private Integer edad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	private byte[] imagen;

	@Column(length=2147483647)
	private String observaciones;

	@Column(length=2147483647)
	private String sexo;

	//bi-directional many-to-one association to EstadoMascota
	@ManyToOne
	@JoinColumn(name="id_estado_mascota", nullable=false)
	private EstadoMascota estadoMascota;

	//bi-directional many-to-one association to Raza
	@ManyToOne
	@JoinColumn(name="id_raza", nullable=false)
	private Raza raza;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="mascota")
	private List<Reserva> reservas;

	public Mascota() {
	}

	public Integer getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}

	public String getCaracteristicas() {
		return this.caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getCondicionesActuales() {
		return this.condicionesActuales;
	}

	public void setCondicionesActuales(String condicionesActuales) {
		this.condicionesActuales = condicionesActuales;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public EstadoMascota getEstadoMascota() {
		return this.estadoMascota;
	}

	public void setEstadoMascota(EstadoMascota estadoMascota) {
		this.estadoMascota = estadoMascota;
	}

	public Raza getRaza() {
		return this.raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setMascota(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setMascota(null);

		return reserva;
	}

}