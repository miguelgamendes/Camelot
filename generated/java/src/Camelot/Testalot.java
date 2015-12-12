package Camelot;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Testalot {
    public Testalot() {
    }

    protected void assertTrue(final Boolean arg) {
        if (arg) {
            IO.println("true\n");
        }
    }

    protected void assertEqual(final Object expected, final Object actual) {
        if (!(Utils.equals(expected, actual))) {
            IO.print("FAIL : Actual value (");
            IO.print(((Object) actual));
            IO.print(") different from expected (");
            IO.print(((Object) expected));
            IO.println(")\n");
        } else {
            IO.println("SUCCESS");
        }
    }

    public String toString() {
        return "Testalot{}";
    }
}
