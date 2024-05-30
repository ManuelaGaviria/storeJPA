package com.example.storeJPA.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="producto")
public class Producto {
	@Id
	@SequenceGenerator(name="producto_sequence",
			sequenceName="producto_sequence",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator="producto_sequence")
	@Column(name="id",
			updatable=false)
	private Integer id;
	
	@Column(name="nombreProducto",
			nullable=false)
	@NonNull
	private String nombreProducto;
	
	@Column(name="descripcion",
			nullable=false)
	@NonNull
	private String descripcion;
	
	@Column(name="precio",
			nullable=false)
	@NonNull
	private BigDecimal precio;
	
	@Column(name="stock",
			nullable=false)
	@NonNull
	private Integer stock;
	
	@Column(name="categoria",
			nullable=false)
	@NonNull
	private Categoria categoria;
	
	//One To One:
	@OneToOne
	@JoinColumn(name="fabricanteid")
	private Fabricante fabricante;
	
	//OneToMany:
	@OneToMany(fetch=FetchType.EAGER,
			cascade=CascadeType.ALL)
	private Set<Comentario> comentarios = new HashSet<>();
	
	public void addComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}

	public Producto() {
		super();
	}

	public Producto(@NonNull String nombreProducto, @NonNull String descripcion, @NonNull BigDecimal precio,
			@NonNull Integer stock, @NonNull Categoria categoria, Fabricante fabricante) {
		super();
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.fabricante = fabricante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	

}
