package tictactoe.Impl;

import tictactoe.Player;
import java.util.Random;

public class MediumAI extends Player {

    public MediumAI(Field field, char figure) {
        this.field = field;
        this.figure = figure;
    }

    @Override
    public void turn() {
        System.out.println("Making move level \"medium\"");
        if (!moveIfCombination()) randomMove();
    }

    public void randomMove() {
        Random random = new Random();
        while (true) {
            int col = random.nextInt(3);
            int row = random.nextInt(3);
            if (field.getFigure(col, row) == ' ') {
                field.setFigure(col, row, figure);
                break;
            }
        }
    }

    public boolean moveIfCombination() {
        int counterX = 0;
        int counterO = 0;
        int counterSpace = 0;
        Coordinates coordinatesSpace = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.getField()[i][j] == 'X') {
                    counterX++;
                }
                if (field.getField()[i][j] == 'O') {
                    counterO++;
                }
                if (field.getField()[i][j] == ' ') {
                    counterSpace++;
                    coordinatesSpace = new Coordinates(i+1, j+1);
                }
            }
            if (counterSpace == 1) {
                if (counterO == 2 || counterX == 2) {
                    field.setFigure(coordinatesSpace.getY(), coordinatesSpace.getX(), figure);
                    return true;
                }
            }
                counterX = 0;
                counterO = 0;
                counterSpace = 0;
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (field.getField()[i][j] == 'X') {
                    counterX++;
                }
                if (field.getField()[i][j] == 'O') {
                    counterO++;
                }
                if (field.getField()[i][j] == ' ') {
                    counterSpace++;
                    coordinatesSpace = new Coordinates(i+1, j+1);
                }
            }
            if (counterSpace == 1) {
                if (counterO == 2 || counterX == 2) {
                    field.setFigure(coordinatesSpace.getY(), coordinatesSpace.getX(), figure);
                    return true;
                }
            }
                counterX = 0;
                counterO = 0;
                counterSpace = 0;

        }

        for (int i = 0; i < 3; i++) {
            if (field.getField()[i][i] == 'X') {
                counterX++;
            } else if (field.getField()[i][i] == 'O') {
                counterO++;
            } else {
                counterSpace++;
                coordinatesSpace = new Coordinates(i+1, i+1);
            }
        }
        if (counterSpace == 1) {
            if (counterO == 2 || counterX == 2) {
                field.setFigure(coordinatesSpace.getY(), coordinatesSpace.getX(), figure);
                return true;
            }
        }
            counterX = 0;
            counterO = 0;
            counterSpace = 0;

        for (int i = 0; i < 3; i++) {
            if (field.getField()[i][2 - i] == 'X') {
                counterX++;
            } else if (field.getField()[i][2 - i] == 'O') {
                counterO++;
            } else {
                counterSpace++;
                coordinatesSpace = new Coordinates(i + 1, 3-i);
            }
        }
        if (counterSpace == 1) {
            if (counterO == 2 || counterX == 2) {
                field.setFigure(coordinatesSpace.getY(), coordinatesSpace.getX(), figure);
                return true;
            }
        }
        return false;
    }
}