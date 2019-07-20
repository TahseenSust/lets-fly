/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfly;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Tahseen
 */
public class MainGame extends JPanel implements ActionListener{
    
    boolean runing = false;
    Image1 image1;
    Image background_img;
    
    
    Flappy bird;
    
    Tube2 tube2;
    
    
    int point;
    
    
    int highest_Score;
    
    public MainGame(){
        
        image1= new Image1("/assets/background.png");
        background_img =image1.loadImg().getImage();
        setFocusable(true);
        setDoubleBuffered(false);
        addKeyListener(new MainKeyAdapter());
        Timer timer = new Timer(15,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        if(runing){
            bird.obj_control();
            tube2.obj_control();
            checkColision();
            point++;
        }
        repaint();
    }
    
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background_img, 0, 0, null);
        if(runing){
            this.bird.Renders(g2,this);
            this.tube2.Render(g2,this);
            g2.setColor(Color.black);
            g.setFont(new Font("Arial",1,20));
            g2.drawString("Score: "+this.tube2.getPoints(), 10, 20);
        }else{
            g2.setColor(Color.black);
            g.setFont(new Font("Arial",1,30));
            g2.drawString("Press Space to Fly", LetsFly.WIDTH/2-150, LetsFly.HEIGHT/2-50);
            g2.setColor(Color.BLACK);
            g.setFont(new Font("Arial",1,15));
        }
        g2.setColor(Color.BLACK);
        g.setFont(new Font("Arial",1,20));
        g2.drawString("High Score: "+highest_Score,LetsFly.WIDTH-160, 20);
        
        g.dispose();
    }
    
    private void restart()
    {
        if(!runing){
            this.runing=true;
            this.bird=new Flappy(LetsFly.WIDTH/2,LetsFly.HEIGHT/2);
            this.tube2=new Tube2();
        }
    }
    
    private void end()
    {
        this.runing=false;
        if(this.tube2.getPoints()>highest_Score){
            this.highest_Score=this.tube2.getPoints();
        }
        this.tube2.setPoint(0);
    }

    private void checkColision() {
        Rectangle rect_bird = this.bird.getBounds();
        Rectangle rect_tube;
        
        for(int i=0;i<this.tube2.getTubes().size();i++){
            Tube1 tempTube = this.tube2.getTubes().get(i);
            rect_tube = tempTube.getBounds();
            if(rect_bird.intersects(rect_tube)){
                end();
            }
            
        }
    }

    class MainKeyAdapter extends KeyAdapter {
        
        private final Controls controller;
        
        public MainKeyAdapter() {
            controller = new Controls();
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                restart();
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e)
        {
            if(runing){
                controller.control(bird,e);
            }
        }
    }
    
}
