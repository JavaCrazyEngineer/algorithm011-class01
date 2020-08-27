/**
 * 快排、归并排序思想
 */
public class Sort {


    /*
    // 归并排序算法, A是数组，n表示数组大小
    merge_sort(A, n) {
        merge_sort_c(A, 0, n-1)
    }

    // 递归调用函数
    merge_sort_c(A, p, r) {
        // 递归终止条件
        if p >= r  then return

                // 取p到r之间的中间位置q
                q = (p+r) / 2
        // 分治递归
        merge_sort_c(A, p, q)
        merge_sort_c(A, q+1, r)
        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(A[p...r], A[p...q], A[q+1...r])
    }*/


    /*
    merge(A[p...r], A[p...q], A[q+1...r]) {
        var i := p，j := q+1，k := 0 // 初始化变量i, j, k
        var tmp := new array[0...r-p] // 申请一个大小跟A[p...r]一样的临时数组
        while i<=q AND j<=r do {
            if A[i] <= A[j] {
                tmp[k++] = A[i++] // i++等于i:=i+1
            } else {
                tmp[k++] = A[j++]
            }
        }

        // 判断哪个子数组中有剩余的数据
        var start := i，end := q
        if j<=r then start := j, end:=r

        // 将剩余的数据拷贝到临时数组tmp
        while start <= end do {
            tmp[k++] = A[start++]
        }

        // 将tmp中的数组拷贝回A[p...r]
        for i:=0 to r-p do {
            A[p+i] = tmp[i]
        }
    }*/



    // 快速排序，A是数组，n表示数组的大小
    /*
    quick_sort(A, n) {
        quick_sort_c(A, 0, n-1)
    }
    // 快速排序递归函数，p,r为下标
    quick_sort_c(A, p, r) {
        if p >= r then return

                q = partition(A, p, r) // 获取分区点
        quick_sort_c(A, p, q-1)
        quick_sort_c(A, q+1, r)
    }


    partition(A, p, r) {
        pivot := A[r]
        i := p
        for j := p to r-1 do {
            if A[j] < pivot {
                swap A[i] with A[j]
                i := i+1
            }
        }
        swap A[i] with A[r]
        return i*/



    }
