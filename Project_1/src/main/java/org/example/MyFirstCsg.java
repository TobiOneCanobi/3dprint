package org.example;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsg.Transform3D;

public class MyFirstCsg {
    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createNoCaching();

        Geometry3D cyl = csg.cylinder3D(10,20,128,false);

        csg.view(cyl);
    }

}

