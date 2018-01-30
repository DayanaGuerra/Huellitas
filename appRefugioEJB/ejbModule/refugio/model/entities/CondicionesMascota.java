package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the condiciones_mascota database table.
 * 
 */
@Entity
@Table(name="condiciones_mascota")
@NamedQuery(name="CondicionesMascota.findAll", query="SELECT c FROM CondicionesMascota c")
public class CondicionesMascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONDICIONES_MASCOTA_IDCONDICIONESMASCOTA_GENERATOR", sequenceName="SEQ_CONDICIONES_MASCOTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONDICIONES_MASCOTA_IDCONDICIONESMASCOTA_GENERATOR")
	@Column(name="id_condiciones_mascota", unique=true, nullable=false)
	private Integer idCondicionesMascota;

	@Column(name="descripcion_condiciones", length=2147483647)
	private String descripcionCondiciones;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="condicionesMascota1")
	private List<Mascota> mascotas1;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="condicionesMascota2")
	private List<Mascota> mascotas2;

	public CondicionesMascota() {
	}

	public Integer getIdCondicionesMascota() {
		return this.idCondicionesMascota;
	}

	public void setIdCondicionesMascota(Integer idCondicionesMascota) {
		this.idCondicionesMascota = idCondicionesMascota;
	}

	public String getDescripcionCondiciones() {
		return this.descripcionCondiciones;
	}

	public void setDescripcionCondiciones(String descripcionCondiciones) {
		this.descripcionCondiciones = descripcionCondiciones;
	}

	public List<Mascota> getMascotas1() {
		return this.mascotas1;
	}

	public void setMascotas1(List<Mascota> mascotas1) {
		this.mascotas1 = mascotas1;
	}

	public Mascota addMascotas1(Mascota mascotas1) {
		getMascotas1().add(mascotas1);
		mascotas1.setCondicionesMascota1(this);

		return mascotas1;
	}

	public Mascota removeMascotas1(Mascota mascotas1) {
		getMascotas1().remove(mascotas1);
		mascotas1.setCondicionesMascota1(null);

		return mascotas1;
	}

	public List<Mascota> getMascotas2() {
		return this.mascotas2;
	}

	public void setMascotas2(List<Mascota> mascotas2) {
		this.mascotas2 = mascotas2;
	}

	public Mascota addMascotas2(Mascota mascotas2) {
		getMascotas2().add(mascotas2);
		mascotas2.setCondicionesMascota2(this);

		return mascotas2;
	}

	public Mascota removeMascotas2(Mascota mascotas2) {
		getMascotas2().remove(mascotas2);
		mascotas2.setCondicionesMascota2(null);

		return mascotas2;
	}

}