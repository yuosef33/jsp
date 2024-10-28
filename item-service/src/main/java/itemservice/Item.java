package itemservice;

public class Item {

	private int id;
	
	private String name;
	
	private double price;
	
	private int totalNumber;
	private boolean haveCon;


	public Item() {
		boolean haveCon=false;
	}
	public boolean isHaveCon() {
		return haveCon;
	}
	public void setHaveCon(boolean haveCon) {
		this.haveCon = haveCon;
	}
	public Item(String name, double price, int totalNumber) {
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
	
	public Item(int id, String name, double price, int totalNumber) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	
}