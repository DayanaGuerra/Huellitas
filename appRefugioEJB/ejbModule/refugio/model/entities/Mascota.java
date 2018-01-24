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

	@Column(name="caracteristicas_mascota")
	private String caracteristicasMascota;

	@Column(name="edad_mascota")
	private Integer edadMascota;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso_mascota")
	private Date fechaIngresoMascota;

	@Column(name="imagen_mascota")
	private byte[] imagenMascota;

	@Column(name="observaciones_mascota")
	private String observacionesMascota;

	@Column(name="sexo_mascota")
	private String sexoMascota;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="mascota")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="mascota")
	private List<Seguimiento> seguimientos;

	//bi-directional many-to-one association to Historial
	@OneToMany(mappedBy="mascota")
	private List<Historial> historials;

	//bi-directional many-to-one association to CondicionesMascota
	@ManyToOne
	@JoinColumn(name="condiciones_ingreso_mascota")
	private CondicionesMascota condicionesMascota1;

	//bi-directional many-to-one association to CondicionesMascota
	@ManyToOne
	@JoinColumn(name="condiciones_actuales_mascota")
	private CondicionesMascota condicionesMascota2;

	//bi-directional many-to-one association to EspecieRaza
	@ManyToOne
	@JoinColumn(name="id_especie_raza")
	private EspecieRaza especieRaza;

	public Mascota() {
	}

	public Integer getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}

	public String getCaracteristicasMascota() {
		return this.caracteristicasMascota;
	}

	public void setCaracteristicasMascota(String caracteristicasMascota) {
		this.caracteristicasMascota = caracteristicasMascota;
	}

	public Integer getEdadMascota() {
		return this.edadMascota;
	}

	public void setEdadMascota(Integer edadMascota) {
		this.edadMascota = edadMascota;
	}

	public Date getFechaIngresoMascota() {
		return this.fechaIngresoMascota;
	}

	public void setFechaIngresoMascota(Date fechaIngresoMascota) {
		this.fechaIngresoMascota = fechaIngresoMascota;
	}

	public byte[] getImagenMascota() {
		return this.imagenMascota;
	}

	public void setImagenMascota(byte[] imagenMascota) {
		this.imagenMascota = imagenMascota;
	}

	public String getObservacionesMascota() {
		return this.observacionesMascota;
	}

	public void setObservacionesMascota(String observacionesMascota) {
		this.observacionesMascota = observacionesMascota;
	}

	public String getSexoMascota() {
		return this.sexoMascota;
	}

	public void setSexoMascota(String sexoMascota) {
		this.sexoMascota = sexoMascota;
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

	public List<Seguimiento> getSeguimientos() {
		return this.seguimientos;
	}

	public void setSeguimientos(List<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public Seguimiento addSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().add(seguimiento);
		seguimiento.setMascota(this);

		return seguimiento;
	}

	public Seguimiento removeSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().remove(seguimiento);
		seguimiento.setMascota(null);

		return seguimiento;
	}

	public List<Historial> getHistorials() {
		return this.historials;
	}

	public void setHistorials(List<Historial> historials) {
		this.historials = historials;
	}

	public Historial addHistorial(Historial historial) {
		getHistorials().add(historial);
		historial.setMascota(this);

		return historial;
	}

	public Historial removeHistorial(Historial historial) {
		getHistorials().remove(historial);
		historial.setMascota(null);

		return historial;
	}

	public CondicionesMascota getCondicionesMascota1() {
		return this.condicionesMascota1;
	}

	public void setCondicionesMascota1(CondicionesMascota condicionesMascota1) {
		this.condicionesMascota1 = condicionesMascota1;
	}

	public CondicionesMascota getCondicionesMascota2() {
		return this.condicionesMascota2;
	}

	public void setCondicionesMascota2(CondicionesMascota condicionesMascota2) {
		this.condicionesMascota2 = condicionesMascota2;
	}

	public EspecieRaza getEspecieRaza() {
		return this.especieRaza;
	}

	public void setEspecieRaza(EspecieRaza especieRaza) {
		this.especieRaza = especieRaza;
	}

}