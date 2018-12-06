package transformacionesconmovimiento;

import controladores.OyenteMoverPuntos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class OyentePuntosTransformaciones extends OyenteMoverPuntos implements ActionListener {

  private final PuntosTransformaciones trans;
  private final JPanel panel;
  private String nombre; // Nombre del componente

  public OyentePuntosTransformaciones(PuntosTransformaciones trans, JPanel panel) {
    super(trans.getPuntos(), panel);
    this.trans = trans;
    this.panel = panel;
  }

  @Override
  // Se elimina para no permitir adicionar puntos
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    super.mouseDragged(e);
    trans.getOriginal().ajustarPuntos();
    if (nombre != null) {
      hacerTransformacion();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JMenuItem origen = (JMenuItem) e.getSource();
    nombre = origen.getName();
    trans.limpiarValores();    
    hacerTransformacion();
  }

  private void hacerTransformacion() {
    switch (nombre) {
      case "sCentral":
        trans.aplicarSimetriaCentral();
        break;
      case "sAxial":
        trans.aplicarSimetriaAxial();
        break;
      case "translacion":
        trans.aplicarTranslacion(200, 150);
        break;
      case "rotacion":
        trans.aplicarRotacion(30);
        break;
      case "escalado":
        trans.aplicarEscalado(2);
        break;
      case "cuadrado":
          cruadrado();
        break;
      case "triangulo":
          triangulo();
        break;
      case "rectangulo":
          rectangulo();
        break;
      case "extra":
          extra();
        break;
      case "salir":
        System.exit(0);
    }
    panel.repaint();
  }

    private void cruadrado() {
        int x = 200;
        int y = 70;
        int[] pX = {x, x + 100, x + 100, x};
        int[] pY = {y, y,       y + 100, y + 100};
        
        trans.crearShape( pX, pY );
    }
    
    private void triangulo() {
        int x = 200;
        int y = 70;
        int[] pX = {x + 50, x + 100, x};
        int[] pY = {y, y + 100, y + 100};
        
        trans.crearShape( pX, pY );
    }
    
    private void rectangulo() {
        int x = 200;
        int y = 70;
        int[] pX = {x, x + 175, x + 175, x};
        int[] pY = {y, y,       y + 100, y + 100};
        
        trans.crearShape( pX, pY );
    }
    
    private void extra() {
        int x = 200;
        int y = 70;
        int[] pX = {x, x + 150, x + 100, x+150, x, x+50};
        int[] pY = {y, y,       y + 50, y + 100, y+100,y+50};
        
        trans.crearShape( pX, pY );
    }
}
