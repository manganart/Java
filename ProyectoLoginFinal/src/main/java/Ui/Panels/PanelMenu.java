package Ui.Panels;

import Ui.Frames.FrameLogin;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {

    JLabel mensaje;


        public PanelMenu(FrameLogin framepadre){
            this.setBackground(new Color(134, 171, 194));
            this.setLayout(null);


            mensaje = new JLabel("Profe no lo hicimos...  ");
            mensaje.setLocation(150, 218);
            mensaje.setSize(150,32);

            this.add(mensaje);
            this.setVisible(true);
        }

}
