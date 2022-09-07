package tictactoe.Impl;

import static tictactoe.Impl.GameResult.*;

public class Field {
    public char[][] getField() {
        return field;
    }

    private char[][] field = new char[3][3];
    public char getFigure(int col, int row) {
        return field[col][row];
    }
    public void setFigure(int col, int row, char figure) {
        field[col][row] = figure;
    }
    public void emptyField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';

            }
        }
    }

    public void printField() {
        System.out.println("---------");
        for (int i = 0; i < field.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public GameResult printResult() {
        for (int i = 0; i < 3; i++) {
            if (field[0][i] + field[1][i] + field[2][i] == 264) {
                return XWIN;
            }
            if (field[0][i] + field[1][i] + field[2][i] == 237) {
                return OWIN;
            }
            if (field[i][0] + field[i][1] + field[i][2] == 264) {
                return XWIN;
            }
            if (field[i][0] + field[i][1] + field[i][2] == 237) {
                return OWIN;
            }
        }
        if (field[0][0] + field[1][1] + field[2][2] == 264
                || field[0][2] + field[1][1] + field[2][0] == 264) {
            return XWIN;
        }
        if (field[0][0] + field[1][1] + field[2][2] == 237
                || field[0][2] + field[1][1] + field[2][0] == 237) {
            return OWIN;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == ' ') {
                    return NOT_FINISHED;
                }
            }
        }
        return DRAW;
    }
}