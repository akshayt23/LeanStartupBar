package akshay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.io.*;

public class Chef implements Runnable {
	
	BlockingQueue<Order> ordersQueue = null;
	
	public Chef(BlockingQueue<Order> ordersQueue) { 
		this.ordersQueue = ordersQueue;
	}

	@Override
	public void run() {
		Order order = null;
		
		while (true) {
			try { 
				order = ordersQueue.take();
				if (order != null) {
					processOrder(order);
					Thread.sleep(1000 * order.getPrepTime());
					finishOrder(order);
				}
			} catch(InterruptedException e) {
				if (order != null)
					System.out.println("Could not prepare " + order.getName());
				e.printStackTrace();
			}
		}
	}
	
	public void processOrder(Order order) {
		writeToFile("Chef : Picked up ORD" + order.getOrderNumber() + " at " + 
				order.getTimeStamp());
		writeToFile("Chef : Cooking " + order.getName() + "...");

	}
	
	public void finishOrder(Order order) { 
		String timeStamp = new SimpleDateFormat("HH:mm:ss")
								.format(Calendar.getInstance().getTime());
		writeToFile("Chef : Finished making " + order.getName() + " for ORD" + 
								order.getOrderNumber() + " at " + timeStamp);
	}
	
	public void writeToFile(String str) {
		FileWriter fileWriter = null;
		BufferedWriter buffWriter = null;
		
		try {
			File file = new File("OrderProcessed.txt");
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fileWriter = new FileWriter(file.getAbsoluteFile(), true);
			buffWriter = new BufferedWriter(fileWriter);
			buffWriter.write(str);
			
		} catch (IOException e) {
			System.out.println("Could not write to file!");
			e.printStackTrace();
		} finally {
			try {
				if (buffWriter != null)
					buffWriter.close();
			} catch (IOException e) {
				System.out.println("File could not be closed.");
				e.printStackTrace();
			}
		}
		
	}
	
}
