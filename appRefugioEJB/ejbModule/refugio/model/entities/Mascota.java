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
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MASCOTA_IDMASCOTA_GENERATOR", sequenceName="SEQ_MASCOTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MASCOTA_IDMASCOTA_GENERATOR")
	@Column(name="id_mascota")
	private Integer idMascota;

	private Boolean adopcion;

	private String caracteristicas;

	private Integer edad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	private byte[] imagen;

	private String observaciones;

	private String sexo;

	//bi-directional many-to-one association to Catalogo
	@OneToMany(mappedBy="mascota")
	private List<Catalogo> catalogos;

	//bi-directional many-to-one association to EstadoMascota
	@ManyToOne
	@JoinColumn(name="condiciones_ingreso")
	private EstadoMascota estadoMascota1;

	//bi-directional many-to-one association to EstadoMascota
	@ManyToOne
	@JoinColumn(name="condiciones_actuales")
	private EstadoMascota estadoMascota2;

	//bi-directional many-to-one association to Raza
	@ManyToOne
	@JoinColumn(name="id_raza")
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

	public Boolean getAdopcion() {
		return this.adopcion;
	}

	public void setAdopcion(Boolean adopcion) {
		this.adopcion = adopcion;
	}

	public String getCaracteristicas() {
		return this.caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
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

	public List<Catalogo> getCatalogos() {
		return this.catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public Catalogo addCatalogo(Catalogo catalogo) {
		getCatalogos().add(catalogo);
		catalogo.setMascota(this);

		return catalogo;
	}

	public Catalogo removeCatalogo(Catalogo catalogo) {
		getCatalogos().remove(catalogo);
		catalogo.setMascota(null);

		return catalogo;
	}

	public EstadoMascota getEstadoMascota1() {
		return this.estadoMascota1;
	}

	public void setEstadoMascota1(EstadoMascota estadoMascota1) {
		this.estadoMascota1 = estadoMascota1;
	}

	public EstadoMascota getEstadoMascota2() {
		return this.estadoMascota2;
	}

	public void setEstadoMascota2(EstadoMascota estadoMascota2) {
		this.estadoMascota2 = estadoMascota2;
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