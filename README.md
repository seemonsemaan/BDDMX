# BDDMX

Java application for Color, Gender and Skin Detection

## Requirements

* Java 8  
* OpenCV 2.4.13.6

## Import

Import the project to your favorite IDE  
> **(for Netbeans make sure  the folder nbproject is in the root)**

### Add OpenCV to your project

#### The JAR file

Add `opencv\build\java\opencv-2413.jar` to your project libraries.

#### The EXE file

Then add the executable by adding `-Djava.library.path="[path]\opencv\build\java\x64\"` to the **VM Options** in the **Run** section

#### Run

Now you can run the project in your IDE:
* Choose an image
* Choose to run:
    * Color detection
    * Gender detection
    * Skin detection