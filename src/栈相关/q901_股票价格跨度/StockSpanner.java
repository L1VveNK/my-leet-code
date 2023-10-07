package 栈相关.q901_股票价格跨度;

import java.util.Stack;

/**
 * @author: wenke.li
 * @Description:
 * @data: 2023/10/7 23:04
 */
public class StockSpanner {

    private final Stack<int[]> stack;
    private int index;

    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        index = -1;
    }

    public int next(int price) {
        index++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int result = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        return result;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 返回 1
        System.out.println(stockSpanner.next(80)); // 返回 1
        System.out.println(stockSpanner.next(60));  // 返回 1
        System.out.println(stockSpanner.next(70));// 返回 2
        System.out.println(stockSpanner.next(60));  // 返回 1
        System.out.println(stockSpanner.next(75));  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
        System.out.println(stockSpanner.next(85));  // 返回 6
    }
}
