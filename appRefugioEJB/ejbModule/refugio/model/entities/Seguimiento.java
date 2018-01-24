package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the seguimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Seguimiento.findAll", query="SELECT s FROM Seguimiento s")
public class Seguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEGUIMIENTO_IDSEGUIMIENTO_GENERATOR", sequenceName="SEQ_SEGUIMIENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEGUIMIENTO_IDSEGUIMIENTO_GENERATOR")
	@Column(name="id_seguimiento")
	private Integer idSeguimiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_seguimiento")
	private Date fechaSeguimiento;

	//bi-directional many-to-one association to Adoptante
	@ManyToOne
	@JoinColumn(name="cedula_adoptante")
	private Adoptante adoptante;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="id_mascota")
	private Mascota mascota;

	//bi-directional many-to-one association to CondicionesEspacio
	@ManyToOne
	@JoinColumn(name="id_condiciones_espacio")
	private CondicionesEspacio condicionesEspacio;

	public Seguimiento() {
	}

	public Integer getIdSeguimiento() {
		return this.idSeguimiento;
	}

	public void setIdSeguimiento(Integer idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	public Date getFechaSeguimiento() {
		return this.fechaSeguimiento;
	}

	public void setFechaSeguimiento(Date fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}

	public Adoptante getAdoptante() {
		return this.adoptante;
	}

	public void setAdoptante(Adoptante adoptante) {
		this.adoptante = adoptante;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public CondicionesEspacio getCondicionesEspacio() {
		return this.condicionesEspacio;
	}

	public void setCondicionesEspacio(CondicionesEspacio condicionesEspacio) {
		this.condicionesEspacio = condicionesEspacio;
	}

}