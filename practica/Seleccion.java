/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author RIVAS
 */
public class Seleccion extends JPanel{
    private String camino;
    public Seleccion(int x, int y, String ruta){
        this.setSize(x, y);
        this.camino = ruta;
        //this.ruta = path;
    }
    public void paint(Graphics e){       
        Dimension dimension = getSize();
        Image ima = new ImageIcon(camino).getImage();
        e.drawImage(ima, 0, 0,dimension.height, dimension.width, null);
        setOpaque(false);
        super.paintComponent(e);
    }
}
