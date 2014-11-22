/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * kelas yang merepresentasikan tile dalam permainan.
 * @author Ariel Jayapermana, Ignasius David, Christofer Indra Sinarya
 */
public abstract class Tile {
    
    /**
     *  atribut yang menyimpan gambar dari setiap objek
     */
    protected Image img;
    
    /**
     *  
     */
    protected Toolkit tk = Toolkit.getDefaultToolkit();
    
    /**
     * method untuk mencek apakah objek bisa diinjak atau tidak
     * @return true or false
     */
    public abstract boolean isMoveable();
    
    /**
     * method untuk mencek apakah sebuah objek menyebabkan chip mati atau tidak
     * @return true or false
     */
    public abstract boolean isLethal();
    
    /**
     * getter untuk image
     * @return img
     */
    public Image getImg() {
        return img;
    }
}
