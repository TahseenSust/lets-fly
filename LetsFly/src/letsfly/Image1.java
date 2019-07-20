/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfly;

import javax.swing.ImageIcon;

/**
 *
 * @author Tahseen
 */
class Image1  {
    
    final String s;
    Image2 img2;
    
    Image1(String s){
        this.s=s;
    }
    
    ImageIcon loadImg() {
        
        
        if(img2==null){
            this.img2=new Image2(s);
        }
        
        
        return this.img2.loadImg();
    }
    
    
}
