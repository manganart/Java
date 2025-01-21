package Ui.Panels;


import Model.classes.User;
import Services.UserService;
import Ui.Frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Pablo Macías
 */
public class PanelLogin extends JPanel {
    //este es el frame padre de este panel
    FrameLogin framePadre;
    JTextField user;
    JTextField pass;
    JButton bEnviar;


    UserService serviceUser = new UserService();


    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            User u = new User(user.getText(), "", pass.getText(), false);
            if (serviceUser.checkUserExists(u)) {
                cargarPanelMenu();

            } else {
                System.out.println("Pa tu casa");
            }
        }


        /**
         * @Override
         *         public void mouseEntered(MouseEvent e) {
         *             JButton b = (JButton) e.getSource();
         *             b.setBackground(new Color(135, 206, 250)); // Fondo azul claro
         *             b.setBorder(new LineBorder(new Color(0, 115, 183), 3)); // Borde azul oscuro
         *         }
         *
         *         @Override
         *         public void mouseExited(MouseEvent e) {
         *             JButton b = (JButton) e.getSource();
         *             b.setBackground(new Color(102, 153, 204)); // Fondo azul medio
         *             b.setBorder(new LineBorder(new Color(135, 206, 250), 3)); // Borde azul claro
         *         }
         */
    };


    public PanelLogin(FrameLogin framePadre) {

        this.framePadre = framePadre;

        this.setBackground(new Color(134, 171, 194));
        this.setLayout(null);

        JLabel usuario = new JLabel("Usuario: ");
        usuario.setLocation(new Point(150, 168));
        usuario.setSize(new Dimension(150, 32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(usuario);

        user = new JTextField();
        user.setLocation(new Point(250, 168));
        user.setSize(new Dimension(150, 32));
        this.add(user);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(150, 218));
        passwd.setSize(new Dimension(152, 32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(250, 218));
        pass.setSize(new Dimension(150, 32));
        this.add(pass);

        bEnviar = new JButton("Enviar");
        bEnviar.setLocation(new Point(130, 268));
        bEnviar.setSize(new Dimension(130, 32));
        bEnviar.addMouseListener(listenerMouse);
        this.add(bEnviar);




    }


    private void cargarPanelMenu() {
        //this es PanelLogin, pero este exacto PanelLogin. No otro...
        framePadre.remove(this);

        //añadimos un panelAlta al frame para que ahora aparezca este
        PanelMenu panelOpciones = new PanelMenu(framePadre);
        framePadre.add(panelOpciones);

        //Tenemos que actualizar lo que tiene el frame manualmente
        framePadre.repaint();
        framePadre.revalidate();

    }
}