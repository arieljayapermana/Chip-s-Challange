/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.objects;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * kelas ini merepresentasikan objek finish di dalam game
 * @author Ignasius David Y (2013730019), Ariel Jayapermana (2013730050), Christofer Indra Sinarya (2013730042)
 */
public class Finish extends Tile{
    
    /**
     * image pertama dari finish
     */
    private Image img1;
    
    /**
     * image kedua dari finish
     */
    private Image img2;
    
    /**
     * atribut yang nilainya berubah-ubah antara img1 atau img2
     */
    private Image img;
    
    /**
     * atribut untuk menentukan nilai dari img, apakah img1 atau img2
     */
    private int imgNumber;
    
    /**
     * koordinat x dari objek
     */
    private int xCoordinate;
    
    /**
     * koordinat y dari objek
     */
    private int yCoordinate;
    
    /**
     * constructor dari kelas Finish
     * menginisialisasi atribut-atribut dari kelas Finish
     * @param xCoordinate
     * @param yCoordinate 
     */
    public Finish(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.img1 = tk.getImage("images\\finish.png");
        this.img2 = tk.getImage("images\\finish2.png");
        this.img = img1;
        this.imgNumber = 1;
    }
    
    /**
     * method untuk mengubah-ubah nilai dari img sehingga memunculkan efek seolah-olah bergerak
     */
    public void changeImage()
    {
        if (this.imgNumber==1)
        {
            this.img = this.img2;
            this.imgNumber = 2;
        }
        else
        {
            this.img = this.img1;
            this.imgNumber = 1;
        }
    }

    /**
     * getter dari image
     * @return img
     */
    @Override
    public Image getImg() {
        return img;
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
     * method untuk mencek apakah objek bisa diinjak atau tidak
     * @return true
     */
    @Override
    public boolean isMoveable() {
        return true;
    }
    
    /**
     * method untuk mencek apakah sebuah objek menyebabkan chip mati atau tidak
     * @return false
     */
    @Override
    public boolean isLethal() {
        return false;
    }
            
            
}
