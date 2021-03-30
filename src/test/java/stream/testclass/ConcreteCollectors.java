package stream.testclass;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

@Slf4j
public class ConcreteCollectors implements Collector<String, String, String> {

	@Test
	public void test(){
		String[] t = new String[]{"무", "야", "호"};
		String result = Arrays.stream(t).collect(new ConcreteCollectors());
		log.info(result);
	}

	@Override
	public Supplier<String> supplier() {
		return () -> new String();
	}

	@Override
	public BiConsumer<String, String> accumulator() {
		return (v, v2) -> {
			v = v2;
			System.out.println(v + "//" + v2);
		};
	}

	@Override
	public BinaryOperator<String> combiner() {
		return (v, v2) -> {
			System.out.println(v);
			System.out.println(v2);
			return v;
		};
	}

	@Override
	public Function<String, String> finisher() {
		return (v) -> v.toString();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}
}
