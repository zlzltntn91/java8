package stream.testclass;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class StreamTest {
	@Test
	public void 스트림생성() {
		// Stream static method
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
		integerStream.forEach(System.out::print);
		System.out.println();
		Stream intStream = Stream.of(new int[]{1, 2, 3, 4, 5});
		intStream.forEach(System.out::print);
		System.out.println();
		IntStream intStream2 = IntStream.of(new int[]{1, 2, 3, 4, 5});
		intStream2.forEach(System.out::print);
		System.out.println();

		// Arrays static method
		IntStream stream1 = Arrays.stream(new int[]{1, 2, 3, 4, 5});
		stream1.forEach(System.out::print);
		System.out.println();
		IntStream stream2 = Arrays.stream(new int[]{1, 2, 3, 4, 5}, 0, 1);
		stream2.forEach(System.out::print);
	}

	@Test
	public void 특정범위정수스트림생성() {
		IntStream intStream = IntStream.range(0, 10);
		intStream.forEach(System.out::println);

		System.out.println();

		IntStream intStreamClosed = IntStream.rangeClosed(0, 10);
		intStreamClosed.forEach(System.out::println);
	}

	@Test
	public void 임이의수() {
		// Random 클래스에 포함된 인스턴스 메서드
		IntStream intStream = new Random().ints();
		int[] randomNumArr = intStream.limit(100).toArray();
		log.info(Arrays.toString(randomNumArr));

		int[] randomNumArr2 = new Random().ints(1, 3).limit(10).toArray();
		log.info(Arrays.toString(randomNumArr2));

		int[] randomNumArr3 = new Random().ints(10, 0, 2).toArray();
		log.info(Arrays.toString(randomNumArr3));
	}

	@Test
	public void 람다식(){
		Stream<Integer> iterate = Stream.iterate(1, (v) -> v + 1).limit(10); // 1, 1+1, 2+1, 3+1 ....
		iterate.forEach(System.out::print);

		System.out.println();

		Stream<Integer>	generate = Stream.generate(() -> 3).limit(10);
		generate.forEach(System.out::print);
	}

	@SneakyThrows
	@Test
	public void 파일스트림(){
		String pathname = "C:\\Users\\dgtazm9513\\Desktop";
		Path path = Paths.get(pathname);
		Stream<Path> filePaths = Files.list(path);
		filePaths.forEach(System.out::println);

		Optional<Path> file = Files.list(path).filter(v -> v.toString().endsWith(".txt")).findFirst();
		log.info(file.toString());
		Stream<String> content = Files.lines(file.get());
		content.forEach(System.out::println);
	}

	@Test
	public void name() {
		List<String> stringList = new ArrayList<>(Arrays.asList("김", "은", "수", "김"));
		Stream<String> listStream = stringList.stream();
		listStream.forEach(System.out::println);

		System.out.println();

		Set<String> stringSet = new HashSet<>(Arrays.asList("김", "은", "수", "김"));
		Stream<String> setStream = stringSet.stream();
		setStream.forEach(System.out::println);

		Stream stream = Stream.of(new int[]{1, 2, 3, 4});
	}
}
