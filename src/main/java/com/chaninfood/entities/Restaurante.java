package com.chaninfood.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurante")
@Getter
@Setter
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    private Set<CategoriaPlatillo> categorias;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    private Set<Pedido> pedidos;
}