import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner{

    Deque<Integer> spans;
    Deque<Integer> prices;

    public StockSpanner(){
        spans = new ArrayDeque<>();
        prices = new ArrayDeque<>();
    }

    public int next(int price){
        int span = 1;

        while(!prices.isEmpty() && prices.peek() <= price){
            span+=spans.pop();
            prices.pop();
        }
        
        prices.push(price);
        spans.push(span);

        return span;
    }
}

public class Main {
    public static void main(String[] args){
        StockSpanner ss = new StockSpanner();

       System.out.println(ss.next(100));
       System.out.println(ss.next(80));
       System.out.println(ss.next(60));
       System.out.println(ss.next(70));
       System.out.println(ss.next(60));
       System.out.println(ss.next(75));
       System.out.println(ss.next(85));
    }
}
