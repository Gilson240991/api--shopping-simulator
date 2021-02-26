package com.api.shoppingsimulator.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "Card")
public class Card implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "card_name")
    private String cardName;
    @Column(name = "card_description")
    private String cardDescription;

    @ManyToMany(mappedBy = "cards")
    private List<Product> products;
}
