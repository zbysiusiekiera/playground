package org.jakubplayground.hashmapsandsets;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return isValidSudokuRows(board) && isValidSudokuColumns(board) && isValidSudokuSubBoxes(board);
    }

    private boolean isValidSudokuSubBoxes(char[][] board) {

        return isValidSudokuSubBox(board, 0, 0) &&
                isValidSudokuSubBox(board, 0, 3) &&
                isValidSudokuSubBox(board, 0, 6) &&
                isValidSudokuSubBox(board, 3, 0) &&
                isValidSudokuSubBox(board, 3, 3) &&
                isValidSudokuSubBox(board, 3, 6) &&
                isValidSudokuSubBox(board, 6, 0) &&
                isValidSudokuSubBox(board, 6, 3) &&
                isValidSudokuSubBox(board, 6, 6);
    }

    private boolean isValidSudokuSubBox(char[][] board, int x, int y) {
        char[] values = new char[]{
                board[x][y],
                board[x][y + 1],
                board[x][y + 2],
                board[x + 1][y],
                board[x + 1][y + 1],
                board[x + 1][y + 2],
                board[x + 2][y],
                board[x + 2][y + 1],
                board[x + 2][y + 2],
        };

        return !isInvalidSudokuValues(values);
    }

    private boolean isValidSudokuColumns(char[][] board) {
        for (int column = 0; column < board.length; column++) {
            char[] columnValues = new char[]{
                    board[0][column],
                    board[1][column],
                    board[2][column],
                    board[3][column],
                    board[4][column],
                    board[5][column],
                    board[6][column],
                    board[7][column],
                    board[8][column],
            };
            if (isInvalidSudokuValues(columnValues)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidSudokuRows(char[][] board) {
        for (char[] rowValues : board) {
            if (isInvalidSudokuValues(rowValues)) {
                return false;
            }
        }

        return true;
    }

    private boolean isInvalidSudokuValues(char[] values) {
        Set<Character> seenValues = new HashSet<>();

        for (char c : values) {
            if (c == '.') {
                continue;
            }

            if (seenValues.contains(c)) {
                return true;
            }

            seenValues.add(c);
        }

        return false;
    }
}
