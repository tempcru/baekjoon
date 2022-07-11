package poc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class StringDifference {

	static final int COUNT = 100000;
	static final String sample_text = "0";
	
	public static void main(String[] args) throws Exception {

		long now;
		// String 
		now = System.currentTimeMillis();
		String test = "";
		for (int i = 0; i < COUNT; i++) {
			test += sample_text;
		}
		System.out.println(test);
		System.out.println("String 연산시간 : " + (System.currentTimeMillis()-now));
		
		// Buffer
		now = System.currentTimeMillis();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < COUNT; i++) {
			buffer.append(sample_text);
		}
		
		System.out.println(buffer.toString());
		System.out.println("StringBuilder 연산시간 : " + (System.currentTimeMillis()-now));
		
		// Builder
		now = System.currentTimeMillis();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < COUNT; i++) {
			builder.append(sample_text);
		}
		System.out.println(builder.toString());
		System.out.println("StringBuffer연산시간 : " + (System.currentTimeMillis()-now)); 
		
		//BufferedWriter
		now = System.currentTimeMillis();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < COUNT; i++) {
			bw.write(sample_text);
		}
		bw.newLine();
		bw.flush();
		System.out.println("BufferedWriter연산시간 : " + (System.currentTimeMillis()-now));
		
		
		
	}

}
