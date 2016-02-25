
package GabeRun;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Coin {
    private double posX, posY,sizeX, sizeY;
    private boolean pickedUp = false;
    public void setPosX(double posX){
        this.posX = posX;
    }
     public double getPosX(){
        return posX;
    }
     
      public void setPosY(double posY){
        this.posY = posY;
    }
     public double getPosY(){
        return posY;
    }
     
      public void setSizeX(double sizeX){
        this.sizeX = sizeX;
    }
     public double getSizeX(){
        return sizeX;
    }
     
      public void setSizeY(double sizeY){
        this.sizeY = sizeY;
    }
     public double getSizeY(){
        return sizeY;
    }
    
    public boolean pickedUp(Player plr){
        if(Math.abs(plr.getPosX()-posX)<=25 && Math.abs(plr.getPosY()-posY)<=25 && !pickedUp){
            pickedUp=true;
           return true; 
        }
        return false;
    }
    public void render(GraphicsContext gc){
        if(!pickedUp){
        gc.setFill(Color.YELLOW);
        gc.fillOval(posX, posY, sizeX, sizeY);
           }
        }
    public void move(){
        posX=(int) Math.floor(Math.random()*550 + 30);
        posY=(int) Math.floor(Math.random()*550 + 30);
       
    }
    
public Coin(double sizeX,double sizeY){
        this.posX=(int) Math.floor(Math.random()*550 + 30);
        this.posY=(int) Math.floor(Math.random()*550 + 30);
        this.sizeX=sizeX;
        this.sizeY=sizeY;
    }
}