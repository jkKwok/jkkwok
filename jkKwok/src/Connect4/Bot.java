/*
 * Copyright (C) 2015 JunKiat
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Connect4;

/**
 *
 * @author JunKiat
 *
 * Authors Note - Important READ ME
 *
 * Pre-condition: Grid contains only 3 types of values: -1 Opponents piece 0
 * Empty square 1 Players piece
 */
public class Bot {

    public int[] jkBot(int[][] grid) {
        int[] move;
        if (!gg(grid)) {
            move = forceMove(grid);
            if (move[0] != -1) {
                return move;
            }else{
                //THINK ABOUT IT
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] forceMove(int[][] grid) {
        int size = grid.length;
        int[] sum = new int[3];
        for (int i = 0; i < size - 3; i++) {
            for (int j = 0; j < size - 3; j++) {
                sum[0] = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i][j + 3];
                sum[1] = grid[i][j] + grid[i + 1][j] + grid[i + 2][j] + grid[i + 3][j];
                sum[2] = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] + grid[i + 3][j + 3];
                if (sum[0] == 3) {
                    for (int k = 0; k < 4; k++) {
                        if (grid[i][j + k] == 0) {
                            return new int[]{i, j + k};
                        }
                    }
                }
                if (sum[1] == 3) {
                    for (int k = 0; k < 4; k++) {
                        if (grid[i + k][j] == 0) {
                            return new int[]{i + k, j};
                        }
                    }
                }
                if (sum[2] == 3) {
                    for (int k = 0; k < 4; k++) {
                        if (grid[i + k][j + k] == 0) {
                            return new int[]{i + k, j + k};
                        }
                    }
                }
                if (sum[0] == -3) {
                    for (int k = 0; k < 4; k++) {
                        if (grid[i][j + k] == 0) {
                            return new int[]{i, j + k};
                        }
                    }
                }
                if (sum[1] == -3) {
                    for (int k = 0; k < 4; k++) {
                        if (grid[i + k][j] == 0) {
                            return new int[]{i + k, j};
                        }
                    }
                }
                if (sum[2] == -3) {
                    for (int k = 0; k < 4; k++) {
                        if (grid[i + k][j + k] == 0) {
                            return new int[]{i + k, j + k};
                        }
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static boolean gg(int[][] grid) {
        int size = grid.length;
        int sum;
        for (int i = 0; i < size - 3; i++) {
            for (int j = 0; j < size - 3; j++) {
                sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i][j + 3];
                if (sum == 4) {
                    return true;
                }
                sum = grid[i][j] + grid[i + 1][j] + grid[i + 2][j] + grid[i + 3][j];
                if (sum == 4) {
                    return true;
                }
                sum = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] + grid[i + 3][j + 3];
                if (sum == 4) {
                    return true;
                }
            }
        }
        return false;
    }
}
