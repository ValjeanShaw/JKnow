package algorithm.dp;

/**
 *
 * leetcode 不同路径2  63
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @author xiaoran
 * @date 2020/05/21
 */
public class RobotRoute2 {

    public static void main(String[] args) {
        RobotRoute2 robotRoute2 = new RobotRoute2();
        int[][] arr = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(robotRoute2.uniquePathsWithObstacles(arr));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        //定义dp数组   此处使用原数组来操作 用数字记录路径条数

        //初始值 边界值为1  区别在于如果有障碍点，后续路径均为0
        int row = obstacleGrid.length;
        int line = obstacleGrid[0].length;

        //初始值为 1 那么Wie
        if(obstacleGrid[0][0] == 1){
            return 0;
        }else{
            obstacleGrid[0][0] = 1;
        }

        //标记障碍点后续的点都该为0
        boolean flag = true;
        for(int i=1;i<row;i++){
            if(obstacleGrid[i][0] == 0 && flag){
                obstacleGrid[i][0] = 1;
            }else{
                obstacleGrid[i][0] = 0;
                flag = false;
            }
        }
        flag = true;
        for(int i=1;i<line;i++){
            if(obstacleGrid[0][i] == 0 && flag){
                obstacleGrid[0][i] = 1;
            }else{
                obstacleGrid[0][i] = 0;
                flag = false;
            }
        }


        //转换方程
        for(int i=1;i<row;i++){
            for(int j=1;j<line;j++){
                if(obstacleGrid[i][j]==0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }else{
                    //障碍点，路径为0
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[row-1][line-1];
    }
}
