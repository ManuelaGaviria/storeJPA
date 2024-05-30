package com.example.storeJPA.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="fabricante")
public class Fabricante {
	@Id
	@SequenceGenerator(name="fabricante_sequence",
			sequenceName="fabricante_sequence",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator="fabricante_sequence")
	@Column(name="id",
			updatable=false)
	private Integer id;
	
	@Column(name="nombre",
			nullable=false,
			unique=true)
	@NonNull
	private String nombre;
	
	@Column(name="direccion",
			nullable=false)
	@NonNull
	private String direccion;
	
	@Column(name="telefono",
			nullable=false)
	@NonNull
	private String telefono;
	
	@Column(name="correo",
			nullable=false,
			unique=true)
	@NonNull
	private String correo;
	
	@Column(name="tipo",
			nullable=false)
	@NonNull
	private Tipo tipo;
	
	//One To One:
	@OneToOne
	@JoinColumn(name="productoid")
	private Producto producto;

	public Fabricante() {
		super();
	}

	public Fabricante(@NonNull String nombre, @NonNull String direccion, @NonNull String telefono,
			@NonNull String correo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

}
