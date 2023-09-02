package com.MyExample.Projeto2_Java_Spring.entities;

import java.io.Serializable;
import java.util.Objects;

import com.MyExample.Projeto2_Java_Spring.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer quantity;
	private Double price;
	
	//Declarando atributo identificador (corresponde à chave primária)
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	
	//Declarando construtores
	public OrderItem() {}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	
	//Declarando métodos getters e setters
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	
	public Product getProduct() {
		return id.getProduct();
	}
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	
	//Declarando métodos Equals e HashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	//Declarando método para calcular o preço subtotal do pedido
	public Double getSubTotal() {
		return price * quantity;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}
