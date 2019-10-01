/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elpaint;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author ASUS ROG
 */
public class Rectangulo extends Figura{
    //implementamos como se ve el rectangulo en pantalla
    
    @Override
    public void paintComponent (Graphics g){
    
        super.paintComponent(g);//invocamos de la clase padre 
        //el sistema del objeto Graphics comienza en la esquina superior izquierda
        //de este componente 
        Rectangle b= getBounds ();// getBounds devuelve posicipn y dimension 
        //dibujamos un rectangulo
        g.drawRect(0, 0, b.width-1, b.height-1);
        
        
    }
}
