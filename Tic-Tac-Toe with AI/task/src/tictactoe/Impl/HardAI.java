package tictactoe.Impl;

import tictactoe.Player;
import java.util.HashMap;

class HardAI extends Player {
    private static final int FIRST_MOVE_DONE = 1;
    HashMap<GameResult, Integer> scores = new HashMap<>();
    char opponentFigure;
    int firstMove;

    public HardAI(Field field, char figure) {
        this.field = field;
        this.figure = figure;
        if (figure == 'X') {
            firstMove = 0;
            opponentFigure = 'O';
            scores.put(GameResult.XWIN, 10);
            scores.put(GameResult.OWIN, -10);
        } else {
            firstMove = FIRST_MOVE_DONE;
            opponentFigure = 'X';
            scores.put(GameResult.OWIN, 10);
            scores.put(GameResult.XWIN, -10);
        }
        scores.put(GameResult.DRAW, 0);
    }

    @Override
    public void turn() {
        System.out.println("Making move level \"hard\"");
            bestMove();
    }

    public void bestMove() {
        if (field.getField()[1][1] == ' ') {
            field.setFigure(1, 1, figure);
            return;
        }
        int bestScore = Integer.MIN_VALUE;
        int[] move = {0, 0};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.getFigure(i, j) == ' ') {
                    field.setFigure(i, j, figure);
                    int score = minimax( 0, false);
                    field.setFigure(i, j, ' ');
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        field.setFigure(move[0], move[1], figure);
    }

    public int minimax( int depth, boolean isMaximizing) {
        GameResult result = field.printResult();
        if (result != GameResult.NOT_FINISHED) {
            return scores.get(result);
        }
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field.getFigure(i, j) == ' ') {
                        field.setFigure(i, j, figure);
                        int score = minimax( depth + 1, false);
                        field.setFigure(i, j, ' ');
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field.getFigure(i, j) == ' ') {
                        field.setFigure(i, j, opponentFigure);
                        int score = minimax(depth + 1, true);
                        field.setFigure(i, j, ' ');
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}
