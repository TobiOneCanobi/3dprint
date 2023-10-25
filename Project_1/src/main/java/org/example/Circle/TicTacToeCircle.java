package org.example.Circle;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class TicTacToeCircle {
    public static void main(String[] args) {

        double inDia = 5;
        double outDia = 10;
        double objHeight = 5;

        JavaCSG circle = JavaCSGFactory.createNoCaching();

        Geometry3D cyl = circle.flatRing3D(inDia-0.5,outDia-0.5,objHeight,128,false);


        circle.view(cyl);
    }

}
