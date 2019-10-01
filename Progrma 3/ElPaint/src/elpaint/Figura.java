/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elpaint;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author ASUS ROG
 */
public abstract class Figura  extends JComponent {
  protected  Color color = new Color(0,0,0);
    public Figura (){
    
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
//cuando es necesario deplegar en pantalla todo componente 
//el contenedro en el cual esta el component invoca el metodo paintComponent
//Este metodo se implemnta el aspecto visual del componente
 
    public void paintComponent(Graphics g){
            
    g.setColor(color);
    //no sabemos como se va a ver la figura.No podemos implementar mas dibujo
    
    }
}

