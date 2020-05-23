/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seemon
 */
public class ColorRecurrence {

    private int recurrence;
    private String colorName;

    public int getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(int recurrence) {
        this.recurrence = recurrence;
    }

    public String getColor() {
        return colorName;
    }

    public void setColor(String color) {
        this.colorName = color;
    }

    public ColorRecurrence(int recurrence, String color) {
        this.recurrence = recurrence;
        this.colorName = color;
    }

    @Override
    public String toString() {
        return colorName + ": " + recurrence;
    }

}
