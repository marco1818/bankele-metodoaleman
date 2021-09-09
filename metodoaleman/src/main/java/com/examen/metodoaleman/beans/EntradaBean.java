package com.examen.metodoaleman.beans;

public class EntradaBean {
  private double montoSolicitado;
  private String periodicidad;
  private double numeroCuotas;
  private double tasaNominal;

  public EntradaBean(){
    super();
  }

  public double getMontoSolicitado() {
    return montoSolicitado;
  }

  public void setMontoSolicitado(double montoSolicitado) {
    this.montoSolicitado = montoSolicitado;
  }

  public String getPeriodicidad() {
    return periodicidad;
  }

  public void setPeriodicidad(String periodicidad) {
    this.periodicidad = periodicidad;
  }

  public double getNumeroCuotas() {
    return numeroCuotas;
  }

  public void setNumeroCuotas(double numeroCuotas) {
    this.numeroCuotas = numeroCuotas;
  }

  public double getTasaNominal() {
    return tasaNominal;
  }

  public void setTasaNominal(double tasaNominal) {
    this.tasaNominal = tasaNominal;
  }
}
