/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;

/**
 * kelas ini merepresentasikan objek water di dalam game
 * @author Christofer Indra Sinarya, Ariel Jayapermana, Ignasius David
 */
public class Water extends Tile{

    /**
     *  atribut dari kelas water
     *  selalu bernilai true, karena objek water menyebabkan chip mati
     */
    public static boolean lethal = true;
    
    /**
     * constructor dari kelas Water
     * menginisialisasi atribut-atribut yang dimiliki kelas Water
     */
    public Water() {
        this.img = tk.getImage("images\\water.png");
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
     * @return lethal
     */
    @Override
    public boolean isLethal() {
        return lethal;
    }
    
}
