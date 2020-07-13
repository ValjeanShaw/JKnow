package algorithm.offer;

/**
 * @author xiaoran
 * @date 2020/07/13
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};


        SearchMatrix sm = new SearchMatrix();
        System.out.println(sm.searchMatrix(matrix,5));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return false;
        }

        int high = matrix.length - 1;
        int len = matrix[0].length - 1;

        for (int i = high; i >= 0; i--) {
            if (matrix[i][0] <= target) {
                for (int j = 0; j <= len; j++) {
                    if(matrix[i][j]==target){
                        return true;
                    }
                    if(matrix[i][j]>target){
                        continue;
                    }
                }
            }
        }
        return false;
    }
}
