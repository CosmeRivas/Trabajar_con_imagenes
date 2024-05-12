/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Elegir_guardar_busca;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author RIVAS
 */
class mostrar extends JPanel {

    private String path;

    public mostrar(int x, int y, String ruta) {
        this.setSize(x, y);
        this.path = ruta;
    }

    public void paint(Graphics gr) {
        Dimension di = getSize();
        Image ima = new ImageIcon(path).getImage();
        gr.drawImage(ima, 0, 0, di.height, di.width, null);
        setOpaque(false);
        super.paintComponents(gr);
    }
}
class busca extends JPanel{
    private BufferedImage buf;
    public busca(BufferedImage bu, int x, int y){
        this.buf = bu;
        this.setSize(x, y);
    }
    public void paint(Graphics eg){
        Dimension di = getSize();
        eg.drawImage(buf,0, 0, di.height, di.width, null);
        setOpaque(false);
        super.paintComponent(eg);
    }
}
public class Elegir_guardar_buscar extends javax.swing.JFrame {

    /**
     * Creates new form Elegir_guardar_buscar
     */
    public Elegir_guardar_buscar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccionar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        seleccionar.setText("Seleccionar");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seleccionar)
                        .addGap(103, 103, 103)
                        .addComponent(guardar)
                        .addGap(124, 124, 124)
                        .addComponent(buscar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionar)
                    .addComponent(guardar)
                    .addComponent(buscar))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // TODO add your handling code here:
        FileNameExtensionFilter filtros = new FileNameExtensionFilter("*.jpg", "JPG");
        file.setFileFilter(filtros);
        int sele = file.showOpenDialog(this);
        if (sele == JFileChooser.APPROVE_OPTION) {
            File archivos = file.getSelectedFile();
            String ruta = archivos.getAbsolutePath();
            mostrar mos = new mostrar(panel.getWidth(), panel.getHeight(), ruta);
            panel.add(mos);
            repaint();
        }
    }//GEN-LAST:event_seleccionarActionPerformed
    public static Connection conexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtros = new FileNameExtensionFilter("*.jpg", "JPG");
        file.setFileFilter(filtros);
        int se = file.showOpenDialog(this);
        if (se == JFileChooser.APPROVE_OPTION) {
            File arch = file.getSelectedFile();
            String ruta = arch.getAbsolutePath();
            try {
                FileInputStream fis = new FileInputStream(ruta);
                Connection con = conexion();
                PreparedStatement ps = con.prepareStatement("insert into imagenes1(imag) value(?)");
                ps.setBinaryStream(1, fis, (int) arch.length());
                ps.execute();
                JOptionPane.showMessageDialog(this, "Todo correcto");
                con.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Elegir_guardar_buscar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.err.print(ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            Connection con = conexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select imag from imagenes1 where id = 2");
            while (rs.next()) {
                byte ima[] = rs.getBytes("imag");
                InputStream stre = rs.getBinaryStream(1);
                try {
                    BufferedImage buf = ImageIO.read(stre);
                    busca bus = new busca(buf, panel.getHeight(), panel.getWidth());                    
                    panel.add(bus);
                    panel.repaint();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Elegir_guardar_buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel panel;
    private javax.swing.JButton seleccionar;
    // End of variables declaration//GEN-END:variables
}
