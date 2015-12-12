package Camelot;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Piece {
    private Number x = 0L;
    private Number y = 0L;
    private Character piece;

    public Piece(final Number posX, final Number posY, final String type,
        final String color) {
        cg_init_Piece_1(posX, posY, type, color);
    }

    public Piece() {
    }

    public void cg_init_Piece_1(final Number posX, final Number posY,
        final String type, final String color) {
        x = posX;
        y = posY;

        if (Utils.equals(color, "white")) {
            if (Utils.equals(type, "knight")) {
                piece = 'k';
            } else {
                piece = 'p';
            }
        }

        if (Utils.equals(color, "black")) {
            if (Utils.equals(type, "knight")) {
                piece = 'K';
            } else {
                piece = 'P';
            }
        }
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }

    public Character getPiece() {
        return piece;
    }

    public void move(final Number posX, final Number posY) {
        x = posX;
        y = posY;
    }

    public String toString() {
        return "Piece{" + "x := " + Utils.toString(x) + ", y := " +
        Utils.toString(y) + ", piece := " + Utils.toString(piece) + "}";
    }
}
