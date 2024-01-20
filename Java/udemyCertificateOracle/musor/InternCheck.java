package udemyCertificateOracle.musor;

public class InternCheck {
	public static void main(String[] args) {
		String a = "string a";
		String b = new String("string a");
		String c = b.intern();

		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(a == c);
		System.out.println("string a" == new String("string a").intern());
	}
}
