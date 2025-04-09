package com.projectWebService.webService.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectWebService.webService.entities.enums.OrdersStatus;
import com.projectWebService.webService.entities.pk.OrderItemPk;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ordersStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm'Z'", timezone = "GMT")
    private Instant moment;

    // Essa é a forma como se declara uma chave estrageira de muitos para um, uma anotação para o banco de dados
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order") //No orderItem é que tem o id e por sua vez o order que tem o id
    private Set<OrderItem> items = new HashSet<>();

    public Order(){

    }

    public Order(Long id, Instant moment,OrdersStatus ordersStatus,  User client) {
        this.id = id;
        this.moment = moment;
        setOrdersStatus(ordersStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrdersStatus getOrdersStatus() {
        return OrdersStatus.valueOf(ordersStatus);
    }

    public void setOrdersStatus(OrdersStatus ordersStatus) {

        if(ordersStatus != null) {
            this.ordersStatus = ordersStatus.getCode();
        }
    }

    public Set<OrderItem> getItems(){
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
