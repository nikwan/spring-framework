package niks.poc.spring.propagation.demo.func;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StrategyPatternWithFunc {
	
	public static int processNums(List<Integer> values, Predicate<Integer> criteria) {
		int sum = 0;
		for(Integer n: values) {
			if(criteria.test(n)) sum += n;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("all numbers addition:" + processNums(numbers, e -> true ));
		System.out.println("even numbers addition:" + processNums(numbers, e -> e % 2 == 0));
		System.out.println("odd numbers addition:" + processNums(numbers, e -> e % 2 != 0));
		
		
		Set<Integer> collect = numbers.stream()
		.filter(e -> e % 2 == 0)
		.collect(Collectors.toSet());
		
		System.out.println(collect);
		
		
	}
		

}
