package Camelot;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class TestGame extends Testalot {
    public TestGame() {
    }

    public void test() {
        testBoard();
        testPiece();
        testPieceMove();
        testPieceAddition();
        testPieceRemoval();
        testBoardInit();
        testBoardPieceMove();
        testPlainMove();
        testCanterMove();
        testJumpMove();
    }

    public void testBoard() {
        Board board = new Board();
        super.assertEqual('#', board.getElement(0L, 0L));
        super.assertEqual('#', board.getElement(1L, 0L));
        super.assertEqual('#', board.getElement(2L, 0L));
        super.assertEqual('#', board.getElement(0L, 1L));
        super.assertEqual('#', board.getElement(1L, 1L));
        super.assertEqual('#', board.getElement(0L, 2L));
        super.assertEqual('#', board.getElement(9L, 0L));
        super.assertEqual('#', board.getElement(10L, 0L));
        super.assertEqual('#', board.getElement(11L, 0L));
        super.assertEqual('#', board.getElement(10L, 1L));
        super.assertEqual('#', board.getElement(11L, 1L));
        super.assertEqual('#', board.getElement(11L, 2L));
        super.assertEqual('#', board.getElement(0L, 15L));
        super.assertEqual('#', board.getElement(1L, 15L));
        super.assertEqual('#', board.getElement(2L, 15L));
        super.assertEqual('#', board.getElement(0L, 14L));
        super.assertEqual('#', board.getElement(1L, 14L));
        super.assertEqual('#', board.getElement(0L, 13L));
        super.assertEqual('#', board.getElement(9L, 15L));
        super.assertEqual('#', board.getElement(10L, 15L));
        super.assertEqual('#', board.getElement(11L, 15L));
        super.assertEqual('#', board.getElement(10L, 14L));
        super.assertEqual('#', board.getElement(11L, 14L));
        super.assertEqual('#', board.getElement(11L, 13L));
        board.print();
    }

    public void testPiece() {
        Piece piece = new Piece(1L, 2L, "pawn", "black");
        Piece piece2 = new Piece(2L, 2L, "pawn", "white");
        Piece piece3 = new Piece(3L, 4L, "knight", "black");
        Piece piece4 = new Piece(4L, 4L, "knight", "white");
        super.assertEqual(1L, piece.getX());
        super.assertEqual(2L, piece.getY());
        super.assertEqual('P', piece.getPiece());
        super.assertEqual(2L, piece2.getX());
        super.assertEqual(2L, piece2.getY());
        super.assertEqual('p', piece2.getPiece());
        super.assertEqual(3L, piece3.getX());
        super.assertEqual(4L, piece3.getY());
        super.assertEqual('K', piece3.getPiece());
        super.assertEqual(4L, piece4.getX());
        super.assertEqual(4L, piece4.getY());
        super.assertEqual('k', piece4.getPiece());
    }

    public void testPieceMove() {
        Piece piece = new Piece(5L, 5L, "pawn", "white");
        piece.move(10L, 5L);
        super.assertEqual(10L, piece.getX());
        super.assertEqual(5L, piece.getY());
    }

    public void testPieceAddition() {
        Board board = new Board();
        super.assertEqual(' ', board.getPieceValue(5L, 5L));
        board.addPiece(5L, 5L, "pawn", "white");
        super.assertEqual('p', board.getPieceValue(5L, 5L));
        super.assertEqual(' ', board.getPieceValue(5L, 10L));
        board.addPiece(5L, 10L, "pawn", "black");
        super.assertEqual('P', board.getPieceValue(5L, 10L));
        super.assertEqual(' ', board.getPieceValue(8L, 5L));
        board.addPiece(8L, 5L, "knight", "white");
        super.assertEqual('k', board.getPieceValue(8L, 5L));
        super.assertEqual(' ', board.getPieceValue(8L, 10L));
        board.addPiece(8L, 10L, "knight", "black");
        super.assertEqual('K', board.getPieceValue(8L, 10L));
        board.updatePieces();
        board.print();
    }

    public void testPieceRemoval() {
        Board board = new Board();
        board.addPiece(5L, 5L, "pawn", "white");
        super.assertEqual('p', board.getPieceValue(5L, 5L));
        board.removePiece(5L, 5L);
        super.assertEqual(' ', board.getPieceValue(5L, 5L));
        board.updatePieces();
        board.print();
    }

    public void testBoardInit() {
        Board board = new Board();
        board.begin();
        super.assertEqual('K', board.getPieceValue(2L, 5L));
        super.assertEqual('P', board.getPieceValue(3L, 5L));
        super.assertEqual('P', board.getPieceValue(4L, 5L));
        super.assertEqual('P', board.getPieceValue(5L, 5L));
        super.assertEqual('P', board.getPieceValue(6L, 5L));
        super.assertEqual('P', board.getPieceValue(7L, 5L));
        super.assertEqual('P', board.getPieceValue(8L, 5L));
        super.assertEqual('K', board.getPieceValue(9L, 5L));
        super.assertEqual('K', board.getPieceValue(3L, 6L));
        super.assertEqual('P', board.getPieceValue(4L, 6L));
        super.assertEqual('P', board.getPieceValue(5L, 6L));
        super.assertEqual('P', board.getPieceValue(6L, 6L));
        super.assertEqual('P', board.getPieceValue(7L, 6L));
        super.assertEqual('K', board.getPieceValue(8L, 6L));
        super.assertEqual('k', board.getPieceValue(3L, 9L));
        super.assertEqual('p', board.getPieceValue(4L, 9L));
        super.assertEqual('p', board.getPieceValue(5L, 9L));
        super.assertEqual('p', board.getPieceValue(6L, 9L));
        super.assertEqual('p', board.getPieceValue(7L, 9L));
        super.assertEqual('k', board.getPieceValue(8L, 9L));
        super.assertEqual('k', board.getPieceValue(2L, 10L));
        super.assertEqual('p', board.getPieceValue(3L, 10L));
        super.assertEqual('p', board.getPieceValue(4L, 10L));
        super.assertEqual('p', board.getPieceValue(5L, 10L));
        super.assertEqual('p', board.getPieceValue(6L, 10L));
        super.assertEqual('p', board.getPieceValue(7L, 10L));
        super.assertEqual('p', board.getPieceValue(8L, 10L));
        super.assertEqual('k', board.getPieceValue(9L, 10L));
        board.updatePieces();
        board.print();
    }

    public void testBoardPieceMove() {
        Board board = new Board();
        board.addPiece(3L, 3L, "pawn", "white");
        board.addPiece(5L, 3L, "knight", "black");
        board.addPiece(4L, 5L, "knight", "white");
        board.movePiece(3L, 3L, 5L, 5L);
        super.assertEqual('p', board.getPieceValue(5L, 5L));
        board.movePiece(5L, 3L, 3L, 5L);
        super.assertEqual('K', board.getPieceValue(3L, 5L));
        board.movePiece(4L, 5L, 4L, 3L);
        super.assertEqual('k', board.getPieceValue(4L, 3L));
    }

    public void testPlainMove() {
        Board board = new Board();
        board.addPiece(5L, 5L, "pawn", "white");
        super.assertEqual("plain", board.move("white", 5L, 5L, 6L, 5L));
        super.assertEqual(' ', board.getPieceValue(5L, 5L));
        super.assertEqual('p', board.getPieceValue(6L, 5L));
        super.assertEqual("plain", board.move("white", 6L, 5L, 6L, 6L));
        super.assertEqual(' ', board.getPieceValue(6L, 5L));
        super.assertEqual('p', board.getPieceValue(6L, 6L));
        super.assertEqual("plain", board.move("white", 6L, 6L, 5L, 6L));
        super.assertEqual(' ', board.getPieceValue(6L, 6L));
        super.assertEqual('p', board.getPieceValue(5L, 6L));
        super.assertEqual("plain", board.move("white", 5L, 6L, 5L, 5L));
        super.assertEqual(' ', board.getPieceValue(5L, 6L));
        super.assertEqual('p', board.getPieceValue(5L, 5L));
        board.updatePieces();
        board.print();
    }

    public void testCanterMove() {
        Board board = new Board();
        board.addPiece(5L, 5L, "pawn", "white");
        board.addPiece(6L, 5L, "knight", "white");
        board.addPiece(8L, 4L, "pawn", "white");
        super.assertEqual("canter", board.move("white", 5L, 5L, 7L, 5L));
        super.assertEqual(' ', board.getPieceValue(5L, 5L));
        super.assertEqual('p', board.getPieceValue(7L, 5L));
        super.assertEqual("canter", board.move("white", 6L, 5L, 8L, 5L));
        super.assertEqual(' ', board.getPieceValue(6L, 5L));
        super.assertEqual('k', board.getPieceValue(8L, 5L));
        super.assertEqual("canter", board.move("white", 8L, 4L, 8L, 6L));
        super.assertEqual(' ', board.getPieceValue(8L, 4L));
        super.assertEqual('p', board.getPieceValue(8L, 6L));
        super.assertEqual("canter", board.move("white", 8L, 6L, 8L, 4L));
        super.assertEqual(' ', board.getPieceValue(8L, 6L));
        super.assertEqual('p', board.getPieceValue(8L, 4L));
        super.assertEqual("canter", board.move("white", 8L, 5L, 6L, 5L));
        super.assertEqual(' ', board.getPieceValue(8L, 5L));
        super.assertEqual('k', board.getPieceValue(6L, 5L));
        board.updatePieces();
        board.print();
    }

    public void testJumpMove() {
        Board board = new Board();
        board.addPiece(5L, 5L, "pawn", "white");
        board.addPiece(6L, 5L, "knight", "black");
        super.assertEqual("jump", board.move("white", 5L, 5L, 7L, 5L));
        super.assertEqual(' ', board.getPieceValue(5L, 5L));
        super.assertEqual(' ', board.getPieceValue(6L, 5L));
        super.assertEqual('p', board.getPieceValue(7L, 5L));
        board.addPiece(6L, 5L, "knight", "black");
        super.assertEqual("jump", board.move("white", 7L, 5L, 5L, 5L));
        super.assertEqual(' ', board.getPieceValue(7L, 5L));
        super.assertEqual(' ', board.getPieceValue(6L, 5L));
        super.assertEqual('p', board.getPieceValue(5L, 5L));
        board.addPiece(5L, 6L, "knight", "black");
        super.assertEqual("jump", board.move("white", 5L, 5L, 5L, 7L));
        super.assertEqual(' ', board.getPieceValue(5L, 5L));
        super.assertEqual(' ', board.getPieceValue(5L, 6L));
        super.assertEqual('p', board.getPieceValue(5L, 7L));
        board.addPiece(5L, 6L, "knight", "black");
        super.assertEqual("jump", board.move("white", 5L, 7L, 5L, 5L));
        super.assertEqual(' ', board.getPieceValue(5L, 7L));
        super.assertEqual(' ', board.getPieceValue(5L, 6L));
        super.assertEqual('p', board.getPieceValue(5L, 5L));
        board.updatePieces();
        board.print();
    }

    public void testInvalidPiece() {
        Piece piece = new Piece(5L, 5L, "pawn", "green");

        return;
    }

    public void testInvalidElement() {
        Board board = new Board();
        board.changeElement(5L, 5L, 'S');
    }

    public void testInvalidAddPiece() {
        Board board = new Board();
        board.addPiece(-1L, 5L, "pawn", "white");
    }

    public String toString() {
        return "TestGame{}";
    }
}
