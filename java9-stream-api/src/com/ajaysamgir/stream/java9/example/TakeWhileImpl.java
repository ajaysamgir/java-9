package com.ajaysamgir.stream.java9.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TakeWhileImpl {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		Stream<Integer> lessThan5 = numbers.stream().takeWhile(num -> num < 5);
		lessThan5.forEach(System.out::println);
	}

}
