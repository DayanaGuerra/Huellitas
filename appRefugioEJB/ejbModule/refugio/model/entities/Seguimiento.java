package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seguimiento database table.
 * 
 */
@Entity
@Table(name="seguimiento")
@NamedQuery(name="Seguimiento.findAll", query="SELECT s FROM Seguimiento s")
public class Seguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_seguimiento", unique=true, nullable=false)
	private Integer idSeguimiento;

	@Column(length=2147483647)
	private String observaciones;

	@Column(name="satisfaccion_adoptante", length=2147483647)
	private String satisfaccionAdoptante;

	//bi-directional many-to-one association to EspacioAsignado
	@ManyToOne
	@JoinColumn(name="id_espacio_asignado", nullable=false)
	private EspacioAsignado espacioAsignado;

	//bi-directional many-to-one association to EstadoMascota
	@ManyToOne
	@JoinColumn(name="id_estado_mascota", nullable=false)
	private EstadoMascota estadoMascota;

	//bi-directional many-to-one association to Registro
	@ManyToOne
	@JoinColumn(name="id_registro", nullable=false)
	private Registro registro;

	public Seguimiento() {
	}

	public Integer getIdSeguimiento() {
		return this.idSeguimiento;
	}

	public void setIdSeguimiento(Integer idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getSatisfaccionAdoptante() {
		return this.satisfaccionAdoptante;
	}

	public void setSatisfaccionAdoptante(String satisfaccionAdoptante) {
		this.satisfaccionAdoptante = satisfaccionAdoptante;
	}

	public EspacioAsignado getEspacioAsignado() {
		return this.espacioAsignado;
	}

	public void setEspacioAsignado(EspacioAsignado espacioAsignado) {
		this.espacioAsignado = espacioAsignado;
	}

	public EstadoMascota getEstadoMascota() {
		return this.estadoMascota;
	}

	public void setEstadoMascota(EstadoMascota estadoMascota) {
		this.estadoMascota = estadoMascota;
	}

	public Registro getRegistro() {
		return this.registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

}