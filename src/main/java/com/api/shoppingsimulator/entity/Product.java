package com.api.shoppingsimulator.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "product_name")
    private String productName;

    @ManyToMany(mappedBy = "products")
    private List<Client> client;


    @JoinTable(
            name = "product_card",
            joinColumns = @JoinColumn(name = "id_product", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_card", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Card> cards;


}
