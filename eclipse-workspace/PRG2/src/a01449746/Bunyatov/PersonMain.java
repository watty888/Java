package a01449746.Bunyatov;

import java.io.*;
import java.util.stream.Stream;
 
public class PersonMain {

	public static void main(String[] args) throws Exception {
		Stream<Integer> s = Stream.of(5, 10, 20, 50);
		Integer i = s.reduce((integer1, integer2)-> integer2 - integer1).orElse(-1);

		System.out.println(i);

	}
}
