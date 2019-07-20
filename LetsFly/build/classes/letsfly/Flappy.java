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
class Flappy extends Objects {
    
    
    Image1 image1;
    Tube1[] tube;
    
    
    public Flappy(int x, int y) {
        super(x,y);
        if(image1==null){
            image1=new Image1("/assets/bird.gif");
        }
        this.image=image1.loadImg().getImage();
        this.W=image.getWidth(null);
        this.H=image.getHeight(null);
        this.X-=W;
        this.Y-=H;
        tube=new Tube1[1];
        tube[0]=new Tube1(900,LetsFly.HEIGHT-60);
        this.dY=4;
        
    }

    public void obj_control() {
        if(dY<5){
            dY+=2;
        }
        this.Y+=dY;
        tube[0].obj_control();
        
        if(this.X>LetsFly.WIDTH){
            this.X=LetsFly.WIDTH;
        }
        if(this.X<0){
            this.X=0;
        }
        if(this.Y>LetsFly.HEIGHT-50){
            this.Y=LetsFly.HEIGHT-50;
        }
        if(this.Y<0){
            this.Y=0;
        }
    }
    
    void up()
    {
        if(dY>0){
            dY=0;
        }
        dY-=14;
    }
    

    void Renders(Graphics2D G, ImageObserver observe) {
        G.drawImage(image, X, Y,observe);
        tube[0].render(G,observe);
    }


    
    public Rectangle getBounds()
    {
        return new Rectangle(X,Y,W,H);
    }
    
}
