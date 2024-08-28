package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS

    //Default size for player characters, NPCs etc.
    final int originalTileSize = 16;  //16x16 tile

    //Scaling to adapt to modern display sizes
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;      //48x48 tile

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;

    public final int screenWidth = tileSize * maxScreenCol;   // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow;  // 576 pixels


    //WORLD SETTIINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth  = tileSize * maxWorldCol;
    public final int worldH = tileSize * maxWorldRow;
    //FPS
    int FPS = 60;


    TileManager tileM = new TileManager(this);


    //Key Handler
    KeyHandler keyH = new KeyHandler();

    //Thread is something you can start and stop (TIME)
    Thread gameThread;

    public Player player = new Player(this,keyH);

    //Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);

        //When set to true, all the drawing from this component will be done in an off-screen painting buffer
        //Better rendering performance
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);

        //setFocusable(true) with this, this GamePanel can be "focused" to receive key input
        this.setFocusable(true);
    }

    public void startGamethread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    //When we start the gamethread it auto runs the run method
    @Override
    public void run() {
        //Core of our game

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;


        //As long as this gamethread exists it repeats the process written between the brackets
        while (gameThread != null) {


            // 1. Update info such as character positions
            update();


            // 2. Draw the screen with updated info
            repaint();

            //For example If Player character is at 100x and 100y and you press on the down button
            //this should make your char move down via the Y axis (100 + 3)

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //1
    public void update() {
        player.update();
    }
    //2

    //Graphics is a class that has many functions to draw objects on the screen
    public void paintComponent(Graphics g) {

        //Whenever you use paintComponent with JPanel you must use the line below!
        super.paintComponent(g);

        //Graphics2D class extends the Graphic class to provide more sophisticated control over geometry
        //coordinate transformations color management, and text layout.

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        player.draw(g2);

        //Dispose of this graphics context and release any system resources that it is using
        //Saves some memory
        g2.dispose();


    }
}
