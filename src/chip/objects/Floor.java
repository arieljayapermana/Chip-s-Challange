/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;


/**
 * kelas yang merepresentasikan objek floor di dalam permainan
 * @author Ignasius David Y (2013730019), Ariel Jayapermana (2013730050), Christofer Indra Sinarya (2013730042)
 */
public class Floor extends Tile{

    /**
     * constructor dari kelas floor
     * menginisialisasi atribut dari kelas floor
     */
    public Floor() {
        this.img = tk.getImage("images\\floor.png");
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
