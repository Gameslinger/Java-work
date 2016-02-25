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
public class Player {
    //Starting points/Velocity:
    private boolean play = true;
  
        
    private double velX, velY;
    private double sizeX, sizeY;
    private double posX, posY;

    private double speed;
    
       
    //Health/Defence:
    private double health;
    private int defence;
 
    public boolean getPlay(){
        return play;
    }
     public void setPlay(boolean play){
        this.play = play;
    }
    
     public double getSpeed(){
        return speed;
    }
     public void setSpeed(double speed){
        this.speed = speed;
    }
    
      public void setPosX(double x){
        posX = x;
    }
   public void setPosY(double y){
        posY = y;
    }
    
  public void setVelX(double x){
        velX = x;
    }
  public void setVelY(double y){
        velY = y;
    }
     public double getPosX(){
        return posX;
    }
    public double getPosY(){
        return posY;
    }
     public double getVelX(){
        return velX;
    }
      public double getVelY(){
        return velY;
    }
      
       public double getSizeX(){
        return sizeX;
    } 
      public double getSizeY(){
        return sizeY;
    } 
     public void setSizeX(double x){
        sizeX = x;
    } 
    public void setSizeY(double y){
        sizeY = y;
    } 
   
    
    public double getHealth(){
        return health;
    }
  
    public int getDefence(){
        return defence;
    }
    
    public void setHealth(double newHealth){
        health = newHealth;
    }
    
    public void setDefence(int newDefence){
        defence = newDefence;
    }
    public void setPos(double x, double y){
        posX = x;
        posY = y;
    }
    //Player Move
    public void move(double pxX,double pxY){
        if(posX+pxX < 570 && posY-pxY  < 570 && posX+pxX > 0 && posY-pxY > 0){
        this.posX += pxX;
        this.posY -= pxY;
       }
    }
    
    public void isAttacked(Enemy enmy){
        
        //TODO!
        if(Math.abs(enmy.getPosX()-posX)<=25 && Math.abs(enmy.getPosY()-posY)<=25){
            if(defence>0){
             defence--;   
            }else{
            health--;
            }

            enmy.setX(600);
            enmy.setY(0);

        }   
    }
    
    public void isShot(Projectile enmy){
        
        //TODO!
        if(Math.abs(enmy.getPosX()-posX)<=15 && Math.abs(enmy.getPosY()-posY)<=15){
            if(defence>0){
             defence--;   
            }else{
            health-=0.5;
            enmy.setDead(true);
            }
        }   
    }
    public void render(GraphicsContext gc){
        gc.setFill(Color.BLUE);
        gc.fillOval(posX, posY, sizeX, sizeY);
        
    }
    
    //Constructor:
    public Player(double x, double y,int health, int defence,int sizeX, int sizeY,double speed, GraphicsContext gc){
        this.posX = x;
        this.posY = y;
        this.health = health;
        this.defence = defence;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.speed=speed;
    }
    
}