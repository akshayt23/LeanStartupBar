package akshay;
import java.util.concurrent.*;

public class LeanStartupBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		
		BlockingQueue<Order> ordersQueue = new ArrayBlockingQueue<Order>(100);
		
		Waiter waiter = new Waiter(ordersQueue);
		Chef chef = new Chef(ordersQueue);
		
		new Thread(waiter).start();
		new Thread(chef).start();
	}

}
