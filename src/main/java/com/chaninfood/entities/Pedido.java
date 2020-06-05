package com.chaninfood.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedido {

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_restaurante", nullable = false)
    private Restaurante restaurante;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @Column(name = "fecha")
    @CreationTimestamp
    private Date fecha;

    @Column(name = "entregado")
    private boolean entregado;

    @Column(name = "monto_total")
    private float monto_total;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Set<DetallePedido> detallePedidos;
}
