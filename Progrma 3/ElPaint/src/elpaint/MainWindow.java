/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elpaint;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author ASUS ROG
 */
public class MainWindow extends JFrame implements MouseListener{
    Dibujo el_dibujo;
        public MainWindow(){
        super ("El peint");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
        
        }

    private void initComponents() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       el_dibujo = new Dibujo();
       add(el_dibujo,BorderLayout.CENTER);
       Figura fig= new Rectangulo ();
       el_dibujo.add(fig);
       fig.setBounds(100, 100, 50, 30);
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //nerated methods, choose Tools | Templates.
        //cuando se haga click , agregaremos una figura
        Figura fig= new Rectangulo ();
        //posicionamos el rectangulo en el punto en el cual se dio el click
        fig.setLocation(e.getPoint());
        fig.setSize(20,20);
        this.add(fig);
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
