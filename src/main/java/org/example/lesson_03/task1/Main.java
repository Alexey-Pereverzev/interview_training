package org.example.lesson_03.task1;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Player("ping"), new Player("pong"));

        int numberOfMoves = 100;

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < numberOfMoves; i++) {
                game.firstPlayerMove();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < numberOfMoves; i++) {
                game.secondPlayerMove();
            }
        });
        t2.start();
    }
}
