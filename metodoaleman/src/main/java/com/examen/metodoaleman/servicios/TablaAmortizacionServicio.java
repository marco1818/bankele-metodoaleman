package com.examen.metodoaleman.servicios;

import com.examen.metodoaleman.beans.EntradaBean;
import com.examen.metodoaleman.beans.SalidaBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TablaAmortizacionServicio {


  public List<SalidaBean> metodoAleman(EntradaBean entradaBean){
    List<SalidaBean> tablaAmortizacion = new ArrayList<>();

    int amortizacion = 1;
    double capAmortizado = capitalAmortizado(entradaBean);
    while(amortizacion<= entradaBean.getNumeroCuotas()){

      SalidaBean salidaBean = new SalidaBean();
      salidaBean.setCuota(amortizacion);
      salidaBean.setCapitalAmortizado(capAmortizado);
      salidaBean.setCapitalVivo(entradaBean.getMontoSolicitado()>capAmortizado?entradaBean.getMontoSolicitado()-capAmortizado:0.0);
      salidaBean.setInteres(interesGenerado(entradaBean));
      salidaBean.setCuotaPagar(salidaBean.getCapitalAmortizado()+salidaBean.getInteres());
      tablaAmortizacion.add(salidaBean);

      entradaBean.setMontoSolicitado(entradaBean.getMontoSolicitado()- capAmortizado);
      amortizacion++;
    }

    return tablaAmortizacion;
  }

  private double interesGenerado(EntradaBean entradaBean){
    System.out.println(interesEquivalente(entradaBean));
    return interesEquivalente(entradaBean)*entradaBean.getMontoSolicitado();
  }

  private double  capitalAmortizado(EntradaBean entradaBean){
    double capitalAmortizado = entradaBean.getMontoSolicitado()/entradaBean.getNumeroCuotas();
    return capitalAmortizado;
  }

  private double interesEquivalente(EntradaBean entradaBean){
    System.out.println("Tasas Efectivas:"+tasasEfectivas(entradaBean));
    return  (Math.pow(1.0+interesEfectivo(entradaBean),tasasEfectivas(entradaBean))-1.0)/100.0;
  }

  private double interesEfectivo(EntradaBean entradaBean){
    double x = (double)(1.0+entradaBean.getTasaNominal()/entradaBean.getNumeroCuotas());
    double y = Math.pow(x,entradaBean.getNumeroCuotas())-1.0;
    return y;
  }

  private double tasasEfectivas(EntradaBean entradaBean){
    double tasaEfectiva;

    if("Mensual".equalsIgnoreCase(entradaBean.getPeriodicidad())){
      return (30.0/360.0);
    }

    if("Bimensual".equalsIgnoreCase(entradaBean.getPeriodicidad())){
      return (60.0/360.0);
    }
    if("Trimestral".equalsIgnoreCase(entradaBean.getPeriodicidad())){
      return (90.0/360.0);
    }
    if("Cuatrimestral".equalsIgnoreCase(entradaBean.getPeriodicidad())){
      return (120.0/360.0);
    }
    if("Semestral".equalsIgnoreCase(entradaBean.getPeriodicidad())){
      return (180.0/360.0);
    }
    if("Anual".equalsIgnoreCase(entradaBean.getPeriodicidad())){
      return (360.0/360.0);
    }

    return 0.0;
  }


}
