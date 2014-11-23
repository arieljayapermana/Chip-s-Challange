/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;


/**
 * kelas yang merepresentasikan wall di dalam game
 * @author Ignasius David Y (2013730019), Ariel Jayapermana (2013730050), Christofer Indra Sinarya (2013730042)
 */
public class Wall extends Tile{
    
    /**
     * constructor dari kelas wall
     * menginisialisasi atribut dari kelas wall
     */
    public Wall() {
        this.img = tk.getImage("images\\wall.png");
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
