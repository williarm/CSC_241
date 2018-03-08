
public class BagDriver {

	public static void main(String[] args) {
		Bag<FamousPerson> myBag = new Bag(10);
		FamousPerson p1, p2, p3;
		p1 = new FamousPerson("John", "McEnroe", 1980, "Tennis star.");
		p2= new FamousPerson("Herman", "Hollerith", 1860, "Americanscientist.");
		p3= new FamousPerson("John", "McEnroe", 2017, "Tennis announcer.");
		System.out.println(myBag);
		myBag.add(p1);
		myBag.add(p2);
		myBag.add(p3);
		System.out.println(myBag);
		System.out.println(myBag.grab());
		System.out.println(myBag.count(p1));
		System.out.println(myBag.removeAll(p1));
		System.out.println(myBag);myBag.clear();
		System.out.println(myBag)
	}

}
