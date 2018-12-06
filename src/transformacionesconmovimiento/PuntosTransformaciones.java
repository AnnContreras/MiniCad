package transformacionesconmovimiento;

import java.awt.Color;
import modelos.*;

public class PuntosTransformaciones extends Transformaciones {
  private Puntos puntos;  
  private Punto centroSimetria;
  private Punto puntoA;
  private Punto puntoB;

  @Override
  public void crearShapeOriginal() {
    super.crearShapeOriginal();
    //Se necesita para el oyente MoverPuntos
    puntos = new Puntos();
    for (Punto punto : original.getPuntos()) {
      puntos.add(punto);
    }
  }

  public void aplicarSimetriaCentral() {
    if (centroSimetria == null) {
      centroSimetria = new Punto(300, 300, 10, Color.ORANGE);
      puntos.add(centroSimetria);
    }
    super.aplicarSimetriaCentral(centroSimetria.x, centroSimetria.y);
  }

  public void aplicarSimetriaAxial() {
    if (puntoA == null) {
      puntoA = new Punto(50, 500, 10, Color.MAGENTA);
      puntoB = new Punto(650, 50, 10, Color.MAGENTA);
      puntos.add(puntoA);
      puntos.add(puntoB);
    }
    super.aplicarSimetriaAxial(puntoA.x, puntoA.y, puntoB.x, puntoB.y);
  }

  public void limpiarValores() {
    puntos.remove(puntoA);
    puntos.remove(puntoB);
    puntos.remove(centroSimetria);
    ejeSimetria = null;
    centroSimetria = null;
    puntoA = null;
    puntoB = null;
    puntos.clear();
    
  }

  public Puntos getPuntos() {
    return puntos;
  }

  public void setPuntos(Puntos puntos) {
    this.puntos = puntos;
  }

    void crearShape( int[] pX, int[] pY ) {
    puntos.clear();
    Puntos puntos = new Puntos();
    for (int i = 0; i < pX.length; i++) {
      puntos.add(new Punto(pX[i], pY[i], 5, Color.RED));
    }
    
    original = new Poligono(puntos, Color.BLUE);
    }
}
