class Soojebi {
	static private Soojebi instance = null;
	private int count = 0;
	static public Soojebi get() {
		if(instance == null) {
			instance = new Soojebi();
		}
		return instance;
	}
	public void count() {
		count++;
	}
	public int getCount() {
		return count;
	}
}
public class Problem14 {
	
	public static void main(String[] args) {
		Soojebi s1 = Soojebi.get();
		s1.count();
		Soojebi s2 = Soojebi.get();
		s2.count();
		Soojebi s3 = Soojebi.get();
		s3.count();
		System.out.println(s1.getCount());
	}
}
