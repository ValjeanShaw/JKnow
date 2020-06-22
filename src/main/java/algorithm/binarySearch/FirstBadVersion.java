package algorithm.binarySearch;

/**
 * @author xiaoran
 * @date 2020/06/22
 */
public class FirstBadVersion {

    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid) == true) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 示例程序
     *
     * @param version
     * @return
     */
    boolean isBadVersion(int version) {
        return true;
    }
}
