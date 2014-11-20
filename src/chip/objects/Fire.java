/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;


/**
 *
 * @author i13019
 */
public class Fire extends Tile{

    public static boolean lethal = true;
    
    public Fire() {
        this.img = tk.getImage("images\\fire.png");
    }

    @Override
    public boolean isMoveable() {
        return true;
    }

    @Override
    public boolean isLethal() {
        return lethal;
    }
    
}
