package tictactoe;

import tictactoe.Impl.Game;

import java.util.ArrayList;
import java.util.LinkedList;

import static tictactoe.Impl.GameResult.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        while (game.menuProcessing() != EXIT) {
            game.start();
            game = new Game();
            LinkedList<Integer> list = new LinkedList<>(new ArrayList<>());
        }
    }
}

