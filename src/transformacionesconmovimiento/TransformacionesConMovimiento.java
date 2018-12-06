/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacionesconmovimiento;

import vistas.VentanaTransformaciones;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TransformacionesConMovimiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaTransformaciones f = new VentanaTransformaciones();
        PuntosTransformaciones trans = new PuntosTransformaciones();
        
        PanelPuntosTransformaciones panel = new PanelPuntosTransformaciones(trans);//mover puntos
        
        OyentePuntosTransformaciones oyente = new OyentePuntosTransformaciones(trans, panel);
        
        f.addEventos(oyente);
        panel.addEventos(oyente);
        f.setTitle("Transformaciones Bidimensionales con Movimiento");
        f.setSize(900, 600);
        f.setLocation(50, 50);
        f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        f.setVisible(true);
    }
    
}
