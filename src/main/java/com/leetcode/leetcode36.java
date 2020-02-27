package com.leetcode;

import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 上图是一个部分填充的有效的数独。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 示例 1:
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 */
public class leetcode36 {

    public boolean isValidSudoku(char[][] board) {
        if (board==null ||board.length==0) return true;
        return rowSD(board, 0) && colsSD(board, 0) && nineSD(board, 0, 0);
    }

    private boolean rowSD(char[][] board, int row) {
        if (row == board.length) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == '.') continue;

            if (map.containsKey(board[row][i])) {
                return false;
            } else {
                map.put(board[row][i], 1);
            }
        }
        return rowSD(board, row + 1);
    }

    private boolean colsSD(char[][] board, int cols) {
        if (cols == board[0].length) return true;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][cols] == '.') continue;
            if (map.containsKey(board[i][cols])) {
                return false;
            } else {
                map.put(board[i][cols], 1);
            }
        }
        return colsSD(board, cols + 1);
    }

    private boolean nineSD(char[][] board, int rows, int cols) {
        if (rows == board.length || cols == board[0].length) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = rows; i < rows + 3; i++) {
            for (int j = cols; j < cols + 3; j++) {
                if (board[i][j] == '.') continue;
                if (map.containsKey(board[i][j])) {
                    return false;
                } else {
                    map.put(board[i][j], 1);
                }
            }
        }
        if ((cols+3)==board[0].length){
            return nineSD(board, rows+3 , 0);
        }
        return nineSD(board,rows,cols+3);

    }


    public boolean isValidSudoku1(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    //下标从0开始算的，所以减的是1
                    int num = board[i][j] - '1';
                    //计算第几个方阵数独
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
