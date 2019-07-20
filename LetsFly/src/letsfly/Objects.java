/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfly;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 *
 * @author Tahseen
 */
public class Objects {
    int X,Y;
    int dX,dY;
    int W,H;
    
    
    Image image;
    
    Objects(int x,int y)
    {
        this.X=x;
        this.Y=y;
    }
    
    int getX(){
        return X;
    }
    
    int getY(){
        return Y;
    }
    
    int getDx(){
        return dX;
    }
    
    int getDy(){
        return dY;
    }
    
    int getW()
    {
        return W;
    }
    
    int getH()
    {
        return H;
    }
    
    Image getImg()
    {
        return image;
    }
    
    void setX(int x)
    {
        this.X=x;
    }
    
    void setY(int y)
    {
        this.Y=y;
    }
    
    void setDx(int x)
    {
        this.dX=x;
    }
    
    void setDy(int y)
    {
        this.dY=y;
    }
    
    void setW(int w)
    {
        this.W=w;
    }
    
    void setH(int h)
    {
        this.H=h;
    }
    
    void setImg(Image img)
    {
        this.image=img;
    }
    
    
}
