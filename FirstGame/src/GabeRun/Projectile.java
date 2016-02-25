/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GabeRun;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Gabe
 */
public class Projectile {
    
    /*
    
    This is still in progress:
    Enemy shoots projectile at player after set time!
    
    */
    double posX, posY;
    double velX, velY;
    double sizeX, sizeY;
    int direction = 0;
    boolean dead = false;
    double speed = 1.8;
    boolean render = true;
    
    
    public double getPosX(){
        return posX;
    }
    public double getPosY(){
        return posY;
    }
    
    public void setX(double x){
          this.posX = x;
    }
    public void setY(double y){
         this.posY = y;
    }
    
    public boolean getDead(){
        return dead;
    }
    public void setDead(boolean dead){
        this.dead = dead;
    }
    
    public void render(GraphicsContext gs){
        gs.setFill(Color.RED);
        gs.fillOval(posX, posY, sizeX, sizeY);
    }
    public void move(double pxX,double pxY){
        if(posX+pxX < 600 && posY-pxY  < 600 && posX+pxX > 0 && posY-pxY > 0){
        this.posX += pxX;
        this.posY -= pxY;
       }else{
            dead = true;
        }
    }
    public void AI(){
        switch(direction){
            case 4:
                move(-speed, -speed);
            break;
            
            case 3:
                move(-speed, speed);
            break;
            
            case 2:
                move(speed, speed);
            break;
            
            case 1:
                move(speed, -speed);
            break;
                
        }
    }
   
    
    
 public Projectile(double posX,  double posY, double sizeX, double sizeY, Player plr){
    this.posX = posX;
    this.posY = posY;
    this.speed = speed;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    
     if(posX < plr.getPosX()){
          if(posY < plr.getPosY()){
           direction = 1;
          }else{
         direction = 2;
          }
        }else{
            if(posY>plr.getPosY()){
            direction = 3;
            }else{
               direction = 4;
            }
        }
    }
}
