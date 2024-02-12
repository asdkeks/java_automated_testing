package ru.stqa.pfa.sandbox;

public class CherryPickupIISolution {
    public static int cherryPickup(int[][] grid) {

        return helper(grid,0,0 ) + helper(grid, 0, grid[0].length-1);
    }

    private static int helper(int[][] grid, int i, int j) {
        if ( (j < 0 || j > grid[i].length -1)) return 0;
        int res = grid[i][j];

        if (i <= grid.length-1) {
            res = res + Math.max(helper(grid, i+1, j-1), Math.max(helper(grid, i+1, j), helper(grid, i+1, j+1)));
        }

        return res;

    }
}
