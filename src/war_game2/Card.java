package war_game2;

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
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
