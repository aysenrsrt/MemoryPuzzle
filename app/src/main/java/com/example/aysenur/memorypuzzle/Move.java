package com.example.aysenur.memorypuzzle;

public class Move {

    private String date;
    private String level;
    private int move;

    public Move(){

    }

    public Move(String date, String level, int move){
        this.date = date;
        this.level = level;
        this.move = move;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
