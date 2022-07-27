package war_game;

public class Card {
	
	int value;
	String name;
	
	public Card(int value, String name) {
		super();
		this.value = value;
		this.name = name;
	}

	public void describe() {
		System.out.println(name + " = " + value);
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) { // needed? not using
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {  // needed? not using
		this.name = name;
	}
}
