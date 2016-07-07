package test;

import javax.swing.*;

/**
 * Created by ANTON on 06.07.2016.
 */
public class ComputerPlayer {

    GameField gameField;

    void computerMove() {
        int selectedSquare;

        // Сначала компьютер пытается найти пустую клетку
        // рядом с двумя клетками с ноликами, чтобы выиграть

        selectedSquare = findEmptySquare("O");

        // Если он не может найти два нолика, то хотя бы
        // попытается не дать оппоненту сделать ряд из 3-х
        // крестиков,поместив нолик рядом с двумя крестиками

        if (selectedSquare == -1) {
            selectedSquare = findEmptySquare("X");
        }
        // если selectedSquare все еще равен -1, то
        // попытается занять центральную клетку

        if ((selectedSquare == -1) && (gameField.squares[4].getText().equals(""))) {
            selectedSquare = 4;
        }

        // не повезло с центральной клеткой...
        // просто занимаем случайную клетку

        if (selectedSquare == -1) {
            selectedSquare = getRandomSquare();
        }
        gameField.squares[selectedSquare].setText("O");
        gameField.squares[selectedSquare].setEnabled(false);
    }

    int findEmptySquare(String player) {

        int weight[] = new int[gameField.squares.length];
        for (int i = 0; i < gameField.squares.length; i++) {
            if (gameField.squares[i].getText().equals("O")) weight[i] = -1;
            else if (gameField.squares[i].getText().equals("X")) weight[i] = 1;
            else weight[i] = 0;
        }
        int twoWeights = player.equals("O") ? -2 : 2;

        // Проверим, есть ли в ряду 1 две одинаковые клетки и
        // одна пустая.

        if (weight[0] + weight[1] + weight[2] == twoWeights) {
            if (weight[0] == 0) return 0;
            else if (weight[1] == 0) return 1;
            else return 2;
        }
        // Проверим, есть ли в ряду 2 две одинаковые клетки и
        // одна пустая.

        if (weight[3] + weight[4] + weight[5] == twoWeights) {
            if (weight[3] == 0) return 3;
            else if (weight[4] == 0) return 4;
            else return 5;
        }

        // Проверим, есть ли в ряду 3 две одинаковые клетки и
        // одна пустая.

        if (weight[6] + weight[7] + weight[8] == twoWeights) {
            if (weight[6] == 0) return 6;
            else if (weight[7] == 0) return 7;
            else return 8;
        }

        // Проверим, есть ли в колонке 1 две одинаковые клетки и
        // одна пустая.
        if (weight[0] + weight[3] + weight[6] == twoWeights) {
            if (weight[0] == 0) return 0;
            else if (weight[3] == 0) return 3;
            else return 6;
        }

        // Проверим, есть ли в колонке 2 две одинаковые клетки
        // и одна пустая.
        if (weight[1] + weight[4] + weight[7] == twoWeights) {
            if (weight[1] == 0) return 1;
            else if (weight[4] == 0) return 4;
            else return 7;
        }

        // Проверим, есть ли в колонке 3 две одинаковые клетки
        // и одна пустая.

        if (weight[2] + weight[5] + weight[8] == twoWeights) {
            if (weight[2] == 0) return 2;
            else if (weight[5] == 0) return 5;
            else return 8;
        }

        // Проверим, есть ли в диагонали 1 две одинаковые клетки
        // и одна пустая.
        if (weight[0] + weight[4] + weight[8] == twoWeights) {
            if (weight[0] == 0) return 0;
            else if (weight[4] == 0) return 4;
            else return 8;
        }

        // Проверим, есть ли в диагонали 2 две одинаковые клетки
        // и одна пустая.

        if (weight[2] + weight[4] + weight[6] == twoWeights) {
            if (weight[2] == 0) return 2;
            else if (weight[4] == 0) return 4;
            else return 6;
        }

        // Не найдено двух одинаковых соседних клеток
        return -1;
    }

    int getRandomSquare() {
        boolean gotEmptySquare = false;
        int selectedSquare = -1;
        do {
            selectedSquare = (int) (Math.random() * gameField.squares.length);
            if (gameField.squares[selectedSquare].getText().equals("")) {
                gotEmptySquare = true; // чтобы закончить цикл
            }
        } while (!gotEmptySquare);
        return selectedSquare;
    }
}
