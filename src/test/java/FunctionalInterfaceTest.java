import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
public class FunctionalInterfaceTest {

	@Test
	public void function_biFunction() {
		Function<String, String> f = (s) -> s.concat(" world");
		BiFunction<String, String, String> f2 = (s, s2) -> s.concat(s2);

		log.info(f.apply("Hello"));
		log.info(f2.apply("Hola", " mundo"));
	}

	@Test
	public void consumer_BiConsumer() {
		Consumer<String> consumer = v -> System.out.println(v);
		BiConsumer<String, Integer> consumer1 = (v, v2) -> System.out.println(v + v2);
		consumer.accept("Hello Consumer");
		consumer1.accept("Hello Consumer", 1);
	}

	@Test
	public void supplier() {
		Supplier<String> supplier = () -> "김은수";
		log.info(supplier.get());
	}

	@Test
	public void predicate_BiPredicate() {
		Predicate<String> predicate = v	-> v.equals("김은수");
		log.info(predicate.test("김은수") + "");

		BiPredicate<String, String>	biPredicate = (v, u) -> v.equals(u);
		log.info(String.valueOf(biPredicate.test("김은수", "김은수")));
	}

	@Test
	public void runnable() {
		Runnable runnable = () -> System.out.println("sdfsdf");
		runnable.run();
	}

	@Test
	public void unaryOperator_BinaryOperator() {
		UnaryOperator<String> unaryOperator = v -> v.concat("unary");
		log.info(unaryOperator.apply("operator"));

		BinaryOperator<String> binaryOperator = (t, u) -> t.concat(u);
		log.info(binaryOperator.apply("Hola", " mundo"));
	}
}
