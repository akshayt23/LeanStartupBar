package akshay;
import java.util.concurrent.*;
import java.util.*;
import java.text.*;

class Waiter implements Runnable {
	
	BlockingQueue<Order> ordersQueue = null;
	private static int orderNumber = 0;
	
	
	public Waiter(BlockingQueue<Order> ordersQueue) { 
		this.ordersQueue = ordersQueue;
	}

	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		int itemId = 0;
		
		while(true) {
			try {
				System.out.print("Enter item id: ");
				itemId = in.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter a number");
				itemId = 0;
			}
			
			if (itemId < 1 || itemId > 4)
				System.out.println("Invalid item id.");
			else { 
				try {
					String timeStamp = new SimpleDateFormat("HH:mm:ss")
											.format(Calendar.getInstance().getTime());

					Order order = new Order(++orderNumber, itemId, timeStamp);
					ordersQueue.put(order);
					
					System.out.println("Order Number: ORD" + orderNumber + 
							" for " + order.getName() + " placed at " + timeStamp);
					
				} catch (InterruptedException e) {
					System.out.println("Could not process order, please try again.");
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	

}
