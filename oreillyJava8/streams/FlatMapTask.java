package streams;

import java.util.stream.Stream;

class Phone {
	private String name;
	private int price;
	
	Phone(String name, int price) {     // For example
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}


public class FlatMapTask {
	public static void main(String[] args) {
		Stream<Phone> phoneStream = Stream.of(new Phone("Xperia Z", 1000), new Phone("Xiaomi mi 5", 500));
		
		phoneStream.flatMap(x -> Stream.of(
				x.getName(), x.getPrice(),
				String.format("nazvanie: %s cena bez skidki: %d", x.getName(), x.getPrice())
//				String.format("nazvanie: %s cena so skidkoy: %s", x.getName(), (int)x.getPrice()*(0.9))
				))
		.forEach(s->System.out.println(s));
	}
	
}
