/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfly;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Toolkit;
/**
 *
 * @author Tahseen
 */
public class LetsFly {

    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    
    
    public LetsFly(int width,int height,String title,MainGame game)
    {
        // main frame
        
        
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setTitle(title);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.setMaximumSize(new Dimension(width, height));
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        MainGame game = new MainGame();
        
        
        java.awt.EventQueue.invokeLater(() -> {
            LetsFly window = new LetsFly(WIDTH,HEIGHT,"Lets Fly",game);
        });
    }
    
}
