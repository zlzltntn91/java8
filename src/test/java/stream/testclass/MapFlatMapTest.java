package stream.testclass;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class MapFlatMapTest {

	@Test
	public void 맵() {

		Object[][] arr = new Object[][]{new String[]{"Hello", "World"}, new String[]{"Ola", "Mundo"}};

		//  map(Function<Object[], Object[]> mapper)
		Arrays.stream(arr)
				.map(v -> Arrays.stream(v).toArray())
				.map(v -> v)
				.forEach(System.out::println);

		//  flatMap(Function<Object[], Stream<?>>
		Arrays.stream(arr)
				.flatMap(v -> Arrays.stream(v))
				.forEach(System.out::println);

	}

	@Test
	public void 플랫맵() {
		String[][] testArr = new String[][]{
				new String[]{"abc", "def", "ghi"},
				new String[]{"ABC", "GHI", "JKIMN"}
		};

		// Stream<String>으로 만들기
		Arrays.stream(testArr)
				.map(v -> Arrays.stream(v).toArray(String[]::new))
				.flatMap(v -> Arrays.stream(v.clone()))
				.forEach(System.out::println);

		Arrays.stream(testArr)
				.flatMap(v -> Arrays.stream(v.clone()))
				.forEach(System.out::println);
	}

	@Test
	public void 플랫맵2() {
		// 요소가 단어인 스트림을 만들어라
		String[] lineArr = {
				"Believe or not It is true",
				"Do or do not There is no try",
		};

		Arrays.stream(lineArr)
				.map(v -> v.split("\\s"))
				.flatMap(v -> Arrays.stream(v.clone()))
				.forEach(System.out::println);
	}
}
