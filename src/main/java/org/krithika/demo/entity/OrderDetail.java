package org.krithika.demo.entity;

import org.springframework.stereotype.Component;

/**
 * Created by administrator on 5/12/20.
 */
@Component
public class OrderDetail {

    public Long itemId;

    public Integer qty;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
