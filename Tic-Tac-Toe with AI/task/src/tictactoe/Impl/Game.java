package tictactoe.Impl;

import tictactoe.Player;

import java.util.Scanner;

import static tictactoe.Impl.GameResult.*;
import static tictactoe.Impl.GameResult.NOT_FINISHED;

public class Game {
    Player player1;
    Player player2;
    Field field = new Field();

    Scanner scanner = new Scanner(System.in);

    public GameResult menuProcessing() {
        String userInput;
        String[] arrayUserInput;
        boolean isValid = false;
        do {
            System.out.println("Input command:");
            userInput = scanner.nextLine();
            arrayUserInput = userInput.split(" ");
            if (arrayUserInput.length == 1 && arrayUserInput[0].equals("exit")) return EXIT;
            if (arrayUserInput.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }
            if (!(arrayUserInput[0].equals("start"))) {
                System.out.println("Bad parameters!");
                continue;
            }
            if (arrayUserInput[1].equals("user")) {
                player1 = new User(field, 'X');
            } else if (arrayUserInput[1].equals("easy")) {
                player1 = new AI(field, 'X');
            } else if (arrayUserInput[1].equals("medium")) {
                player1 = new MediumAI(field, 'X');
            } else if (arrayUserInput[1].equals("hard")) {
                player1 = new HardAI(field, 'X');
            } else {
                System.out.println("Bad parameters!");
                continue;
            }
            if (arrayUserInput[2].equals("user")) {
                player2 = new User(field, 'O');
            } else if (arrayUserInput[2].equals("easy")) {
                player2 = new AI(field, 'O');
            } else if (arrayUserInput[2].equals("medium")) {
                player2 = new MediumAI(field, 'O');
            } else if (arrayUserInput[2].equals("hard")) {
                player2 = new HardAI(field, 'O');
            } else {
                System.out.println("Bad parameters!");
                continue;
            }
            isValid = true;

        } while (!isValid);
        return NOT_FINISHED;
    }

    public void start() {
        field.emptyField();
        field.printField();
        GameResult result = field.printResult();
        while (result != XWIN && result != OWIN && result != DRAW) {
            player1.turn();
            field.printField();
            result = field.printResult();
            if (result == NOT_FINISHED) {
                player2.turn();
                field.printField();
                result = field.printResult();
            }
        }
        System.out.println(field.printResult().getMessage());
    }
}
