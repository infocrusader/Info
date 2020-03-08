public class AidClass{
	//Decalare variables
	private int amount; 
	private static String type;
	private static String fruit;
	private static Double collect;
	private static boolean Extra;
	
	//Setting up the constructor
	public AidClass(int amount, String type, String fruit, double collect, boolean Extra) {
		super();
		this.amount = amount;
		this.type = type;
		this.fruit = fruit;
		this.Extra = Extra;
		this.collect = collect;
	}
	//Setters And Getters(Static in this case)
	public static Double getcollect() {
		return collect;
	}
	public void setUcret(Double collect) {
		this.collect = collect;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public static String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public static boolean Extra() {
		return Extra;
	}

	public void setExtra(boolean Extra) {
		this.Extra = Extra;
	}

	@Override
	public String toString() {
		//Here i write the methods for coupling the total amount with a relay message
		if(type.equals("Juice")) 
			return String.valueOf(amount) + " glass(es) of " + fruit + " added.";
		else if(type.equals("Water")) {
			if(Extra) 
				return String.valueOf(amount) + " glass(es) of water with ice added.";
			else {
				return String.valueOf(amount) + " glass(es) of water added.";
			}
		}
		else if(type.equals("Tea")) {
			if(Extra) 
				return String.valueOf(amount) + " glass(es) of tea with sugar added.";
			else {
				return String.valueOf(amount) + " glass(es) of tea added.";
			}	
		}
		else {
			if(Extra) 
				return String.valueOf(amount) + " glass(es) of coffee with milk added.";
			else {
				return String.valueOf(amount) + " glass(es) of coffee added.";
			}	
		}
	}


}
