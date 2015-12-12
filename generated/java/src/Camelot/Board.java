package Camelot;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Board {
    private static final Number X = 11L;
    private static final Number Y = 15L;
    private VDMSeq board = SeqUtil.seq();
    private VDMSeq pieces = SeqUtil.seq();

    public Board() {
        cg_init_Board_1();
    }

    public void cg_init_Board_1() {
        init();
    }

    public void init() {
        String auxLine = SeqUtil.toStr(SeqUtil.seq());
        board = SeqUtil.seq();

        long toVar_2 = Y.longValue();

        for (Long counter = 0L; counter <= toVar_2; counter++) {
            long toVar_1 = X.longValue();

            for (Long counter2 = 0L; counter2 <= toVar_1; counter2++) {
                if ((counter.longValue() + counter2.longValue()) <= 2L) {
                    auxLine = auxLine + new String(new char[] { '#' });
                }

                if ((counter2.longValue() - counter.longValue()) >= 9L) {
                    auxLine = auxLine + new String(new char[] { '#' });
                }

                if ((counter.longValue() - counter2.longValue()) >= 13L) {
                    auxLine = auxLine + new String(new char[] { '#' });
                }

                if ((counter.longValue() + counter2.longValue()) >= 24L) {
                    auxLine = auxLine + new String(new char[] { '#' });
                }

                Boolean andResult_1 = false;

                if (Utils.equals(counter, 0L)) {
                    Boolean orResult_1 = false;

                    if (Utils.equals(counter2, 3L)) {
                        orResult_1 = true;
                    } else {
                        Boolean orResult_2 = false;

                        if (Utils.equals(counter2, 4L)) {
                            orResult_2 = true;
                        } else {
                            Boolean orResult_3 = false;

                            if (Utils.equals(counter2, 7L)) {
                                orResult_3 = true;
                            } else {
                                orResult_3 = Utils.equals(counter2, 8L);
                            }

                            orResult_2 = orResult_3;
                        }

                        orResult_1 = orResult_2;
                    }

                    if (orResult_1) {
                        andResult_1 = true;
                    }
                }

                if (andResult_1) {
                    auxLine = auxLine + new String(new char[] { '#' });
                }

                Boolean andResult_2 = false;

                if (Utils.equals(counter, Y)) {
                    Boolean orResult_4 = false;

                    if (Utils.equals(counter2, 3L)) {
                        orResult_4 = true;
                    } else {
                        Boolean orResult_5 = false;

                        if (Utils.equals(counter2, 4L)) {
                            orResult_5 = true;
                        } else {
                            Boolean orResult_6 = false;

                            if (Utils.equals(counter2, 7L)) {
                                orResult_6 = true;
                            } else {
                                orResult_6 = Utils.equals(counter2, 8L);
                            }

                            orResult_5 = orResult_6;
                        }

                        orResult_4 = orResult_5;
                    }

                    if (orResult_4) {
                        andResult_2 = true;
                    }
                }

                if (andResult_2) {
                    auxLine = auxLine + new String(new char[] { '#' });
                }

                if (Utils.equals(auxLine.length(), counter2)) {
                    auxLine = auxLine + new String(new char[] { ' ' });
                }
            }

            board = SeqUtil.conc(Utils.copy(board), SeqUtil.seq(auxLine));

            auxLine = "";
        }
    }

    public void begin() {
        init();
        pieces = SeqUtil.seq();
        addPiece(2L, 5L, "knight", "black");
        addPiece(3L, 5L, "pawn", "black");
        addPiece(4L, 5L, "pawn", "black");
        addPiece(5L, 5L, "pawn", "black");
        addPiece(6L, 5L, "pawn", "black");
        addPiece(7L, 5L, "pawn", "black");
        addPiece(8L, 5L, "pawn", "black");
        addPiece(9L, 5L, "knight", "black");
        addPiece(3L, 6L, "knight", "black");
        addPiece(4L, 6L, "pawn", "black");
        addPiece(5L, 6L, "pawn", "black");
        addPiece(6L, 6L, "pawn", "black");
        addPiece(7L, 6L, "pawn", "black");
        addPiece(8L, 6L, "knight", "black");
        addPiece(3L, 9L, "knight", "white");
        addPiece(4L, 9L, "pawn", "white");
        addPiece(5L, 9L, "pawn", "white");
        addPiece(6L, 9L, "pawn", "white");
        addPiece(7L, 9L, "pawn", "white");
        addPiece(8L, 9L, "knight", "white");
        addPiece(2L, 10L, "knight", "white");
        addPiece(3L, 10L, "pawn", "white");
        addPiece(4L, 10L, "pawn", "white");
        addPiece(5L, 10L, "pawn", "white");
        addPiece(6L, 10L, "pawn", "white");
        addPiece(7L, 10L, "pawn", "white");
        addPiece(8L, 10L, "pawn", "white");
        addPiece(9L, 10L, "knight", "white");
        updatePieces();
    }

    public void print() {
        VDMSeq auxBoard = Utils.copy(board);
        String auxLine = SeqUtil.toStr(SeqUtil.seq());
        IO.print("\n");

        long toVar_3 = Y.longValue();

        for (Long counter = 0L; counter <= toVar_3; counter++) {
            auxLine = ((String) auxBoard.get(0));

            auxBoard = SeqUtil.tail(Utils.copy(auxBoard));
            IO.print(auxLine);
            IO.print("\n");
        }
    }

    public void changeElement(final Number x, final Number y,
        final Character newElem) {
        VDMSeq auxBoard = SeqUtil.seq();
        VDMSeq auxPreBoard = SeqUtil.seq();
        VDMSeq auxPostBoard = Utils.copy(board);
        String auxLine = SeqUtil.toStr(SeqUtil.seq());
        String auxPreLine = SeqUtil.toStr(SeqUtil.seq());
        String auxPostLine = SeqUtil.toStr(SeqUtil.seq());
        long toVar_4 = y.longValue();

        for (Long counter = 0L; counter <= toVar_4; counter++) {
            if (!(Utils.equals(counter, 0L))) {
                auxPreBoard = SeqUtil.conc(Utils.copy(auxPreBoard),
                        SeqUtil.seq(((String) auxBoard.get(0))));
            }

            auxBoard = SeqUtil.seq(((String) auxPostBoard.get(0)));
            auxPostBoard = SeqUtil.tail(Utils.copy(auxPostBoard));
        }

        auxPostLine = ((String) auxBoard.get(0));

        long toVar_5 = x.longValue();

        for (Long counter = 0L; counter <= toVar_5; counter++) {
            if (!(Utils.equals(counter, 0L))) {
                auxPreLine = auxPreLine +
                    new String(new char[] { auxLine.charAt(0) });
            }

            auxLine = new String(new char[] { auxPostLine.charAt(0) });

            auxPostLine = SeqUtil.tail(auxPostLine);
        }

        auxLine = auxPreLine + new String(new char[] { newElem });

        auxLine = auxLine + auxPostLine;

        auxBoard = SeqUtil.conc(Utils.copy(auxPreBoard), SeqUtil.seq(auxLine));

        auxBoard = SeqUtil.conc(Utils.copy(auxBoard), Utils.copy(auxPostBoard));

        board = Utils.copy(auxBoard);
    }

    public Character getElement(final Number x, final Number y) {
        Character finalElem = '0';
        String auxLine = SeqUtil.toStr(SeqUtil.seq());
        VDMSeq auxBoard = Utils.copy(board);
        long toVar_6 = y.longValue();

        for (Long counter = 0L; counter <= toVar_6; counter++) {
            auxLine = ((String) auxBoard.get(0));

            auxBoard = SeqUtil.tail(Utils.copy(auxBoard));
        }

        long toVar_7 = x.longValue();

        for (Long counter = 0L; counter <= toVar_7; counter++) {
            finalElem = auxLine.charAt(0);

            auxLine = SeqUtil.tail(auxLine);
        }

        return finalElem;
    }

    public Boolean validPieceDestination(final Number x, final Number y) {
        Boolean final_ = true;

        if (Utils.equals(getElement(x, y), '#')) {
            final_ = false;
        }

        Boolean orResult_10 = false;

        if (Utils.equals(getPieceValue(x, y), 'p')) {
            orResult_10 = true;
        } else {
            Boolean orResult_11 = false;

            if (Utils.equals(getPieceValue(x, y), 'P')) {
                orResult_11 = true;
            } else {
                Boolean orResult_12 = false;

                if (Utils.equals(getPieceValue(x, y), 'k')) {
                    orResult_12 = true;
                } else {
                    orResult_12 = Utils.equals(getPieceValue(x, y), 'K');
                }

                orResult_11 = orResult_12;
            }

            orResult_10 = orResult_11;
        }

        if (orResult_10) {
            final_ = false;
        }

        return final_;
    }

    public void addPiece(final Number x, final Number y, final String type,
        final String color) {
        Piece newPiece = new Piece(x, y, type, color);
        pieces = SeqUtil.conc(Utils.copy(pieces), SeqUtil.seq(newPiece));
    }

    public void removePiece(final Number x, final Number y) {
        VDMSeq auxPieces = SeqUtil.seq();
        VDMSeq auxPieces2 = Utils.copy(pieces);

        for (Iterator iterator_1 = pieces.iterator(); iterator_1.hasNext();) {
            Piece piece = (Piece) iterator_1.next();

            {
                Boolean andResult_19 = false;

                if (Utils.equals(piece.getX(), x)) {
                    if (Utils.equals(piece.getY(), y)) {
                        andResult_19 = true;
                    }
                }

                if (andResult_19) {
                    auxPieces2 = SeqUtil.tail(Utils.copy(auxPieces2));
                } else {
                    auxPieces = SeqUtil.conc(Utils.copy(auxPieces),
                            SeqUtil.seq(((Piece) auxPieces2.get(0))));

                    auxPieces2 = SeqUtil.tail(Utils.copy(auxPieces2));
                }
            }
        }

        pieces = Utils.copy(auxPieces);
    }

    public Character getPieceValue(final Number x, final Number y) {
        for (Iterator iterator_2 = pieces.iterator(); iterator_2.hasNext();) {
            Piece piece = (Piece) iterator_2.next();

            {
                Boolean andResult_23 = false;

                if (Utils.equals(piece.getX(), x)) {
                    if (Utils.equals(piece.getY(), y)) {
                        andResult_23 = true;
                    }
                }

                if (andResult_23) {
                    return piece.getPiece();
                }
            }
        }

        return ' ';
    }

    public void movePiece(final Number x1, final Number y1, final Number x2,
        final Number y2) {
        for (Iterator iterator_3 = pieces.iterator(); iterator_3.hasNext();) {
            Piece piece = (Piece) iterator_3.next();

            {
                Boolean andResult_31 = false;

                if (Utils.equals(piece.getX(), x1)) {
                    if (Utils.equals(piece.getY(), y1)) {
                        andResult_31 = true;
                    }
                }

                if (andResult_31) {
                    piece.move(x2, y2);
                }
            }
        }
    }

    public void updatePieces() {
        for (Iterator iterator_4 = pieces.iterator(); iterator_4.hasNext();) {
            Piece piece = (Piece) iterator_4.next();
            changeElement(piece.getX(), piece.getY(), piece.getPiece());
        }
    }

    public Number distance(final Number x1, final Number y1, final Number x2,
        final Number y2) {
        Boolean andResult_41 = false;

        if (Utils.equals(Utils.abs(x2.longValue() - x1.longValue()), 1L)) {
            if (Utils.equals(Utils.abs(y2.longValue() - y1.longValue()), 0L)) {
                andResult_41 = true;
            }
        }

        if (andResult_41) {
            return 1L;
        }

        Boolean andResult_42 = false;

        if (Utils.equals(Utils.abs(x2.longValue() - x1.longValue()), 0L)) {
            if (Utils.equals(Utils.abs(y2.longValue() - y1.longValue()), 1L)) {
                andResult_42 = true;
            }
        }

        if (andResult_42) {
            return 1L;
        }

        Boolean andResult_43 = false;

        if (Utils.equals(Utils.abs(x2.longValue() - x1.longValue()), 1L)) {
            if (Utils.equals(Utils.abs(y2.longValue() - y1.longValue()), 1L)) {
                andResult_43 = true;
            }
        }

        if (andResult_43) {
            return 1L;
        }

        if (Utils.equals(Utils.abs(x2.longValue() - x1.longValue()), 2L)) {
            if (Utils.equals(Utils.abs(y2.longValue() - y1.longValue()), 0L)) {
                return 2L;
            }

            if (Utils.equals(Utils.abs(y2.longValue() - y1.longValue()), 2L)) {
                return 2L;
            }
        }

        if (Utils.equals(Utils.abs(y2.longValue() - y1.longValue()), 2L)) {
            if (Utils.equals(Utils.abs(x2.longValue() - x1.longValue()), 0L)) {
                return 2L;
            }
        }

        return -1L;
    }

    public String move(final String color, final Number x1, final Number y1,
        final Number x2, final Number y2) {
        Number moveDist = distance(x1, y1, x2, y2);
        String moveCondition = null;
        Number canterPiecePosX = x1;
        Number canterPiecePosY = y1;
        Boolean orResult_15 = false;

        if (Utils.equals(getPieceValue(x1, y1), ' ')) {
            orResult_15 = true;
        } else {
            orResult_15 = Utils.equals(getPieceValue(x1, y1), '#');
        }

        if (orResult_15) {
            moveCondition = "invalid";

            return moveCondition;
        }

        if (Utils.equals(moveDist, -1L)) {
            moveCondition = "invalid";
        }

        Boolean andResult_44 = false;

        if (Utils.equals(color, "white")) {
            Boolean orResult_16 = false;

            if (Utils.equals(getPieceValue(x1, y1), 'K')) {
                orResult_16 = true;
            } else {
                orResult_16 = Utils.equals(getPieceValue(x1, y1), 'P');
            }

            if (orResult_16) {
                andResult_44 = true;
            }
        }

        if (andResult_44) {
            moveCondition = "invalid";
        }

        Boolean andResult_45 = false;

        if (Utils.equals(color, "black")) {
            Boolean orResult_17 = false;

            if (Utils.equals(getPieceValue(x1, y1), 'k')) {
                orResult_17 = true;
            } else {
                orResult_17 = Utils.equals(getPieceValue(x1, y1), 'p');
            }

            if (orResult_17) {
                andResult_45 = true;
            }
        }

        if (andResult_45) {
            moveCondition = "invalid";
        }

        if (!(Utils.equals(getPieceValue(x2, y2), ' '))) {
            IO.println("Invalid destination =[");
            moveCondition = "invalid";
        }

        if (Utils.equals(moveDist, 2L)) {
            if (Utils.equals(Utils.abs(x2.longValue() - x1.longValue()), 2L)) {
                canterPiecePosX = Utils.divide((1.0 * (x2.longValue() +
                        x1.longValue())), 2L);
            }

            if (Utils.equals(Utils.abs(y2.longValue() - y1.longValue()), 2L)) {
                canterPiecePosY = Utils.divide((1.0 * (y2.longValue() +
                        y1.longValue())), 2L);
            }

            if (Utils.equals(color, "white")) {
                Boolean orResult_18 = false;

                if (Utils.equals(getPieceValue(canterPiecePosX, canterPiecePosY),
                            'K')) {
                    orResult_18 = true;
                } else {
                    orResult_18 = Utils.equals(getPieceValue(canterPiecePosX,
                                canterPiecePosY), 'P');
                }

                if (orResult_18) {
                    moveCondition = "jump";
                }

                Boolean orResult_19 = false;

                if (Utils.equals(getPieceValue(canterPiecePosX, canterPiecePosY),
                            'k')) {
                    orResult_19 = true;
                } else {
                    orResult_19 = Utils.equals(getPieceValue(canterPiecePosX,
                                canterPiecePosY), 'p');
                }

                if (orResult_19) {
                    moveCondition = "canter";
                }
            }

            if (Utils.equals(color, "black")) {
                Boolean orResult_20 = false;

                if (Utils.equals(getPieceValue(canterPiecePosX, canterPiecePosY),
                            'k')) {
                    orResult_20 = true;
                } else {
                    orResult_20 = Utils.equals(getPieceValue(canterPiecePosX,
                                canterPiecePosY), 'p');
                }

                if (orResult_20) {
                    moveCondition = "jump";
                }

                Boolean orResult_21 = false;

                if (Utils.equals(getPieceValue(canterPiecePosX, canterPiecePosY),
                            'K')) {
                    orResult_21 = true;
                } else {
                    orResult_21 = Utils.equals(getPieceValue(canterPiecePosX,
                                canterPiecePosY), 'P');
                }

                if (orResult_21) {
                    moveCondition = "canter";
                }
            }
        }

        if (Utils.equals(moveDist, 1L)) {
            moveCondition = "plain";
        }

        if (Utils.equals(moveCondition, "jump")) {
            removePiece(canterPiecePosX, canterPiecePosY);
        }

        if (!(Utils.equals(moveCondition, "invalid"))) {
            movePiece(x1, y1, x2, y2);
            init();
            updatePieces();
        }

        return moveCondition;
    }

    public String endCondition() {
        Boolean andResult_46 = false;

        Boolean orResult_22 = false;

        if (Utils.equals(getPieceValue(5L, 0L), 'k')) {
            orResult_22 = true;
        } else {
            orResult_22 = Utils.equals(getPieceValue(5L, 0L), 'p');
        }

        if (orResult_22) {
            Boolean orResult_23 = false;

            if (Utils.equals(getPieceValue(6L, 0L), 'k')) {
                orResult_23 = true;
            } else {
                orResult_23 = Utils.equals(getPieceValue(6L, 0L), 'p');
            }

            if (orResult_23) {
                andResult_46 = true;
            }
        }

        if (andResult_46) {
            return "white";
        }

        Boolean andResult_47 = false;

        Boolean orResult_24 = false;

        if (Utils.equals(getPieceValue(5L, 15L), 'K')) {
            orResult_24 = true;
        } else {
            orResult_24 = Utils.equals(getPieceValue(5L, 15L), 'P');
        }

        if (orResult_24) {
            Boolean orResult_25 = false;

            if (Utils.equals(getPieceValue(6L, 15L), 'K')) {
                orResult_25 = true;
            } else {
                orResult_25 = Utils.equals(getPieceValue(6L, 15L), 'P');
            }

            if (orResult_25) {
                andResult_47 = true;
            }
        }

        if (andResult_47) {
            return "black";
        }

        return "false";
    }

    public String toString() {
        return "Board{" + "board := " + Utils.toString(board) + ", pieces := " +
        Utils.toString(pieces) + ", X = " + Utils.toString(X) + ", Y = " +
        Utils.toString(Y) + "}";
    }
}
