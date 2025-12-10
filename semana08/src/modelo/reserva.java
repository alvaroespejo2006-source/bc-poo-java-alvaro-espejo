package com.agencia.modelo;

import java.time.LocalDate;

public class Reserva {
    private String codigo;
    private Cliente cliente;
    private LocalDate fecha;
    private double precio;

    public Reserva(String codigo, Cliente cliente, LocalDate fecha, double precio) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    
    @Override
    public String toString() {
        return "Reserva [código=" + codigo + ", precio=" + String.format("%,.0f", precio) + "]";
    }
}