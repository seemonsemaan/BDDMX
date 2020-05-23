
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Seemon
 */
public class ColorList {

    static ArrayList<ColorObject> colorList = new ArrayList<ColorObject>(Arrays.asList(
            new ColorObject(0, 0, 0, "Black"),
            new ColorObject(255, 255, 255, "White"),
            new ColorObject(255, 0, 0, "Red"),
            new ColorObject(0, 255, 0, "Lime"),
            new ColorObject(0, 0, 255, "Blue"),
            new ColorObject(255, 255, 0, "Yellow"),
            new ColorObject(0, 255, 255, "Cyan"),
            new ColorObject(255, 0, 255, "Magenta"),
            new ColorObject(192, 192, 192, "Silver"),
            new ColorObject(128, 128, 128, "Gray"),
            new ColorObject(128, 0, 0, "Maroon"),
            new ColorObject(128, 128, 0, "Olive"),
            new ColorObject(0, 128, 0, "Green"),
            new ColorObject(128, 0, 128, "Purple"),
            new ColorObject(0, 128, 128, "Teal"),
            new ColorObject(0, 0, 128, "Navy")
    ));
    
    public static ArrayList<ColorObject> getList(){
        return colorList;
    }
}
