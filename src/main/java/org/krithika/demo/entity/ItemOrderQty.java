package org.krithika.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by administrator on 5/12/20.
 */
@Embeddable
public class ItemOrderQty {

    @Column(name="ORDER_ITEM_ID")
    public Long itemId;

    @Column(name="ORDER_ITEM_QTY")
    public Integer orderQty;

    public ItemOrderQty() {}

    public ItemOrderQty(Long itemId, Integer orderQty) {
        this.setItemId(itemId);
        this.setOrderQty(orderQty);
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }
}
