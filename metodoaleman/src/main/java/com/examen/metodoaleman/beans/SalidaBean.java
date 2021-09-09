package com.examen.metodoaleman.beans;

public class SalidaBean {
  private int cuota;
  private double cuotaPagar;
  private double interes;
  private double capitalAmortizado;
  private double capitalVivo;

  public SalidaBean(){
    super();
  }

  public int getCuota() {
    return cuota;
  }

  public void setCuota(int cuota) {
    this.cuota = cuota;
  }

  public double getCuotaPagar() {
    return cuotaPagar;
  }

  public void setCuotaPagar(double cuotaPagar) {
    this.cuotaPagar = cuotaPagar;
  }

  public double getInteres() {
    return interes;
  }

  public void setInteres(double interes) {
    this.interes = interes;
  }

  public double getCapitalAmortizado() {
    return capitalAmortizado;
  }

  public void setCapitalAmortizado(double capitalAmortizado) {
    this.capitalAmortizado = capitalAmortizado;
  }

  public double getCapitalVivo() {
    return capitalVivo;
  }

  public void setCapitalVivo(double capitalVivo) {
    this.capitalVivo = capitalVivo;
  }
}
