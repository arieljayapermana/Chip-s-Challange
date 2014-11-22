/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * kelas yang merepresentasikan chip dalam game.
 * @author Ariel Jayapermana, Ignasius David, Christofer Sinarya
 */
public class Chip{
    
    /**
     *  atribut yang menyimpan gambar dari chip
     */
    private Image img;
    
    /**
     *  atribut yang menyimpan gambar dari chip
     */
    private final Image IMG_KIRI;
    
    /**
     *  atribut yang menyimpan gambar dari chip
     */
    private final Image IMG_KANAN;
    
    /**
     *  atribut yang menyimpan gambar dari chip
     */
    private final Image IMG_ATAS;
    
    /**
     *  atribut yang menyimpan gambar dari chip
     */
    private final Image IMG_BAWAH;
    
    /**
     *  atribut yang menyimpan gambar dari chip
     */
    private final Image IMG_DEATH;
    
    /**
     * koordinat x dari chip
     */
    private int xCoordinate;
    
    /**
     * koordinat y dari chip
     */
    private int yCoordinate;
    
    /**
     * atribut yang menyatakan arah dari chip
     * 2=bawah
     * 4=kiri
     * 8=atas
     * 6=kanan
     */
    private int direction;
    
    /**
     * atribut yang menyatakan apakah chip hidup atau mati
     * bernilai true bila dia hidup
     */
    private boolean isAlive;
    
    /**
     * atribut yang menyatakan apakah chip memiliki sepatu api
     * bernilai true bila dia memilikinya
     */
    private boolean hasFireShoes;
    
    /**
     * atribut yang menyatakan apakah chip memiliki sepatu air
     * bernilai true bila dia memilikinya
     */    
    private boolean hasWaterShoes;

    /**
     * constructor dari kelas chip
     * menginisialisasi atribut-atribut dari kelas chip
     * @param xCoordinate: koordinat x
     * @param YCoordinate: koordinat y 
     */
    public Chip(int xCoordinate, int YCoordinate) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.IMG_KIRI = tk.getImage("images\\chipKiri.png");
        this.IMG_KANAN = tk.getImage("images\\chipKanan.png");
        this.IMG_ATAS = tk.getImage("images\\chipAtas.png");
        this.IMG_BAWAH = tk.getImage("images\\chipBawah.png");
        this.IMG_DEATH = tk.getImage("images\\death.png");
        this.xCoordinate = xCoordinate;
        this.yCoordinate = YCoordinate;
        this.direction = 2;
        this.img = IMG_BAWAH;
        this.isAlive = true;
        this.hasFireShoes = false;
        this.hasWaterShoes = false;
    }
    
    /**
     * method untuk menggerakan chip sesuai dengan arah yang diberikan
     * method ini juga mencek apakah chip tetap hidup atau tidak setelah bergerak ke arah yang diinginkan
     * @param direction: arah yang diinginkan
     * @param board : area permainan yang digunakan
     */
    public void move(int direction,Tile[][] board)
    {
        if(this.direction!=direction)
        {
            this.direction = direction;
            switch(direction)
            {
                case 2 : this.img=this.IMG_BAWAH;break;
                case 8 : this.img=this.IMG_ATAS;break;
                case 4 : this.img=this.IMG_KIRI;break;
                case 6 : this.img=this.IMG_KANAN;break;
            }
        }
        else
        {
            if (this.direction == 2)
            {
                if (board[xCoordinate][yCoordinate+1].isMoveable())
                {
                    if (board[xCoordinate][yCoordinate+1].isLethal())
                    {
                        this.isAlive=false;
                        this.yCoordinate++;
                        this.img = IMG_DEATH;
                    }
                    else
                    {
                        this.yCoordinate++;
                    }
                }
            }
            else if (this.direction == 8)
            {
                if (board[xCoordinate][yCoordinate-1].isMoveable())
                {
                    if (board[xCoordinate][yCoordinate-1].isLethal())
                    {
                        this.isAlive=false;
                        this.yCoordinate--;
                        this.img = IMG_DEATH;
                    }
                    else
                    {
                        this.yCoordinate--;
                    }
                }
            }
            else if (this.direction == 4)
            {
                if (board[xCoordinate-1][yCoordinate].isMoveable())
                {
                    if (board[xCoordinate-1][yCoordinate].isLethal())
                    {
                        this.isAlive=false;
                        this.xCoordinate--;
                        this.img = IMG_DEATH;
                    }
                    else
                    {
                        this.xCoordinate--;
                    }
                }
            }
            else
            {
                if (board[xCoordinate+1][yCoordinate].isMoveable())
                {
                    if (board[xCoordinate+1][yCoordinate].isLethal())
                    {
                        this.isAlive=false;
                        this.xCoordinate++;
                        this.img = IMG_DEATH;
                    }
                    else
                    {
                        this.xCoordinate++;
                    }
                }
            }
        }
    }

    /**
     * getter dari isAlive
     * @return true or false
     */
    public boolean isChipAlive() {
        return isAlive;
    }
    
    /**
     * getter dari koordinat x
     * @return x
     */
    public int getXCoordinate() {
        return xCoordinate;
    }
    
    /**
     * getter dari koordinat y
     * @return y
     */
    public int getYCoordinate() {
        return yCoordinate;
    }

    /**
     * getter dari image chip
     * @return img
     */
    public Image getImg()
    {
        return this.img;
    }
    
    /**
     * method untuk men set apakah chip memiliki sepatu api atau tidak
     * @param hasFireShoes 
     */
    public void setHasFireShoes(boolean hasFireShoes) {
        this.hasFireShoes = hasFireShoes;
    }
    
    /**
     * method untuk men set apakah chip memiliki sepatu air atau tidak
     * @param hasWaterShoes 
     */
    public void setHasWaterShoes(boolean hasWaterShoes) {
        this.hasWaterShoes = hasWaterShoes;
    }
    
    /**
     * getter dari hasFireShoes
     * @return hasFireShoes
     */
    public boolean isHasFireShoes() {
        return hasFireShoes;
    }
    
    /**
     * getter dari hasWaterShoes
     * @return hasWaterShoes
     */
    public boolean isHasWaterShoes() {
        return hasWaterShoes;
    }
    
    
}
