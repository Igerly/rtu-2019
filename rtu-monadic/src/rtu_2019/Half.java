package rtu_2019;

import java.util.Optional;

public class Half {

	private static Optional<Integer> maxxed(Integer i) {
		if (i < 10)
			return Optional.of(i);
		else
			return Optional.empty();
	}
	
	private static Optional<Integer> half(Integer i) {
		if (i % 2 == 0)
			return Optional.of(i / 2);
		else
			return Optional.empty();
	}
	
	public static void main(String[] args) {
		System.out.println(half(4));
		System.out.println(half(3));
		half(16)
			.map(Half::maxxed)
//			.map(Half::maxxed) // Whoops: half doesn't operate on wrapped numbers
			;
	}
}
