package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/run_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/run_up_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/run_up_3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/run_up_4.png"));


            down1 = ImageIO.read(getClass().getResourceAsStream("/player/run_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/run_down_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/run_down_3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/run_down_4.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/run_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/run_left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/run_left_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/run_left_4.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/run_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/run_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/run_right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/run_right_4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Update method gets called 60 times per second (60FPS)
    public void update() {

        //This statement makes the player move only when the keys are pressed
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){


            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed;
            } else if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;

            } else if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;
            }

            //Every frame that gets called increases the counter by 1
            spriteCounter++;
            //If counter hits 10 it changes the sprite
            //Player changes every 10 frames
            if(spriteCounter > 8) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics g2) {
        /*//Sets color for drawing objects
        g2.setColor((Color.white));

        //Drawing rectangle and fills it with the specified color
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);*/

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                if(spriteNum == 3){
                    image = up3;
                }
                if(spriteNum == 4){
                    image = up4;
                }

                break;
            case "down":

                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                if(spriteNum == 3){
                    image = down3;
                }
                if(spriteNum == 4){
                    image = down4;
                }

                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                if(spriteNum == 3){
                    image = left3;
                }
                if(spriteNum == 4){
                    image = left4;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                if(spriteNum == 3){
                    image = right3;
                }
                if(spriteNum == 4){
                    image = right4;
                }

                break;


        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
