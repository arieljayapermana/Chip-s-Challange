/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.objects;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Ariel Jayapermana
 */
public abstract class Tile {

    protected Image img;
    protected Toolkit tk = Toolkit.getDefaultToolkit();
    
    public abstract boolean isMoveable();
    
    public abstract boolean isLethal();

    public Image getImg() {
        return img;
    }
}
