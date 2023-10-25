package org.example.Cross;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class TicTacToeCross {
    public static void main(String[] args) {

        JavaCSG cross = JavaCSGFactory.createNoCaching();

        Geometry3D rect = cross.box3D(5,5,1,true);
        Geometry3D rect2 = cross.box3D(5,5,1,true);
        rect = cross.rotate3DX(cross.degrees(45)).transform(rect);
        rect2 = cross.rotate3DX(cross.degrees(-45)).transform(rect2);

        Geometry3D cross1 = cross.union3D(rect,rect2);

        cross1 = cross.rotate3DY(cross.degrees(90)).transform(cross1);

        cross.view(cross1);
    }

}
