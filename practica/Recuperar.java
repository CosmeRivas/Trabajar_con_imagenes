/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author RIVAS
 */
public class Recuperar extends JPanel{
    BufferedImage ima;
    public Recuperar(int x, int y, BufferedImage buf){
        this.ima = buf;
        this.setSize(x, y);
    }
    public void paint(Graphics e){
        Dimension dimension = getSize();
        e.drawImage(ima, 0, 0, dimension.height, dimension.width, null);
        setOpaque(false);
        super.paintComponent(e);
    }
}
