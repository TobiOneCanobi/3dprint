package org.example.Board2;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class TicTacToeBoard2 {
    public static void main(String[] args) {
        JavaCSG board = JavaCSGFactory.createNoCaching();

        Geometry3D plate = board.box3D(10, 50, 3, true);
        plate = board.translate3D(0,0,-10).transform(plate);
        Geometry3D plate2 = board.box3D(10, 50, 3, true);
        plate2 = board.rotate3DX(board.degrees(90)).transform(plate2);
        plate2 = board.translate3D(0,10,0).transform(plate2);
        Geometry3D gridp1 = board.union3D(plate,plate2);

        Geometry3D plate3 = board.box3D(10, 50, 3, true);
        plate3 = board.translate3D(0,0,10).transform(plate3);
        Geometry3D plate4 = board.box3D(10, 50, 3, true);
        plate4 = board.rotate3DX(board.degrees(90)).transform(plate4);
        plate4 = board.translate3D(0,-10,0).transform(plate4);
        Geometry3D gridp2 = board.union3D(plate3,plate4);
        Geometry3D finalgrid = board.union3D(gridp1,gridp2);

        board.view(finalgrid);
    }
}
