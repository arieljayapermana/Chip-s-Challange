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
public class Barrier extends Tile{

    private int xCoordinate;
    private int yCoordinate;
    private boolean moveable;

    public Barrier(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.img = tk.getImage("images\\barrier.png");
        this.moveable = false;
    }
    
    public void setMoveable(boolean moveable)
    {
        this.moveable = moveable;
    }
    
    public int getXCoordinate()
    {
        return this.xCoordinate;
    }
    
    public int getYCoorfdinate()
    {
        return this.yCoordinate;
    }

    @Override
    public boolean isMoveable() {
        return this.moveable;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isLethal() {
        return false;
    }
    
}
