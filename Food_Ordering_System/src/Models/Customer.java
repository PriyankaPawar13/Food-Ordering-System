package Models;

public class Customer {
	 
	private int id;
	private String name;
	private String Location;
	private String Phone_Number;
	
	public Customer() {
		super();
	}

	public Customer(int id,String name, String location, String phone_Number) {
		super();
		this.id = id;
		this.name = name;
		Location = location;
		Phone_Number = phone_Number;
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
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", Location=" + Location + ", Phone_Number=" + Phone_Number
				+ "]";
	}

	
	
	
	
	
}
