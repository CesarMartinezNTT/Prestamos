package com.example.Proyecto.service;

import com.example.Proyecto.entity.Cuenta;
import com.example.Proyecto.entity.Prestamo;
import com.example.Proyecto.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;
    private Cuenta cuenta;

    @Autowired
    static
    RestTemplate restTemplate = new RestTemplate();

    public boolean createP(Prestamo prestamo) {
        return prestamoRepository.crearP(prestamo);
    }

    public static Integer getid() {
        Integer idCliente = restTemplate.getForObject("Aqui la URL", Integer.class);
        return idCliente;
    }

    public float getSaldo(Cuenta cuenta) {
        return prestamoRepository.sacarSaldo((List<Cuenta>) cuenta);
    }


    public List<Cuenta> getCuentas() {
        Integer idCliente = getid();
        String url = "Aqui URL" + idCliente;
        try {
            ResponseEntity<Cuenta[]> response =
                    restTemplate.getForEntity(
                            url,
                            Cuenta[].class);
            Cuenta[] cuenta = response.getBody();
            List<Cuenta> cuentaList = Arrays.asList(cuenta);
            return cuentaList;
        } catch (Exception e) {
            return null;
        }
    }

    public Optional<Prestamo> getP(Integer cuentas_id) {
        return prestamoRepository.getP(cuentas_id);


    }
}