package akshay;
import java.util.concurrent.*;
import java.util.*;
import java.text.*;
import java.io.*;

class Waiter implements Runnable {
	
	BlockingQueue<Order> ordersQueue = null;
	private static int orderNumber = 0;
	
	
	public Waiter(BlockingQueue<Order> ordersQueue) { 
		this.ordersQueue = ordersQueue;
	}

	@Override
	public void run() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int itemId = 0;
		
		while(true) {
			// Get a new order
			try {
				System.out.print("Enter item id : ");
				itemId = Integer.parseInt(input.readLine());
			} catch (Exception e) {
				System.out.println("Please enter a number!");
				continue;
			}
		
			if (itemId < 1 || itemId > 4)
				System.out.println("Invalid item id, please try again.");
			else { 
				try {
					String timeStamp = new SimpleDateFormat("hh:mm:ss a")
											.format(Calendar.getInstance().getTime());

					// Create new order and put in the queue
					Order order = new Order(++orderNumber, itemId, timeStamp);
					ordersQueue.put(order);
					
					System.out.println("Order Number: ORD" + orderNumber + 
							" for " + order.getName() + " has been placed at " + timeStamp);
					
				} catch (InterruptedException e) {
					System.out.println("Could not process order, please try again.");
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	

}
