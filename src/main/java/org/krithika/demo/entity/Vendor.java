package org.krithika.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by administrator on 5/12/20.
 */
@Entity
@Table(name="T_VENDOR")
public class Vendor {
    @Id
    @Column(name="VENDOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="VENDOR_NAME")
    private String name;

    @JsonBackReference
    @Column(name="SUPPLIED_ITEMS")
    @OneToMany(mappedBy = "vendor")
    private Set<Item> suppliedItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getSuppliedItems() {
        return suppliedItems;
    }

    public void setSuppliedItems(Set<Item> suppliedItems) {
        this.suppliedItems = suppliedItems;
    }

}
