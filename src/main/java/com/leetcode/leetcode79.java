package com.leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class leetcode79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag = HS(board, word, 0, i, j, isVisited);
                if (flag) {
                    return true;
                }
            }
        }
        return flag;
    }


    private boolean HS(char[][] board, String word, int k, int row, int cols, boolean[][] isVisited) {
        if (k >= word.length()) {
            return true;
        }
        if (row >= board.length || cols >= board[0].length || row < 0 || cols < 0
                || isVisited[row][cols] == true) {
            return false;
        }
        char c = word.charAt(k);
        if (board[row][cols] == c) {
            isVisited[row][cols] = true;
            if (HS(board, word, k + 1, row - 1, cols, isVisited) ||
                    HS(board, word, k + 1, row + 1, cols, isVisited) ||
                    HS(board, word, k + 1, row, cols - 1, isVisited) ||
                    HS(board, word, k + 1, row, cols + 1, isVisited)) {
                return true;
            }
            //复原
            isVisited[row][cols] = false;
            return false;

        }
        return false;
    }
}
