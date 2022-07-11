package poc;

public class EqualTest {

	public static void main(String[] args) {

		int test_count = 1 << 16;
		 
		int test[] = new int[test_count];
		
		for (int i = 0; i < test_count; i++) {
			test[i] = (int) (Math.random() * 1000); 
			if(test[i] % 2 == 0) test[i] = -1;
		}
		
		long now = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < test_count; i++) {
			if(test[i] != -1) {
				count++;
			} 
		}
		
		System.out.println("비교갯수 : " + count);
		System.out.println("연산시간 : " + (System.currentTimeMillis()-now));
		
		for (int i = 0; i < test_count; i++) { 
			if(test[i] < 0) test[i] = 1000000000;
		}
		
		now = System.currentTimeMillis();
		count = 0;
		for (int i = 0; i < test_count; i++) {
			if(test[i] != 1000000000) {
				count++;
			} 
		}
		System.out.println("비교갯수 : " + count);
		System.out.println("연산시간 : " + (System.currentTimeMillis()-now));
		
	}

}
