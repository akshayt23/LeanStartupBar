package akshay;
import java.util.concurrent.*;

public class LeanStartupBar {

	public static void main(String[] args) {
		// Create queue to hold orders
		BlockingQueue<Order> ordersQueue = new ArrayBlockingQueue<Order>(100);
		
		Waiter waiter = new Waiter(ordersQueue);
		Chef chef = new Chef(ordersQueue);
		
		// Start Waiter and Chef threads
		new Thread(waiter).start();
		new Thread(chef).start();
	}

}
