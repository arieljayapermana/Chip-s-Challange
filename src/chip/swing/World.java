/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.swing;
import chip.objects.*;
import com.sun.webkit.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ignasius
 */
public class World extends JPanel implements ActionListener{
    
    private Tile[][] board;
    private Chip chip;
    private Circuit[] circuits;
    private Barrier barrier;
    private Finish finish;
    private String level;
    
    public World(String level)  throws FileNotFoundException 
    {
        this.level = level;
        addLevel(level);
    }
    
    private void addLevel(String level) throws FileNotFoundException
    {
        javax.swing.Timer timer = new javax.swing.Timer(500, this);
        timer.start();
        this.level = level;
        board = new Tile[15][15];
        Scanner sc = new Scanner (new File(level));
        circuits = new Circuit[sc.nextInt()];
        int indexCircuit = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String input = sc.next();
                if (input.equals("."))
                {
                    board[j][i] = new Floor();
                }
                else if (input.equals("x"))
                {
                    board[j][i] = new Wall();
                }
                else if (input.equals("F"))
                {
                    board[j][i] = new Fire();
                }
                else if (input.equals("C"))
                {
                    board[j][i] = new Floor();
                    circuits[indexCircuit] = new Circuit(j,i);
                    indexCircuit++;
                }
                else if (input.equals("*"))
                {
                    board[j][i] = new Floor();
                    chip = new Chip(i,j);
                }
                else if (input.equals("-"))
                {
                    board[j][i] = new Barrier(j,i);
                    barrier = new Barrier(j,i);
                }
                else if (input.equals("#"))
                {
                    board[j][i] = new Floor();
                    finish = new Finish(j,i);
                }
            }
        }
    }
    
    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                g.drawImage(board[i][j].getImg(), i*board[i][j].getImg().getWidth(this), j*board[i][j].getImg().getHeight(this), this);
            }
        } 
       for (int i = 0; i < circuits.length; i++) {
           if(circuits[i]!=null)
           {
            g.drawImage(circuits[i].getImg() , circuits[i].getXCoordinate()*board[0][0].getImg().getWidth(this) , circuits[i].getYCoordinate()*board[0][0].getImg().getHeight(this), this);
           }
        }
        g.drawImage(finish.getImg(), finish.getXCoordinate()*board[0][0].getImg().getWidth(this) , finish.getYCoordinate()*board[0][0].getImg().getHeight(this), this);
        g.drawImage(chip.getImg(), chip.getXCoordinate()*board[0][0].getImg().getWidth(this) , chip.getYCoordinate()*board[0][0].getImg().getHeight(this), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        finish.changeImage();
        repaint();
    }
    
    public void play(int direction)
    {
        if (chip.isChipAlive() && isFinish()== false )
        {
            moveChip(direction);
            for (int i = 0; i < circuits.length; i++) {
                if (circuits[i]!=null)
                {
                    if (chip.getXCoordinate() == circuits[i].getXCoordinate() &&  chip.getYCoordinate()== circuits[i].getYCoordinate())
                    {
                        Circuit.jumlahCircuit--;
                        circuits[i] = null;
                    }
                }
            }
            if (Circuit.jumlahCircuit == 0)
            {
                board[barrier.getXCoordinate()][barrier.getYCoordinate()] = new Floor();
            }
            repaint();
        }
    }
    
    public boolean isFinish()
    {
        if (this.finish.getXCoordinate() == chip.getXCoordinate() && this.finish.getYCoordinate() == chip.getYCoordinate())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void moveChip(int direction)
    {
        chip.move(direction, board);
    }
    
    public void restart() throws FileNotFoundException
    {
        Circuit.jumlahCircuit = 0;
        this.addLevel(level);
    }
    
}
