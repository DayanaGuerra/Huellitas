package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATALOGO_IDCATALOGO_GENERATOR", sequenceName="SEQ_CATALOGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATALOGO_IDCATALOGO_GENERATOR")
	@Column(name="id_catalogo")
	private Integer idCatalogo;

	@Column(name="estado_catalogo")
	private Boolean estadoCatalogo;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="id_mascota")
	private Mascota mascota;

	public Catalogo() {
	}

	public Integer getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public Boolean getEstadoCatalogo() {
		return this.estadoCatalogo;
	}

	public void setEstadoCatalogo(Boolean estadoCatalogo) {
		this.estadoCatalogo = estadoCatalogo;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

}