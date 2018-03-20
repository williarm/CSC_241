
public class LargeIntDriver {
	public static void main(String[] args) {
		LargeInt x = new LargeInt("123456789");
		LargeInt y = new LargeInt("123456789");
		LargeInt z = LargeInt.add(x, y);
		LargeInt product = LargeInt.multiply(x, y);
	}
}
