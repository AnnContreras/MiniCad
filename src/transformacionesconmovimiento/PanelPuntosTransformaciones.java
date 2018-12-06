package transformacionesconmovimiento;

import java.awt.Graphics;
import java.util.ArrayList;
import modelos.Punto;
import modelos.Transformaciones;
import vistas.PanelTransformaciones;

public class PanelPuntosTransformaciones extends PanelTransformaciones {

  public PanelPuntosTransformaciones(Transformaciones trans) {
    super(trans);
  }

  public void addEventos(OyentePuntosTransformaciones oyente) {
    addMouseListener(oyente);
    addMouseMotionListener(oyente);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    PuntosTransformaciones t = (PuntosTransformaciones) trans;
    ArrayList<Punto> puntos = t.getPuntos();
    if (puntos != null) {
      for (Punto pto : puntos) {
        pto.dibujar(g);
      }
    }
  }
}
