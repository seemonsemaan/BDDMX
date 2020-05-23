/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seemon
 */
public class ColorObject {
    private int Red;
    private int Green;
    private int Blue;
    private String Name;

    public ColorObject(int Red, int Green, int Blue, String Name) {
        this.Red = Red;
        this.Green = Green;
        this.Blue = Blue;
        this.Name = Name;
    }

    public int getRed() {
        return Red;
    }

    public int getGreen() {
        return Green;
    }

    public int getBlue() {
        return Blue;
    }

    public String getName() {
        return Name;
    }
    
}
