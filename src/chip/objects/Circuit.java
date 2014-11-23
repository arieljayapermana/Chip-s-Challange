/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * kelas yang merepresentasikan circuit di dalam game
 * @author Ignasius David Y (2013730019), Ariel Jayapermana (2013730050), Christofer Indra Sinarya (2013730042)
 */
public class Circuit {
    
    /**
     * atribut yang menyimpan jumlah circuit didalam game
     */
    public static int jumlahCircuit = 0;
    
    /**
     * image dari circuit
     */
    private Image img;
    
    /**
     * koordinat x circuit
     */
    private int xCoordinate;
    
    /**
     * koordinat y circuit
     */
    private int yCoordinate;
    
    /**
     * constructor dari circuit
     * menginisialisasi atribut-atribut dari kelas circuit
     * setiap kali objek circuit dibuat, makan jumlahCircuit akan bertambah satu
     * @param xCoordinate
     * @param yCoordinate 
     */
    public Circuit(int xCoordinate,int yCoordinate) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.img = tk.getImage("images\\circuit.png");
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        jumlahCircuit++;
    }
    
    /**
     * getter dari image circuit
     * @return img
     */
    public Image getImg()
    {
        return this.img;
    }
    
    /**
     * getter dari koordinat x circuit
     * @return x
     */
    public int getXCoordinate()
    {
        return this.xCoordinate;
    }
    
    /**
     * getter dari koordinat y circuit
     * @return y
     */
    public int getYCoordinate()
    {
        return this.yCoordinate;
    }
    
}
