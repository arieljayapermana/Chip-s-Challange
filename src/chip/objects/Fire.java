/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;


/**
 * kelas ini merepresentasikan objek api di dalam game
 * @author Ignasius David Y (2013730019), Ariel Jayapermana (2013730050), Christofer Indra Sinarya (2013730042)
 */
public class Fire extends Tile{
    
    /**
     *  atribut dari kelas fire
     *  selalu bernilai true, karena objek fire menyebabkan chip mati
     */
    public static boolean lethal = true;
    
    /**
     * constructor dari kelas Fire
     * menginisialisasi atribut-atribut yang dimiliki kelas Fire
     */
    public Fire() {
        this.img = tk.getImage("images\\fire.png");
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
     * @return true
     */
    @Override
    public boolean isLethal() {
        return lethal;
    }
    
}
