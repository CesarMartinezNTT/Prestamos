package com.example.Proyecto.controller;

import com.example.Proyecto.configuration.*;
import com.example.Proyecto.entity.Cuenta;
import com.example.Proyecto.entity.Prestamo;
import com.example.Proyecto.repository.PrestamoRepository;
import com.example.Proyecto.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PrestamoController {
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private PrestamoService prestamoService;

    private Optional<Prestamo> cuentas_id;
    private List<Cuenta> cuenta;
    private  Integer coutas_id;
    private float saldo;





        @PostMapping("/altaprestamo")
        public ResponseEntity<Prestamo> realizarPrestamo(@RequestBody Prestamo prestamo) throws SaldoException, NoCuenta,
                NoPrestamo, PrestamoFail {
            clientes_id = prestamoService.getP();
             = prestamoService.getCuentas();
            if(clientes_id == null){
                throw new noCuenta();
            }
            saldo = prestamoService.obtenerSaldo(cuenta);
            if(saldo < 20.000){
                throw new saldoInsuficiente();
            }
            cuentas_id = prestamoService.getP(cuenta, saldo);
            if(cuentas_id == null){
                throw  new SaldoException();
            }
            prestamo.setId(clientes_id);
            prestamo.setId(coutas_id);
            boolean prestamoRealizado = prestamoService.crearPrestamo(prestamo);
            if(!prestamoRealizado){
                throw new PrestamoFail();
            }


    }
    @GetMapping("/listarprestamos")
    public ResponseEntity<Prestamo> getP() throws NoPrestamo{
        cliente_id = PrestamoService.getid();
        Optional<Prestamo> optionalPrestamo = PrestamoService.getP(cliente_id);
        if(optionalPrestamo.isEmpty()){
            throw new NoPrestamo();
        }
        return ResponseEntity.ok(optionalPrestamo.get());
    }
}


 //   @GetMapping("/verprestamo")
 //   public ResponseEntity<Integer> verprestamos(@RequestBody Integer numeroPrestamo){
 //       prestamoRepository.verprestamo(numeroPrestamo);
 //       return ResponseEntity.ok(numeroPrestamo);
 //  }

//@PostMapping("/altaprestamo")
//public ResponseEntity<Prestamo> altaprestamo(@RequestBody Prestamo prestamo) throws PrestamoException {
//        prestamoRepository.crearP(prestamo);
//        System.out.println("Finalizada");
//        return ResponseEntity.ok(prestamo);
}


