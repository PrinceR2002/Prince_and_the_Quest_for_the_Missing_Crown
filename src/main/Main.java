package main;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        JFrame window = new JFrame();

        //This lets the window properly close when user clicks the ("x") button.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Disables resizing the window
        window.setResizable(false);

        window.setTitle("Prince and the Quest for the Missing Crown");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        //This causes this Window to be sized to fit the preferred size and layouts of its subcomponents (=GamePanel)
        window.pack();


        window.setLocationRelativeTo((null));
        window.setVisible(true);

        gamePanel.startGamethread();


    }
}