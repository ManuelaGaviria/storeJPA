package com.example.storeJPA.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@SequenceGenerator(name="pedido_sequence",
			sequenceName="pedido_sequence",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator="pedido_sequence")
	@Column(name="id",
			updatable=false)
	private Integer id;
	
	@Column(name="fechaPedido",
			nullable=false)
	@NonNull
	private LocalDate fechaPedido;
	
	@Column(name="fechaEntrega",
			nullable=false)
	@NonNull
	private LocalDate fechaEntrega;
	
	@Column(name="cantidad",
			nullable=false)
	@NonNull
	private Integer cantidad;
	
	@Column(name="precioTotal",
			nullable=false)
	@NonNull
	private BigDecimal precioTotal;
	
	@Column(name="estado",
			nullable=false)
	@NonNull
	private Estado estado;
	
	//ManyToMany:
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="pedidos_fabricantes",
			joinColumns= {
					@JoinColumn(name="fk_pedido")
			},
			inverseJoinColumns= {
					@JoinColumn(name="fk_fabricante")
			}
	)
	private Set<Fabricante> fabricantes = new HashSet<>();
	
	public Pedido addFabricante(Fabricante fabricante) {
		this.fabricantes.add(fabricante);
		return this;
	}
	
	public Set<Integer> getFabricantesIds(){
		return this.fabricantes.stream()
				.map(Fabricante::getId)
				.collect(Collectors.toSet());
	}
	
	public Set<String> getFabricanteNames(){
		return this.fabricantes.stream()
				.map(Fabricante::getNombre)
				.collect(Collectors.toSet());
	}
	
	
	//ManyToMany:
		@ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(
				name="pedidos_productos",
				joinColumns= {
						@JoinColumn(name="fk_pedido")
				},
				inverseJoinColumns= {
						@JoinColumn(name="fk_producto")
				}
		)
		private Set<Producto> productos = new HashSet<>();
		
		public Pedido addProducto(Producto producto) {
			this.productos.add(producto);
			return this;
		}
		
		public Set<Integer> getProductosIds(){
			return this.productos.stream()
					.map(Producto::getId)
					.collect(Collectors.toSet());
		}
		
		public Set<String> getProductoNames(){
			return this.productos.stream()
					.map(Producto::getNombreProducto)
					.collect(Collectors.toSet());
		}

		public Pedido() {
			super();
		}

		public Pedido(@NonNull LocalDate fechaPedido, @NonNull LocalDate fechaEntrega, @NonNull Integer cantidad,
				@NonNull BigDecimal precioTotal, @NonNull Estado estado) {
			super();
			this.fechaPedido = fechaPedido;
			this.fechaEntrega = fechaEntrega;
			this.cantidad = cantidad;
			this.precioTotal = precioTotal;
			this.estado = estado;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public LocalDate getFechaPedido() {
			return fechaPedido;
		}

		public void setFechaPedido(LocalDate fechaPedido) {
			this.fechaPedido = fechaPedido;
		}

		public LocalDate getFechaEntrega() {
			return fechaEntrega;
		}

		public void setFechaEntrega(LocalDate fechaEntrega) {
			this.fechaEntrega = fechaEntrega;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		public BigDecimal getPrecioTotal() {
			return precioTotal;
		}

		public void setPrecioTotal(BigDecimal precioTotal) {
			this.precioTotal = precioTotal;
		}

		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
		}

		public Set<Fabricante> getFabricantes() {
			return fabricantes;
		}

		public void setFabricantes(Set<Fabricante> fabricantes) {
			this.fabricantes = fabricantes;
		}

		public Set<Producto> getProductos() {
			return productos;
		}

		public void setProductos(Set<Producto> productos) {
			this.productos = productos;
		}
		
		

}
