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
            //int mid = left + (right - left) / 2;
            int mid = left + ((right - left) >> 1);
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

    /**
     * 二分查找的递归实现
     *
     * @param a
     * @param n
     * @param val
     * @return
     */
    public int bsearchI(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }


    /**
     * @param a
     * @param low
     * @param high
     * @param val
     * @return
     */
    private int bsearchInternally(int[] a, int low, int high, int val) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == val) {
            return mid;
        } else if (a[mid] < val) {
            return bsearchInternally(a, mid + 1, high, val);
        } else {
            return bsearchInternally(a, low, mid - 1, val);
        }
    }

    /**
     * 查找第一个值等于给定value的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchII(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {//相等的情况
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;//如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；如果 mid 不等于 0，但 a[mid]的前一个元素 a[mid-1]不等于 value，那也说明 a[mid]就是我们要找的第一个值等于给定值的元素
                }
                high = mid - 1;//经过检查之后发现 a[mid]前面的一个元素 a[mid-1]也等于 value，那说明此时的 a[mid]肯定不是我们要查找的第一个值等于给定值的元素。那我们就更新 high=mid-1，因为要找的元素肯定出现在[low, mid-1]之间
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定value的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchIII(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {//相等的情况
                if ((mid == n - 1) || (a[mid + 1] != value)) {
                    return mid;//如果 a[mid]的后一个元素 a[mid+1]不等于 value，那也说明 a[mid]就是我们要找的最后一个值等于给定值的元素
                }
                low = mid + 1;//经过检查之后，发现 a[mid]后面的一个元素 a[mid+1]也等于 value，那说明当前的这个 a[mid]并不是最后一个值等于给定值的元素。我们就更新 low=mid+1，因为要找的元素肯定出现在[mid+1, high]之间
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchIIII(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) {
                    return mid;//对于 a[mid]大于等于给定值 value 的情况，我们要先看下这个 a[mid]是不是我们要找的第一个值大于等于给定值的元素。如果 a[mid]前面已经没有元素，或者前面一个元素小于要查找的值 value，那 a[mid]就是我们要找的元素。这段逻辑对应的代码是第 7 行。
                }
                high = mid - 1;//如果 a[mid-1]也大于等于要查找的值 value，那说明要查找的元素在[low, mid-1]之间，所以，我们将 high 更新为 mid-1。
            } else {
                low = mid + 1;//如果 a[mid]小于要查找的值 value，那要查找的值肯定在[mid+1, high]之间，所以，我们更新 low=mid+1
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchIIIII(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 循环排序数组查找target
     *
     * @param nums
     * @param target
     * @return
     */
    int binarySearchInRotatedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     * 查找右边界
     * @param nums
     * @param target
     * @return
     */
    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }


}
