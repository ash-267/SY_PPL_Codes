import java.util.*;
class Order {
	int orderID;
	String CustName, FoodItem;
	
	public Order (int oID, String Cname, String fItem) {
		this.orderID = oID;
		this.CustName = Cname;
		this.FoodItem = fItem;
	}
}
class OrderList {
	public Queue<Order> orderQueue = new LinkedList<>();
	
	public synchronized void putOrder (Order order) {
		orderQueue.add(order);
		System.out.println("Order " + order.orderID + " of " + order.CustName + " which is: " + order.FoodItem + " has been placed!");
	}
	
	public synchronized Order getOrder() {
	     while (orderQueue.isEmpty()) {
	         try {
	             wait();
	         } catch (InterruptedException e) {
	             System.out.println("Exception has occured");
	         }
	     }
	     return orderQueue.poll();
	 }
}
class DeliveryAgents extends Thread {
	String Name;
	OrderList orderlist;
	
	public DeliveryAgents (String nm, OrderList list1) {
		this.Name = nm;
		this.orderlist = list1;
	}
	
	public void run() {
		try {
			Order order = orderlist.getOrder();
			System.out.println("Order " + order.orderID + " picked of " + order.CustName + " which is: " + order.FoodItem + ".");
			sleep(1000);
			System.out.println("Order Delivered");
		}
		catch(Exception e) {
			System.out.println("Error with threads");
		}
	}
}
class FoodDelivery {
	public static void main (String[] args) {
		Order order1 = new Order(1, "Sahil", "Misal");
		Order order2 = new Order(1, "Anish", "Burger");
		Order order3 = new Order(1, "Jalaja", "Sandwich");
		
		OrderList list1 = new OrderList();
		
		list1.putOrder(order1);
		list1.putOrder(order2);
		list1.putOrder(order3);
		
		DeliveryAgents agent1 = new DeliveryAgents("agentOne", list1);
		DeliveryAgents agent2 = new DeliveryAgents("agentTwo", list1);
		DeliveryAgents agent3 = new DeliveryAgents("agentThree", list1);
		
		agent1.start();
		agent2.start();
		agent3.start();
	}
}
