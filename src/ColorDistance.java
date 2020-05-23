/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seemon
 */
public class ColorDistance implements Comparable<ColorDistance>{
    private Integer distance;
    private String name;

    public ColorDistance(int distance, String name) {
        this.distance = distance;
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ColorDistance t) {
        return this.getDistance().compareTo(t.getDistance());
    }
    
}
