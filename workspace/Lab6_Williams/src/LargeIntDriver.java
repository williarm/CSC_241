
public class LargeIntDriver {
	public static void main(String[] args) {
		LargeInt x = new LargeInt("345");
		LargeInt y = new LargeInt("123");
		LargeInt z = LargeInt.add(x, y);
		LargeInt product = LargeInt.multiply(x, y);
		System.out.println(product);
	}
}
