package org.example.lesson_03.task1;

public class Game {
    private String currentAction;
    private Player first;
    private Player second;

    public Game(Player first, Player second) {
        this.currentAction = "";
        this.first = first;
        this.second = second;
        if (first.getMove().equals(second.getMove())) {
            first.setMove(first.getMove()+".first");
            second.setMove(second.getMove()+".second");
        }
    }

    public synchronized void firstPlayerMove() {
        while (!currentAction.equals(second.getMove())  && !currentAction.equals("")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentAction = first.getMove();
        System.out.println(currentAction);
        notifyAll();
    }

    public synchronized void secondPlayerMove() {
        while (!currentAction.equals(first.getMove())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentAction = second.getMove();
        System.out.println(currentAction);
        notifyAll();
    }
}
