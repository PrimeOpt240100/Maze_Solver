package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewClass extends JFrame
{
    public static void main(String[] args){
       NewClass view = new NewClass();
       view.setVisible(true);
    }
    private final int[][] grid = {
            {1,1,1,1,1,1,1},
            {1,0,0,0,0,0,1},
            {1,0,1,0,1,0,1},
            {1,0,0,1,0,0,1},
            {1,0,1,0,1,0,1},
            {1,0,0,0,0,9,1},
            {1,1,1,1,1,1,1},
    };
    public List<Integer> arr = new ArrayList<>();
    public NewClass(){
        setTitle("Maze Solver");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.dfs(grid,1,1,arr);
    }
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                Color color;
                switch(grid[i][j]){
                    case 1 : color=Color.black;break;
                    case 9 : color=Color.CYAN;break;
                    default: color= Color.LIGHT_GRAY;break;
                }
                g.setColor(color);
                g.fillRoundRect(100*j,100*i,100,100,5,5);
                g.setColor(Color.GRAY);
                g.drawRoundRect(100*j,100*i,100,100,5,5);
            }
        }

        for(int i=0;i<arr.size();i+=2){
            int y = arr.get(i+1);
            int x = arr.get(i);
            g.setColor(Color.green);
            g.fillRoundRect(100*x+10,100*y+10,80,80,5,5);
        }

    }
}
