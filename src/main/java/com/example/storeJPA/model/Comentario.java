package com.example.storeJPA.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comentario")
public class Comentario {
	@Id
	@SequenceGenerator(name="comentario_sequence",
			sequenceName="comentario_sequence",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator="comentario_sequence")
	@Column(name="id",
			updatable=false)
	private Integer id;
	
	@Column(name="usuario",
			nullable=false)
	@NonNull
	private String usuario;
	
	@Column(name="comentario",
			nullable=false)
	@NonNull
	private String comentario;
	
	@Column(name="fechaComentario",
			nullable=false)
	@NonNull
	private LocalDate fechaComentario;
	
	@Column(name="valoracion",
			nullable=false)
	@NonNull
	private Integer valoracion;
	
	//ManyToOne:
	@ManyToOne(fetch=FetchType.LAZY,
				optional=false)
	@JoinColumn(name="productoid")
	@NonNull
	private Producto producto;

	public Comentario() {
		super();
	}

	public Comentario(@NonNull String usuario, @NonNull String comentario, @NonNull LocalDate fechaComentario,
			@NonNull Integer valoracion, @NonNull Producto producto) {
		super();
		this.usuario = usuario;
		this.comentario = comentario;
		this.fechaComentario = fechaComentario;
		this.valoracion = valoracion;
		this.producto = producto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDate getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(LocalDate fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

}
