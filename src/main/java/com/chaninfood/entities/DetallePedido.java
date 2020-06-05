package com.chaninfood.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
@Getter
@Setter
public class DetallePedido {

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_platillo", nullable = false)
    private Platillo platillo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Long id;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "sub_total")
    private BigDecimal subTotal;
}
