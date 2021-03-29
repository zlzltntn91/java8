package stream.testclass;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import stream.ex.Student;

import java.util.*;

import static java.util.stream.Collectors.*;

@Slf4j
public class PartitionTest {

	Student[] stuArr;

	@Before
	public void setUp() {
		stuArr = new Student[]{
				new Student("나자바", true, 1, 1, 300),
				new Student("김지미", false, 1, 1, 250),
				new Student("김자바", true, 1, 1, 200),
				new Student("이지미", false, 1, 2, 150),
				new Student("남자바", true, 1, 2, 100),
				new Student("안지미", false, 1, 2, 50),
				new Student("황지미", false, 1, 3, 100),
				new Student("강지미", false, 1, 3, 150),
				new Student("이자바", true, 1, 3, 200),

				new Student("나자바", true, 2, 1, 300),
				new Student("김지미", false, 2, 1, 250),
				new Student("김자바", true, 2, 1, 200),
				new Student("이지미", false, 2, 2, 150),
				new Student("남자바", true, 2, 2, 100),
				new Student("안지미", false, 2, 2, 50),
				new Student("황지미", false, 2, 3, 100),
				new Student("강지미", false, 2, 3, 150),
				new Student("이자바", true, 2, 3, 200)
		};
	}

	@Test
	public void 파티션() {
		Map<Boolean, List<Student>> partition = Arrays.stream(stuArr)
				.collect(partitioningBy((v) -> v.isMale(), toList()));

		Map<Boolean, Long> count = Arrays.stream(stuArr).collect(partitioningBy(Student::isMale, counting()));
		log.info("Count: {}", count);

		int totalScore = Arrays.stream(stuArr).collect(summingInt(Student::getScore));
		log.info("Total Score: {}", totalScore);

		Map<Boolean, Student> topStudent = Arrays.stream(stuArr).collect(
				partitioningBy(Student::isMale,
							   collectingAndThen(maxBy(Comparator.comparingInt(Student::getScore)), Optional::get)
				));
		log.info("남자 탑스코어: {} ", topStudent.get(true));
		log.info("여자 탑스코어: {} ", topStudent.get(false));

		Map<Boolean, Map<Boolean, List<Student>>> result = Arrays.stream(stuArr)
				.collect(partitioningBy((v) -> v.getScore() <= 150,
										partitioningBy((v) -> v.isMale())));
		log.info("남자 불합격 : {} ", result.get(true).get(true).stream().count());
		log.info("여자 불합격 : {} ", result.get(true).get(false).stream().count());
	}
}
