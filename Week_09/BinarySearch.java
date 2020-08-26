/**
 * 二分查找框架
 */
public class BinarySearch {

//    int binarySearch(int[] nums, int target) {
//        int left = 0, right = ...;
//
//        while(...) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//            ...
//            } else if (nums[mid] < target) {
//                left = ...
//            } else if (nums[mid] > target) {
//                right = ...
//            }
//        }
//        return ...;
//    }

    /**
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {//原因 right=nums.length-1; 所以<=
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
