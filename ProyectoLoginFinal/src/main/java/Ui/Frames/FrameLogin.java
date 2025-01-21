package Ui.Frames;

import Ui.Panels.PanelLogin;

import javax.swing.*;

public class FrameLogin extends JFrame {
    private static int width = 600;
    private static int height = 600;





    public FrameLogin() {

        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Proyecto UI");
        ImageIcon image = new ImageIcon("src/main/resources/pokemonMedia/images/dratini.png");
        this.setIconImage(image.getImage());

        //Aquí añadimos el panel
        PanelLogin p = new PanelLogin(this);
        this.add(p);
        this.setVisible(true);
    }


}