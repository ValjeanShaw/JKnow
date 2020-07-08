package algorithm.offer;

/**
 * @author xiaoran
 * @date 2020/07/08
 */
public class MaxValue {

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int high = grid.length;
        int len = grid[0].length;

        int value[][] = new int[high][len];

        value[0][0] = grid[0][0];
        for (int i = 1; i < len; i++) {
            value[0][i] = value[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < high; i++) {
            value[i][0] = value[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < high; i++) {
            for (int j = 1; j < len; j++) {
                int temp = value[i][j - 1] > value[i - 1][j] ? value[i][j - 1] : value[i - 1][j];
                value[i][j] =grid[i][j]+ temp;
            }
        }

        return value[high-1][len-1];
    }
}
