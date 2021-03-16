package lambda.testclass;

import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CollectionsLambdaTest {

	List<String> names = Arrays.asList("김", "이", "최", "박", "정"); // ArraysList랑 다른 클래스네

	User user1 = new User("김은수", 31);
	User user2 = new User("이은수", 52);
	User user3 = new User("정은수", 23);
	User user4 = new User("최은수", 11);

	Map<String, User> map = new HashMap<>();

	{
		map.put(user1.name, user1);
		map.put(user2.name, user2);
		map.put(user3.name, user3);
		map.put(user4.name, user4);
	}

	@Test
	public void collection_removeIf() {
		List<String> nameList = new ArrayList<>(names);
		assertThat(nameList).isInstanceOf(ArrayList.class);
		nameList.removeIf(v -> v.equals("김"));
		nameList.forEach(System.out::println);

		System.out.println("────────────────────────────");

		Set<String> nameSet = new HashSet<>(names);
		nameSet.removeIf(v -> v.equals("이"));
		nameSet.forEach(System.out::println);

		System.out.println("────────────────────────────");

		Queue<String> nameQue = new LinkedList<>(names);
		nameQue.removeIf(v -> v.equals("정"));
		nameQue.forEach(System.out::println);
	}

	@Test
	public void list() {
		/*
			java.lang.Iterable<T>
			public void forEach(java.util.function.Consumer<? super T> action
		*/
		names.replaceAll((v) -> "수");
		names.forEach(System.out::println);

	}

	@Test
	public void map() {
		@ToString
		@Setter
		class User {
			private String name;
			private int age;

			User(String name, int age) {
				this.name = name;
				this.age = age;
			}

		}

		User user1 = new User("김은수", 31);
		User user2 = new User("이은수", 52);
		User user3 = new User("정은수", 23);
		User user4 = new User("최은수", 11);

		Map<String, User> map = new HashMap<>();
		map.put(user1.name, user1);
		map.put(user2.name, user2);
		map.put(user3.name, user3);
		map.put(user4.name, user4);


		// 키(1st parameter)에 해당하는 값에 작업을 수행
		// 해당하는 키에 값을 변경
		// compute == 계산하다, 산정하다
		// 키가 없다면 NPP 발생
		map.compute("김은수", (k, v) -> {
			log.info("key: {}", k);
			log.info("value: {}", v.toString());
			return new User("COMPUTE", 99);
		});
		log.info("map: {}", map.toString());

		// 키에 해당하는 밸류가 없다면 추가 작업을 함
		// 1st param이 키값이 되고 2st param이 밸류가됨
		// absent == 결근, 부재, 결핍
		map.computeIfAbsent("최박사", (k) -> {
			return new User("COMPUTE_IF_ABSENT", 98);
		});
		log.info("map: {}", map.toString());
		// present == 현재의, 있는, 존재하는, 참석한
		// 1st param이 키값이 있다면 작업을 함
		// 키가 없어도 NPP 발생 안함
		map.computeIfPresent("이은수", (k, v) -> {
			User user = map.get(k);
			user.setAge(88888);
			return user;
		});
		log.info("map: {}", map.toString());

	}

	@Test
	public void merge() {
		map.merge("김은수", user2, (v, v2) -> {
			log.info(v.toString());
			log.info(v2.toString());
			return new User("키가 있으니까 이걸로", 22);
		});

		log.info("map: {}", map.toString());

		map.merge("키없어", new User("키가 없음", 99), (v, v2) -> {
			log.info("실행되지 않음: {}", v.toString());
			log.info("실행되지 않음: {}", v2.toString());
			return new User("키가 있으니까 이걸로", 22);
		});

		log.info("map: {}", map.toString());
	}

	@ToString
	class User {
		private String name;
		private int age;

		User(String name, int age) {
			this.name = name;
			this.age = age;
		}

	}
}
