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
public class Wall extends Tile{

    public Wall() {
        this.img = tk.getImage("images\\wall.png");
    }

    @Override
    public boolean isMoveable() {
        return false;
    }

    @Override
    public boolean isLethal() {
        return false;
    }
    
}
