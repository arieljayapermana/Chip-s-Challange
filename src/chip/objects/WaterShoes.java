/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * kelas yang merepresentasikan objek water shoes
 * @author Ignasius David Y (2013730019), Ariel Jayapermana (2013730050), Christofer Indra Sinarya (2013730042)
 */
public class WaterShoes {
    
    /**
     * atribute yang menyimpan gambar water shoes
     */    
    private Image img;
    
     /**
     * koordinat x dari water shoes
     */
    private int xCoordinate;
    
        
    /**
     * koordinat y dari water shoes
     */
    private int yCoordinate;

    /**
     * constructor dari kelas WaterShoes
     * menginisialisasi atribut dari kelas WaterShoes
     * @param xCoordinate
     * @param yCoordinate 
     */
    public WaterShoes(int xCoordinate,int yCoordinate) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.img = tk.getImage("images\\waterShoes.png");
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
    }
    
    /**
     * getter untuk image
     * @return img
     */
    public Image getImg()
    {
        return this.img;
    }
    
        
    /**
     * getter dari koordinat x
     * @return x
     */
    public int getXCoordinate()
    {
        return this.xCoordinate;
    }
      
    /**
     * getter dari koordinat y
     * @return y
     */
    public int getYCoordinate()
    {
        return this.yCoordinate;
    }
    
}
