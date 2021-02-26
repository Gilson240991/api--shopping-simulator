package com.api.shoppingsimulator.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Client")
@Getter
@Setter
public class Client implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "names")
    private String names;
    @Column(name = "father_last_name")
    private String fatherLastName;
    @Column(name = "mother_last_name")
    private String motherLastName;
    @Column(name = "document_number")
    private String documentNumber;


    @JoinTable(
            name = "client_product",
            joinColumns = @JoinColumn(name = "id_client", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_product", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

}
