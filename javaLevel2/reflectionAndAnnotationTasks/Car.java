package reflectionAndAnnotationTasks;

/**
 * 1. Создать класс Car с полями String brand и String model.
	Создать аннотации @Table (принимает название схемы и таблицы
	в базе данных) и @Column (принимает название колонки в таблице
	базы данных). Пометить класс аннотацией @Table и поля
	аннотацией @Column. Написать программу, принимающую
	объект класс  Car c проинициализированными полями и
	составляющую запрос "INSERT" в виде строки на основании
	данных объекта.
	    Пример: дан объект Car car = new Car("Toyota", "Corolla");
	    Программа, принимающая этот объект, должна вывести в консоль строку:
		"INSERT INTO garage.car (model, brand) VALUES ('Toyota', 'Corolla');" 
 */
@Table(table = "cars")
public class Car {
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;
	
	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + "]";
	}
	
}
