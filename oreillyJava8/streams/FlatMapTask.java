package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Phone {
	private String name;
	private int price;
	private List<String> owners;
	
	Phone(String name, int price) {   		   // for first example
		this.name = name;
		this.price = price;
	}
	Phone(String name, List<String> owners) {  // for second example
		this.name = name;
		this.setOwners(owners);
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
	public List<String> getOwners() {
		return owners;
	}
	public void setOwners(List<String> owners) {
		this.owners = owners;
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
		.forEach(s->System.out.println(s)); // or .forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("---------Second example bellow---------");		
		List<Phone> phones = Arrays.asList(									// создаем листы внутри листа
				new Phone("Samsung", Arrays.asList("Buddy", "Lucy")),
				new Phone("Samsung", Arrays.asList("Frankie", "Rosie")),
				new Phone("Samsung", Arrays.asList("Simba", "Tilly"))
				);
		System.out.println("1. Without func");
		List<String> owner1NamesList = new ArrayList<>();					
		for (Phone ph : phones) {
			owner1NamesList.addAll(ph.getOwners());							// в ownerNamesList добавляем всех владельцев
		}
		System.out.println(owner1NamesList);
		System.out.println("2. map()+flatmap()");
		List<String> owner2NamesList = phones.stream()
				.map(ph -> ph.getOwners())
				.flatMap(ow -> ow.stream())
				.collect(Collectors.toList());
		System.out.println(owner2NamesList);
		owner2NamesList.forEach(System.out::print);			// Соединяет все string в одно целое
		System.out.println();
		System.out.println("3. only flatmap()");
		List<String> owner3NamesList = phones.stream()
				.flatMap(x -> x.getOwners().stream())
				.collect(Collectors.toList());
		System.out.println(owner3NamesList);
	}
}
