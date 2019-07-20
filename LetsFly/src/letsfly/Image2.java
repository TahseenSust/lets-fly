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
class Image2 {
    final String s;
    
    ImageIcon imgIcon;
    
    Image2(String s)
    {
        this.s=s;
    }

    ImageIcon loadImg() {
        
        
        if(imgIcon==null){
            this.imgIcon=new ImageIcon(getClass().getResource(s));
        }
        
        
        
        return imgIcon;
    }
    
}
