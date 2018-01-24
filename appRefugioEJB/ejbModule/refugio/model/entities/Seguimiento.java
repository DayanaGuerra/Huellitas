package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;


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

	@Column(name="satisfaccion_adoptante")
	private Boolean satisfaccionAdoptante;

	//bi-directional many-to-one association to EspacioAsignado
	@ManyToOne
	@JoinColumn(name="id_espacio_asignado")
	private EspacioAsignado espacioAsignado;

	//bi-directional many-to-one association to RegistroAdopcion
	@ManyToOne
	@JoinColumn(name="id_registro_adopcion")
	private RegistroAdopcion registroAdopcion;

	public Seguimiento() {
	}

	public Integer getIdSeguimiento() {
		return this.idSeguimiento;
	}

	public void setIdSeguimiento(Integer idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}

	public Boolean getSatisfaccionAdoptante() {
		return this.satisfaccionAdoptante;
	}

	public void setSatisfaccionAdoptante(Boolean satisfaccionAdoptante) {
		this.satisfaccionAdoptante = satisfaccionAdoptante;
	}

	public EspacioAsignado getEspacioAsignado() {
		return this.espacioAsignado;
	}

	public void setEspacioAsignado(EspacioAsignado espacioAsignado) {
		this.espacioAsignado = espacioAsignado;
	}

	public RegistroAdopcion getRegistroAdopcion() {
		return this.registroAdopcion;
	}

	public void setRegistroAdopcion(RegistroAdopcion registroAdopcion) {
		this.registroAdopcion = registroAdopcion;
	}

}