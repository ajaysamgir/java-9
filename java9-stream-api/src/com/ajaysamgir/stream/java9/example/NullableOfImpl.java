package com.ajaysamgir.stream.java9.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NullableOfImpl {

	public static void main(String...strings) {
		
		Stream<List<String>> namesNull = Stream.ofNullable(null);
		System.out.println(namesNull.count());
	
		Stream<List<String>> names = Stream.ofNullable(Arrays.asList("Jack", "Jonny", "Dev"));
		names.forEach(System.out::println);
	}
}
