/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfly;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author Tahseen
 */
class Tube1 extends Objects {
    
    Image1 img;

    Tube1(int a, int b) {
        super(a,b);
        
        if(img==null){
            img=new Image1("/assets/TubeBody.png");
        }
        this.image=img.loadImg().getImage();
        
        this.W=image.getWidth(null);
        
        
        this.H=image.getHeight(null);
        
    }

    void obj_control() {
        this.X-=dX;
    }

    void render(Graphics2D G, ImageObserver observe) {
        G.drawImage(image, X,Y, observe);
    }
    
    Rectangle getBounds()
    {
        return new Rectangle(X,Y,W,H);
    }
    
}
