package com.example.Proyecto.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cuentas")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cuenta {

    @Id
    @Column(name="ID")
    private String cbu;


    private Float saldo;
    private String moneda;
    private String tipoDeCuenta;

    public Cuenta(String cbu, Float saldo, String moneda, String tipoDeCuenta, List<Movimiento> movimientos, TarjetaDebito tarjetaDebito) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.moneda = moneda;
        this.tipoDeCuenta = tipoDeCuenta;
        this.movimientos = movimientos;
        this.tarjetaDebito = tarjetaDebito;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "Cuenta_Movimiento")
    private List<Movimiento> movimientos;

    @OneToOne
    private TarjetaDebito tarjetaDebito;


}
