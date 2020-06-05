package com.chaninfood.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "platillo")
@Getter
@Setter
public class Platillo {

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaPlatillo categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platillo")
    private Long id;

    @Column(name = "nombre_platillo")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Set<DetallePedido> pedidos;
}