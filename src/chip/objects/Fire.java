/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;


/**
 *
 * @author Ariel Jayapermana
 */
public class Fire extends Tile{

    public Fire() {
        this.img = tk.getImage("images\\fire.png");
    }

    @Override
    public boolean isMoveable() {
        return true;
    }

    @Override
    public boolean isLethal() {
        return true;
    }
    
}
