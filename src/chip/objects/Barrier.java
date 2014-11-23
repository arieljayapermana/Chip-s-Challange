/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.objects;


/**
 * kelas yang merepresentasikan barier yang menghalangi garis finish.
 * barier akan hilang jika semua circuit sudah didapatkan
 * @author Ignasius David Y (2013730019), Ariel Jayapermana (2013730050), Christofer Indra Sinarya (2013730042)
 */
public class Barrier extends Tile{

    /**
     * koordinat x dari barier
     */
    private int xCoordinate;
    
    /**
     * koordinat y dari barier
     */
    private int yCoordinate;
    
    /**
     * constructor dari barier
     * menginisialisasi nilai x,y,image
     * @param xCoordinate
     * @param yCoordinate 
     */
    public Barrier(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.img = tk.getImage("images\\barrier.png");
    }
    
    /**
     * getter untuk koordinat x
     * @return x
     */
    public int getXCoordinate()
    {
        return this.xCoordinate;
    }
    
    /**
     * getter untuk koordinat y
     * @return y
     */
    public int getYCoordinate()
    {
        return this.yCoordinate;
    }
    /**
     * method untuk mencek apakah objek bisa diinjak atau tidak
     * @return false
     */
    @Override
    public boolean isMoveable() {
        return false;
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
