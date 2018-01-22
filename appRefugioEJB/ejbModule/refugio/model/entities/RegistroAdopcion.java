package refugio.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the registro_adopcion database table.
 * 
 */
@Entity
@Table(name="registro_adopcion")
@NamedQuery(name="RegistroAdopcion.findAll", query="SELECT r FROM RegistroAdopcion r")
public class RegistroAdopcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_registro_adopcion")
	private Integer idRegistroAdopcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_adopcion")
	private Date fechaAdopcion;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="id_reserva")
	private Reserva reserva;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="registroAdopcion")
	private List<Seguimiento> seguimientos;

	public RegistroAdopcion() {
	}

	public Integer getIdRegistroAdopcion() {
		return this.idRegistroAdopcion;
	}

	public void setIdRegistroAdopcion(Integer idRegistroAdopcion) {
		this.idRegistroAdopcion = idRegistroAdopcion;
	}

	public Date getFechaAdopcion() {
		return this.fechaAdopcion;
	}

	public void setFechaAdopcion(Date fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Seguimiento> getSeguimientos() {
		return this.seguimientos;
	}

	public void setSeguimientos(List<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public Seguimiento addSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().add(seguimiento);
		seguimiento.setRegistroAdopcion(this);

		return seguimiento;
	}

	public Seguimiento removeSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().remove(seguimiento);
		seguimiento.setRegistroAdopcion(null);

		return seguimiento;
	}

}