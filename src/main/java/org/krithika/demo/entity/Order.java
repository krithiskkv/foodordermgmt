package org.krithika.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by administrator on 5/12/20.
 */
@Entity
@Table(name="T_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private User orderingUser;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ORDER_ITEMS_LIST", joinColumns = @JoinColumn(name = "ORDER_ID"))
    @Column(name="ORDER_ITEM")
    private Set<ItemOrderQty> orderedItems;

    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOrderingUser() {
        return orderingUser;
    }

    public void setOrderingUser(User orderingUser) {
        this.orderingUser = orderingUser;
    }

    public Set<ItemOrderQty> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Set<ItemOrderQty> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
