package es.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="detalles_cliente")
public class DetallesCliente {
	

	

	//construcctor por defecto
	
	public DetallesCliente() {
	}
	
	//constructor con parametros

	public DetallesCliente(String web, String tlfn, String comentarios) {
		this.web = web;
		this.tlfn = tlfn;
		this.comentarios = comentarios;
	}
	//get y set
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Cliente getElCliente() {
		return elCliente;
	}

	public void setElCliente(Cliente elCliente) {
		this.elCliente = elCliente;
	}



	@Override
	public String toString() {
		return "DetallesCliente [id=" + id + ", web=" + web + ", tlfn=" + tlfn + ", comentarios=" + comentarios + "]";
	}


//	@OneToOne(mappedBy="detalles",cascade=CascadeType.ALL)
	@OneToOne(mappedBy="detalles")
	private Cliente elCliente; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="web")
	private String web;
	@Column(name="tlfn")
	private String tlfn;
	@Column(name="comentarios")
	private String comentarios;

}
