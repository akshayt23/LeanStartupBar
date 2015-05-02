package akshay;

class Order {
	private int orderNumber;
	private int id;
	private String name;
	private int prepTime;
	private String timeStamp;
	
	public Order(int orderNumber, int id, String timeStamp) {
		this.orderNumber = orderNumber;
		this.id = id;
		this.timeStamp = timeStamp;
		
		switch(id) {
			case 1:
				name = "Sandwich";
				prepTime = 5;
				break;
			case 2:
				name = "Coffee";
				prepTime = 3;
				break;
			case 3:
				name = "Cereal";
				prepTime = 3;
				break;
			case 4:
				name = "Pizza";
				prepTime = 7;
				break;
			default:
				name = "";
				prepTime = 0;
				break;
		}
			
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
