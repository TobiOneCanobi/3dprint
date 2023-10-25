package org.example.Board;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class TicTacToeBoard {
    public static void main(String[] args) {
        JavaCSG board = JavaCSGFactory.createNoCaching();

        Geometry3D plate = board.box3D(3, 50, 10, true);

        Geometry3D hole1 = board.box3D(3, 10, 7, true);
        hole1 = board.translate3D(0, 10, -3.5).transform(hole1);

        Geometry3D hole2 = board.box3D(3, 10, 7, true);
        hole2 = board.translate3D(0, -10, -3.5).transform(hole2);


        Geometry3D boardWithHoles = board.difference3D(plate, hole1);
        boardWithHoles = board.difference3D(boardWithHoles, hole2);

        board.view(boardWithHoles);
    }
}
