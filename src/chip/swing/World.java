/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.swing;
import chip.objects.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.*;

/**
 * kelas yang mengontrol dan mengendalikan permainan
 * @author Ignasius David, Ariel Jayapermana, Christopher Indra Sinarya
 */
public class World extends JPanel implements ActionListener{
    
    /**
     *  array 2 dimensi yang menampung objek-objek yang digunakan dalam permainan
     */
    private Tile[][] board;
    
    /**
     *  objek kelas chip. merepresentasikan karakter chip dalam permainan
     */
    private Chip chip;
    
    /**
     *  array yang menampung circuit yang harus diambil oleh chip
     */
    private Circuit[] circuits;
    
    /**
     *  objek kelas Barrier. merepresentasikan barier dalam permainan
     */
    private Barrier barrier;   
    
    /**
     *  objek kelas Finish. merepresentasikan Finish dalam permainan
     */
    private Finish finish;   
    
    /**
     *  atribut yang berisi karakter-karakter dari file text
     *  setiap karakter akan dibaca sebagai sebuah objek didalam game
     */
    private String level;
    
    /**
     *  objek kelas FireShoes. merepresentasikan sepatu api dalam permainan
     */
    private FireShoes fireShoes;
        
    /**
     *  objek kelas WaterShoes. merepresentasikan sepatu air dalam permainan
     */
    private WaterShoes waterShoes;
    
    /**
     * constructor kelas World
     * membangun permainan dari parameter yang diterima
     * @param level
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public World(String level)  throws FileNotFoundException, IOException
    {
        this.level = level;
        addLevel(level);
        String gongFile = "Music/background.wav";
        InputStream in = new FileInputStream(gongFile);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }
    
    /**
     * method untuk membuat level dari parameter yang diberikan
     * @param level
     * @throws FileNotFoundException 
     */
    public void addLevel(String level) throws FileNotFoundException
    {
        Timer timer = new Timer(500, this);
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
                    chip = new Chip(j,i);
                }
                else if (input.equals("-"))
                {
                    board[j][i] = new Barrier(j,i);
                    barrier = new Barrier(j,i);
                }
                else if (input.equals("#"))
                {
                    board[j][i] = new Finish(j,i);
                    finish = (Finish) board[j][i];
                }
                else if (input.equals("W"))
                {
                    board[j][i] = new Water();
                }
                else if (input.equals("B"))
                {
                    board[j][i] = new Floor();
                    waterShoes = new WaterShoes(j,i);
                }
                else if (input.equals("R"))
                {
                    board[j][i] = new Floor();
                    fireShoes = new FireShoes(j,i);
                }
            }
        }
    }
    /**
     * method untuk menggambarkan objek-objek dalam permainan
     * @param g 
     */
    @Override
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
        if (fireShoes!=null)
        {
        g.drawImage(fireShoes.getImg(), fireShoes.getXCoordinate()*board[0][0].getImg().getWidth(this) , fireShoes.getYCoordinate()*board[0][0].getImg().getHeight(this), this);   
        }
        if (waterShoes!=null)
        {
        g.drawImage(waterShoes.getImg(), waterShoes.getXCoordinate()*board[0][0].getImg().getWidth(this) , waterShoes.getYCoordinate()*board[0][0].getImg().getHeight(this), this);   
        }
        g.drawImage(chip.getImg(), chip.getXCoordinate()*board[0][0].getImg().getWidth(this) , chip.getYCoordinate()*board[0][0].getImg().getHeight(this), this);
    }

    /**
     * method untuk mengubah-ubah gambar finish sehingga tampak seperti bergerak
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        finish.changeImage();
        repaint();
    }
    
    /**
     * method untuk memainkan game berdasarkan input dari user
     * @param direction 
     */
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
            if (fireShoes !=null)
            {
                if (chip.getXCoordinate() == fireShoes.getXCoordinate() && chip.getYCoordinate() == fireShoes.getYCoordinate())
                {
                    chip.setHasFireShoes(true);
                    fireShoes = null;
                    Fire.lethal = false;
                }
            }
            if (waterShoes !=null)
            {
                if (chip.getXCoordinate() == waterShoes.getXCoordinate() && chip.getYCoordinate() == waterShoes.getYCoordinate())
                {
                    chip.setHasWaterShoes(true);
                    waterShoes = null;
                    Water.lethal = false;
                }
            }
            if (Circuit.jumlahCircuit == 0)
            {
                board[barrier.getXCoordinate()][barrier.getYCoordinate()] = new Floor();
            }
            repaint();
        }
    }
    
    /**
     * method untuk mengetahui apakah suatu level sudah tamat atau belum
     * @return true or false
     */
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
    
    /**
     * method untuk memindahkan objek chip sesuai dengan arah yang diinginkan
     * @param direction 
     */
    private void moveChip(int direction)
    {
        chip.move(direction, board);
    }
    
    /**
     * method untuk mereset ulang level sehingga kembali seperti semula
     * @throws FileNotFoundException 
     */
    public void restart() throws FileNotFoundException
    {
        Circuit.jumlahCircuit = 0;
        this.addLevel(level);
        Water.lethal=true;
        Fire.lethal=true;
               
    }

    /**
     * getter untuk fire shoes
     * @return fireShoes
     */
    public FireShoes getFireShoes() {
        return fireShoes;
    }

    /**
     * getter untuk waterShoes
     * @return waterShoes
     */
    public WaterShoes getWaterShoes() {
        return waterShoes;
    }

    /**
     * getter untuk chip
     * @return chip
     */
    public Chip getChip() {
        return chip;
    }
    

}
