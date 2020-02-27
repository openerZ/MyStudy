package com.leetcode;


/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * 一个数独。
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */
public class leetcode37 {

    public void solveSudoku(char[][] board) {
        //每行出现过的数字
        boolean[][] rowB = new boolean[9][10];
        //没列出现过的数字
        boolean[][] colsB = new boolean[9][10];
        //每个小数独出现过的数字
        boolean[][][] boxB = new boolean[3][3][10];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='.')continue;
                int c = board[i][j]-'0';
                rowB[i][c] = true;
                colsB[j][c] = true;
                boxB[i / 3][j / 3][c] = true;
            }
        }
        recusiveSolveSudoku(board, rowB, colsB, boxB, 0, 0);
    }


    /**
     * 回溯递归，每一个'.'都尝试一遍
     * @return
     */
    private boolean recusiveSolveSudoku(char[][] board, boolean[][] rowB, boolean[][] colsB,
                                        boolean[][][] boxB, int row, int cols) {
        if (cols == board[0].length) {
            //换行列从头开始
            row++;
            cols = 0;
            //如果行已经是最后一行
            if (row == board.length) {
                return true;
            }
        }
        if (board[row][cols] == '.') {
            for (int i = 1; i < 10; i++) {
                boolean haseUse = rowB[row][i] || colsB[cols][i] || boxB[row / 3][cols / 3][i];
                //都满足
                if (!haseUse) {
                    board[row][cols] = (char) (i + '0');
                    rowB[row][i] = true;
                    colsB[cols][i] = true;
                    boxB[row / 3][cols / 3][i] = true;
                    boolean b = recusiveSolveSudoku(board, rowB, colsB, boxB, row, cols + 1);
                    if (b) {
                        return true;
                    } else { //回溯复原
                        board[row][cols] = '.';
                        rowB[row][i] = false;
                        colsB[cols][i] = false;
                        boxB[row / 3][cols / 3][i] = false;
                    }
                }
            }
            return false;
        } else {
            return recusiveSolveSudoku(board, rowB, colsB, boxB, row, cols + 1);
        }
    }


}
