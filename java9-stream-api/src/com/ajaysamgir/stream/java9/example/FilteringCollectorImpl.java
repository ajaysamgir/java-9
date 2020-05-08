package com.ajaysamgir.stream.java9.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilteringCollectorImpl {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Stream<Integer> numbersStream = numbers.stream();		
		List<Integer> moreThan4 = numbersStream.collect(Collectors.filtering(num -> num > 4, Collectors.toList()));
		moreThan4.forEach(System.out::println);
	}

}
