import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

@FunctionalInterface
interface FunctionSum {
	int sum(int a,
			int b);
}

@Slf4j
public class Lambda {




	@Test
	public void 메서드를람다식으로() {
		// 1
		BiFunction<Integer, Integer, Integer> max1 = (Integer a, Integer b) -> {
			return a > b ? a : b;
		};
		BiFunction<Integer, Integer, Integer> max2 = (a, b) -> {
			return a > b ? a : b;
		};
		BiFunction<Integer, Integer, Integer> max3 = (a, b) -> a > b ? a : b;

		assertThat(max1.apply(3, 5)).isEqualTo(max(3, 5));
		assertThat(max2.apply(37, 5)).isEqualTo(max(37, 5));
		assertThat(max3.apply(35, 5)).isEqualTo(max(35, 5));

		// 2
		BiConsumer<String, Integer> printVar1 = (s, i) -> log.info(s + "=" + i);

		printVar1.accept("김은수", 3);
		printVar("김은수", 3);

	}

	int max(int a, int b) {
		return a > b ? a : b;
	}

	void printVar(String name, int i) {
		log.info(name + "=" + i);
	}
	int classVariable = 5;
	@Test
	public void 람다식의지역변수참조() {
		int c = 1; // == final int c = 1;

		FunctionSum sum = (a, b) -> {
			a = a + 20;
			classVariable = 50;
			return a + b + classVariable + c;
		};

		log.info("result :{}", sum.sum(3, 5));
	}
}

@Slf4j
class Print<T extends String, U extends String> implements BiConsumer<T, U> {

	@Override
	public void accept(T t, U u) {
		log.info(t + "=" + u);
	}
}
