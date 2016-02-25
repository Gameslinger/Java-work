/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GabeRun;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/**
 *
 * @author Gabe
 */
public class GabeRun extends Application{
    Image gabe;
    
    Canvas canvas;
    GraphicsContext gs;
    
    int amount = 10;
    int num = amount;
    Coin coins[] = new Coin[255];
    Enemy enemy[] = new Enemy[20];
    Projectile proj[] = new Projectile[255];
    int enemyCount = 1;
    int projCount = 0;
    int level = 1;
    
    boolean enemyFire = false;
    Player plr;
    
    Scene scene;
    
    boolean start = false;
    
    boolean up,down,left,right=false;
    
    long time = 0;
    long sec = 0;
    
    long sWait = 10;
    long sDuration = 3;
    
    @Override
    public void init(){
        gabe = new Image("/image/gabe.jpg");
    }
    
    @Override
    public void start(Stage stage) {
        stage.setIconified(false);
        stage.setTitle("Gabe Run - Can you reach level 50?");
         canvas = new Canvas(600,600);
        gs = canvas.getGraphicsContext2D();
         
        //Create Player, Enemy, and Coin Objects
        plr = new Player(300,300,3,0,30,30,1.5,gs);
        
        enemy[0]= new Enemy(1,0,30,30,0.4);
        
        for(int i = 0; i < amount; i++){
            coins[i] = new Coin(30,30);
        }
        
        
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        scene = new Scene(root,600,600,Color.GREY);
        scene.setOnKeyPressed((event)->{
         if(plr.getPlay()){
        if(event.getCode()==KeyCode.W){
            up = true;
            start = true;
        }
        
        if(event.getCode()==KeyCode.S)down=true;
        if(event.getCode()==KeyCode.A)left=true;
        if(event.getCode()==KeyCode.D)right=true;
         
        if(event.getCode()==KeyCode.ESCAPE){
            start = false;
        }
        
        if(event.getCode()==KeyCode.TAB){
            enemyFire= true;
        }
         }}); 
        scene.setOnKeyReleased((event)->{
        
        if(event.getCode()==KeyCode.W)up=false;
        if(event.getCode()==KeyCode.S)down=false;
        if(event.getCode()==KeyCode.A)left=false;
        if(event.getCode()==KeyCode.D)right=false;
         
         }); 
       stage.setScene(scene);
       
        new AnimationTimer() {
        @Override
      public void handle(long miliT)
        {
            if(start){
            time++;
            if(time == 60){
                time = 0;
                sec++;
                for(int i = 0; i<enemyCount;i++){
            enemy[i].setStartScatter(enemy[i].getStartScatter()+Math.random()*3);
            if(enemyFire){
            enemy[i].setShootTime(enemy[i].getShootTime()+Math.random()*3);
            }
            }
            }
           }
                for(int i = 0; i<enemyCount;i++){
        if(enemy[i].getStartScatter()>sWait){
            enemy[i].setScatter(true);
            if(enemy[i].getStartScatter()>sWait+sDuration){
                enemy[i].setStartScatter(0);
                enemy[i].chooseScatter();
                enemy[i].setScatter(false);
                 }
            }
        
       if(enemy[i].getShootTime()>=enemy[i].getShootDelay()&& level % 2 == 0){
            proj[projCount] = new Projectile(enemy[i].getPosX(), enemy[i].getPosY(), 10,10,plr);
            projCount++;
            enemy[i].setShootTime(0);
            
            }
                }
                
        if(plr.getPlay() && plr.getHealth() > 0 && num > 0 && start){
        gs.clearRect(0, 0, 600, 600);
        if(up)plr.move(0,plr.getSpeed());
        if(down)plr.move(0, -plr.getSpeed());
        if(left)plr.move(-plr.getSpeed(),0);
        if(right)plr.move(plr.getSpeed(),0);
        
        
        
        
        for(int i = 0; i < amount; i++){
            if(coins[i].pickedUp(plr))num--;
            coins[i].render(gs);
        }
        
        plr.render(gs);
        
        for(int i = 0; i<enemyCount;i++){
        enemy[i].AI(plr);
        plr.isAttacked(enemy[i]);
        enemy[i].render(gs);
        }
        for(int i = 0; i < projCount; i++){
            if(!proj[i].getDead()){
            proj[i].AI();
            proj[i].render(gs);
            plr.isShot(proj[i]);
            }
        }
        
        drawCount();
         
            }else if(start==false){
              drawMenu();
            }else{ 
        plr.setPlay(false);
          gameOver();
            } 
        }
    }.start();
       
       stage.show();
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void drawCount(){
        gs.setFill(Color.GREEN);
        gs.setFont(Font.font("Sans-serif",FontWeight.BOLD,30));
        
        gs.fillText("Lives: "+plr.getHealth(),0,25);
        
        gs.fillText("Coins: "+num,0,50);
    
        gs.fillText("Level: "+level,0,75);
        
        gs.fillText("Time: "+sec,0,100);
        
        gs.setStroke(Color.BLACK);
        gs.strokeRect(0,0, 600, 600);
    }
    public void gameOver(){
       projCount = 0;
        if(num == 0){
            gs.setFont(Font.font("Impact", FontWeight.BOLD, 72));
            gs.setFill(Color.BLUE);
            gs.fillText("You win", 180, 390);
            gs.setFill(Color.BLACK);
            gs.strokeText("You win", 180, 390);
            plr.setHealth(plr.getHealth()+1);
            level++;
            amount += 5;
        }else{
            gs.setFont(Font.font("Impact", FontWeight.BOLD, 72));
            gs.setFill(Color.RED);
            gs.fillText("GAME OVER", 150, 390);
            gs.setFill(Color.BLACK);
            gs.strokeText("GAME OVER", 150, 390);
            plr.setHealth(3);
            plr.setSpeed(1.5);
            
            for(int i = 0; i < enemyCount;i++){
                enemy[i].setSpeed(0.4);
            }
            enemyCount = 1;
            level = 1;
            amount = 10;
            sec = 0;
            time = 0;
            
        }
        restart();
    }
   public void drawMenu(){
                //Draw Splash screen
            gs.drawImage(gabe, 240,40);

            gs.setFont(Font.font("Cursive", FontWeight.BOLD, 72));
            gs.setFill(Color.BLUE);
            gs.fillText("Gabe Run", 150, 280);
            gs.setFill(Color.BLACK);
            gs.strokeText("Gabe Run", 150, 280);
            
            gs.setFont(Font.font("Cursive", FontWeight.BOLD, 72));
            gs.setFill(Color.BLUE);
            gs.fillText("Gabe Run", 150, 280);
            gs.setFill(Color.BLACK);
            gs.strokeText("Gabe Run", 150, 280);
            
            //Draw start!
            gs.setFont(Font.font("Cursive", FontWeight.BOLD, 32));
            gs.setFill(Color.BLUE);
            gs.fillText("Press \"W\" to start (Esc to pause)", 50, 320);
            
   }
  public void restart(){
      
      //TODO: Add support for levels
      
      for(int i = 0; i < amount; i++){
          coins[i] = new Coin(30,30);
      }
      plr.setPlay(true);
      plr.setPos(300,300);
      
      num = amount;
      start = false;
      for(int i = 0; i< enemyCount; i++){
      enemy[i].corner();
      
      if(level%2==0&&enemy[i].getSpeed()<= plr.getSpeed()-0.2){
          enemy[i].setSpeed(enemy[i].getSpeed()+0.2);
      }else if(level > 5){
         enemy[i].setSpeed(enemy[i].getSpeed()+0.2);
         plr.setSpeed(plr.getSpeed()+0.2);
      }
      
      }
      if(level%3 == 0){
            enemy[enemyCount] = new Enemy(1,0,30,30,0.4);
        enemyCount++;
        
      }
  }
}