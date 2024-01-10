package regexTasks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Написать программу, проверяющую, является ли введённая строка адресом
 * почтового ящика. В названии почтового ящика разрешить использование только
 * букв, цифр и нижних подчёркиваний, при этом оно должно начинаться с буквы.
 * Возможные домены верхнего уровня: .org .com 
 */
/**
 * 2. Написать программу, выполняющую поиск в строке шестнадцатеричных чисел,
 * записанных по правилам Java, с помощью регулярных выражений и выводящую их на
 * страницу.
 */
public class RegularExpressions {
	public static void main(String[] args) {
		System.out.println("Print № of task(1|2|3):");
		try (Scanner sc = new Scanner(System.in)) {
			int task = sc.nextInt();
			if (task == 1) {
				while (true) {
					System.out.println("check your email");
					System.out.println("type your email:");
					while (sc.hasNext()) {
						String input = sc.next();
						if (input.equals("stop")) {
							break;
						}
						System.out.print("valid email:");
						String regex = "^[a-zA-Z]\\w*@\\w+(.org|.com)$";
						boolean matches = input.matches(regex);
						System.out.println(matches);
						System.out.println("type your email:");
					}
					sc.close();
				}
			}
			if (task == 2) {
				while (true) {
					System.out.println("check your value for hexadecimal code");
					System.out.println("type your code:");
					while(sc.hasNext()) {
						String input = sc.next();
						System.out.print("hexadecimals: ");
						String regex = "[0-9A-F]+";
						Matcher compile = Pattern.compile(regex).matcher(input);
						while(compile.find()) {
							System.out.print(compile.group()+" ");
						}
						System.out.println();
						System.out.println("type your code:");
					}
				}
			}
		}
	}
}
