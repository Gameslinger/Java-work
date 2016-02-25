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
public class Enemy {
    //Starting points/Velocity:
    
    private double velX, velY;
    private double sizeX, sizeY;
    private double posX, posY;
    private double speed;
    private boolean scatter = false;
    private double startScatter = 0;
    private double scatterX, scatterY;
    double shootDelay = 6;
    double shootTime = 0;
    
     public void setShootDelay(double sec){
        shootDelay = sec;
    }
     public double getShootDelay(){
        return shootDelay;
    }
    
     public void setShootTime(double sec){
        shootTime = sec;
    }
     public double getShootTime(){
        return shootTime;
    }
    
    public void setStartScatter(double sec){
        startScatter = sec;
    }
     public double getStartScatter(){
        return startScatter;
    }
    
    public void setScatter(boolean state){
        this.scatter = state;
    }
     public boolean getScatter(){
        return scatter;
    }
    
     public void setSpeed(double speed){
        this.speed = speed;
    }
     public double getSpeed(){
        return speed;
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
    
    public void setX(double x){
          this.posX = x;
    }
    public void setY(double y){
         this.posY = y;
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
      
    //Health/Defence:
    private int health;
    private int defence;
    
    public int getHealth(){
        return health;
    }
  
    public int getDefence(){
        return defence;
    }
    
    public void setHealth(int newHealth){
        health = newHealth;
    }
    
    public void setDefence(int newDefence){
        defence = newDefence;
    }
    //Enemy Move
    public void move(double pxX,double pxY){
        this.posX -= pxX;
        this.posY -= pxY;
    }
    
    public void setPos(double x, double y){
        posX = x;
        posY = y;
    }
    
    //Enemy AI
    public void AI(Player plr){
        double PlrX = plr.getPosX();
        double PlrY = plr.getPosY();
       
        if(scatter){
            
            if(posX < scatterX){
          if(posY < scatterY){
           move(-speed,-speed);
          }else{
         move(-speed,speed);
          }
        }else{
            if(posY>scatterY){
            move(speed,speed);
            }else{
                move(speed,-speed);
            }
        }
        }else{
        if(posX < PlrX){
          if(posY < PlrY){
           move(-speed,-speed);
          }else{
         move(-speed,speed);
          }
        }else{
            if(posY>PlrY){
            move(speed,speed);
            }else{
                move(speed,-speed);
            }
        }
       }
    }
        
    public void render(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillOval(posX, posY, sizeX, sizeY);
    }
    //Constructor:
     Enemy(int health, int defence,int sizeX, int sizeY,double speed){
         //TODO: Add shooting ablility?
        corner();
        this.speed =speed;
        this.health = health;
        this.defence = defence;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        
         scatterX = (int) Math.floor(Math.random()*600);
         scatterY = (int) Math.floor(Math.random()*600);
         
    }
     public void corner(){
         int side =(int) Math.floor(Math.random()*4+1);
        switch(side){
            case 1:
            //Spawn in bottom left corner:
            posX = 0;
            posY = 600;
            break;
            
            case 2:
            //Spawn in top left corner:
            posX = 0;
            posY = 0;
            break;
                
            case 3:
            //Spawn in top right corner:
            posX = 600;
            posY = 0;
            break;
                
            case 4:
            //Spawn in bottom right corner:
            posX = 600;
            posY = 600;
            break;
        }

     }
    
     public void chooseScatter(){
         scatterX = (int) Math.floor(Math.random()*600);
         scatterY = (int) Math.floor(Math.random()*600);
     }
}


      
 
    
