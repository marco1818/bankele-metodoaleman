package com.examen.metodoaleman.controladores;

import com.examen.metodoaleman.beans.EntradaBean;
import com.examen.metodoaleman.beans.SalidaBean;
import com.examen.metodoaleman.servicios.TablaAmortizacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodoAleman")
public class TablaAmortizacionesControlador {

  @Autowired
  private TablaAmortizacionServicio tablaAmortizacionServicio;

  @PostMapping(value="/tablaAmortizacion")
  public ResponseEntity<List<SalidaBean>> metodoAleman(@RequestBody EntradaBean entradaBean){
    return new ResponseEntity<>(tablaAmortizacionServicio.metodoAleman(entradaBean), HttpStatus.OK);
  }
}
