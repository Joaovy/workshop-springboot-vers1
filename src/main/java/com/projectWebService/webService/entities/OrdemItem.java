package com.projectWebService.webService.entities;

import com.projectWebService.webService.entities.pk.OrderItemPk;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_order_item")
public class OrdemItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPk id;
    private Integer quantity;
    private Double price;

    public OrdemItem(){

    }

    public OrdemItem(Order order, Product product, Double price, Integer quantity) {

        id.setOrder(order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItem ordemItem = (OrdemItem) o;
        return Objects.equals(id, ordemItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
