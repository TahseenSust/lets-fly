/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfly;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Tahseen
 */
final class Tube2 {
    
    int Base = LetsFly.HEIGHT-60;
    
    List<Tube1>tub;
    Random rand;
    int points=0;
    int speed = 6;
    
    
    int speed_rate=speed;
    
    Tube2()
    {
        tub=new ArrayList<>();
        rand=new Random();
        initializeTube();
    }
    
    void obj_control() {
        for(int i=0;i<tub.size();i++){
            tub.get(i).obj_control();
            
            if(tub.get(i).getX()<0){
                tub.remove(tub.get(i));
            }
        }
        
        if(tub.isEmpty()){
            this.points+=1;
            if(speed_rate==points){
                this.speed+=1;
                speed_rate+=5;
                
            }
            initializeTube();
        }
    }

    void Render(Graphics2D G, ImageObserver observe) {
        tub.stream().forEach((tub1) -> {
            tub1.render(G, observe);
        });
    }
    
    public List<Tube1> getTubes(){
        return tub;
    }
    
    void setTubes(List<Tube1> tubes)
    {
        this.tub=tubes;
    }

    int getPoints() {
        return points;
    }

    void setPoint(int i) {
        this.points=i;
    }


    void initializeTube() {
        int last = Base;
        
        
        
        int num=rand.nextInt(10);
        
        for(int i=0;i<25;i++){
            Tube1 tempTube=new Tube1(800,last);
            tempTube.setDx(speed);
            
            if(i<num || i>num+4){
                tub.add(tempTube);
            }
            
            last=tempTube.getY()-tempTube.getH();
            
            
        }
    }
    
}
