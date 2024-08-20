package entity;

import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;

    //BufferedImage: it describes an Image with an accessible buffer
    // of image data. (We use this to store our image file)
    public BufferedImage up1, up2, up3, up4, down1, down2, down3, down4, left1, left2, left3, left4, right1, right2, right3, right4;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
