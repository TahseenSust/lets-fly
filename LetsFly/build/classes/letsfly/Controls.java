/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfly;

import java.awt.event.KeyEvent;

/**
 *
 * @author Tahseen
 */
class Controls{
       
    public void control(Flappy bird, KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_SPACE){
           bird.up();
       }
    }

    
    
}
