package org.example.Refactoring;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javaopenscad.impl.core.AGeometry;
import org.abstractica.javaopenscad.impl.core.AGeometry2D;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe
{
    private final JavaCSG csg;
    private final double lineWidth = 3.0;
    private final  double height = 3.0;
    private final double squareSize = 15.0;
    private final double tolerance = 0.4;
    private  final int angularResolution = 64;
    public TicTacToe(JavaCSG csg)
    {
        this.csg = csg;
    }

    public Geometry3D cross()
    {
        Geometry3D beam1  = csg.box3D(2*squareSize,lineWidth,height,false);
        Geometry3D beam2 = csg.box3D(lineWidth, 2*squareSize, height, false);
        Geometry3D cross = csg.union3D(beam1, beam2);
        cross = csg.rotate3DZ(csg.degrees(45)).transform(cross);
        Geometry3D cutBox = csg.box3D(squareSize-tolerance, squareSize-tolerance,height,false);
        cross = csg.intersection3D(cross,cutBox);
        return cross;
    }

    public  Geometry3D circle()
    {
       Geometry3D circle = csg.cylinder3D(squareSize-tolerance,height,angularResolution,false );
       Geometry3D hole = csg.cylinder3D(squareSize-tolerance-lineWidth, height, angularResolution, false);
       return csg.difference3D(circle, hole);
    }

    public Geometry3D board()
    {
        List<Geometry3D> parts = new ArrayList<>();
        double  beamLength = 3*squareSize + 4*lineWidth;
        Geometry3D hBeam = csg.box3D(beamLength, lineWidth, height, false);
        hBeam = csg.translate3D(0.5*beamLength,0.5*lineWidth,0).transform(hBeam);
        for (int i = 0; i < 4; ++i)
        {
            parts.add((csg.translate3DY(i*(squareSize+lineWidth)).transform(hBeam)));
        }
        Geometry3D vBeam = csg.box3D(lineWidth, beamLength, height, false);
        vBeam = csg.translate3D(0.5*beamLength,0.5*lineWidth,0).transform(vBeam);
        for (int i = 0; i < 4; ++i)
        {
            parts.add((csg.translate3DX(i*(squareSize+lineWidth)).transform(vBeam)));
        }
        return csg.union3D(parts);
    }

        public  Geometry3D example()
        {
           List<Geometry3D> parts = new ArrayList<>();
           parts.add(board());
           parts.add(place(0,0,cross()));
            parts.add(place(1,1,cross()));
            parts.add(place(2,2,cross()));
            parts.add(place(0,1,circle()));
            parts.add(place(0,2,circle()));
            return csg.union3D(parts);

        }

        private Geometry3D place(int x, int y, Geometry3D g)
        {
            double tx = x+1*(squareSize+lineWidth)-0.5*squareSize;
            double ty = y+1*(squareSize+lineWidth)-0.5*squareSize;
            return csg.translate3D(tx,ty,0).transform(g);
        }

}
