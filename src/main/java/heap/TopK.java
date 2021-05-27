package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yuegc
 * @Date: 2021/5/27 09:16
 * @Description: 10万个数里面找出最大的100个 思路：取n个数构建小顶堆，然后将剩余的数跟堆顶比较，小于的丢弃，大于的跟堆顶交换，再调整堆为小顶堆
 */
public class TopK {

    public static void main(String[] args) {
        //构建数组
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            nums.add(i);
        }
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }
        //取100个数构建小顶堆
        int[] heapArr = new int[100];
        for (int i = 0; i < 100; i++) {
            heapArr[i] = arr[i];
        }
        for (int i = heapArr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(heapArr, i, heapArr.length);
        }
        //剩余的数跟堆比较，调整堆
        for (int i = 100; i < arr.length; i++) {
            if (arr[i] > heapArr[0]) {
                heapArr[0] = arr[i];
                adjustHeap(heapArr, 0, heapArr.length);
            }
        }
        System.out.println("排序前：" + Arrays.toString(heapArr));
        //排序
        for (int i = heapArr.length - 1; i > 0; i--) {
            int temp = heapArr[i];
            heapArr[i] = heapArr[0];
            heapArr[0] = temp;
            adjustHeap(heapArr, 0, i);
        }
        System.out.println("最大的100个数为：" + Arrays.toString(heapArr));
    }


    private static void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && arr[child + 1] < arr[child]) {
                child++;
            }
            if (temp < arr[child]) {
                break;
            }
            arr[parent] = arr[child];
            parent = child;
            child = 2 * child + 1;
        }
        arr[parent] = temp;
    }
}
