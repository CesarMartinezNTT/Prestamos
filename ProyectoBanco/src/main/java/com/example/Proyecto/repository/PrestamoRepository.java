package com.example.Proyecto.repository;

import com.example.Proyecto.entity.Cuenta;
import com.example.Proyecto.entity.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrestamoRepository {

    @Autowired
    private PrestamoRepositoryDAO prestamoDAO;

    public Optional<Prestamo> getP(Integer cuentas_id) {
        return prestamoDAO.getPrestamos(cuentas_id);
    }

    public boolean crearP(Prestamo prestamo) {
        try {
            prestamoDAO.save(prestamo);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public float sacarSaldo(List<Cuenta> cuenta) {
        for (int c = 0; c < cuenta.size(); c++) {
            if (cuenta.get(c).getSaldo() > 20.000) {
                return cuenta.get(c).getSaldo();
            }
            return cuenta.get(c).getSaldo();
        }
        return 0.0F;
    }

    public Optional<Prestamo> getC(Integer cuotas_id) {
        return prestamoDAO.getCuotas(cuotas_id);
}}











   // public boolean verprestamo(Integer numeroPrestamo) {
     //   if (prestamoDAO.getPrestamos(numeroPrestamo).size() != 0){
       //     return false;
        //}

        //return true;
    //}




   // public Prestamo create(Prestamo prestamo){
   //     prestamoDAO.save(prestamo);
   //     return prestamo;
   // }


