package stream.testclass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import stream.ex.Student;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class GroupingTest {
	Student[] stuArr;
	ObjectMapper mapper = new ObjectMapper();

	{
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

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
	public void basic() throws JsonProcessingException {
		Arrays.stream(stuArr).collect(groupingBy(Student::getHak))
				.forEach((v, v2) -> System.out.println(v + "학년 :" + v2.size() + "//" + v2));

		Map<Integer, Map<Integer, List<Student>>> res = Arrays.stream(stuArr).collect(groupingBy(Student::getHak,
																								 groupingBy(
																										 Student::getBan)));
		log.info(mapper.writeValueAsString(res));


	}

	@Test
	public void 아이띵크() {
		Arrays.stream(stuArr).collect(ArrayList::new,
									  (objects, student) -> {
											HashMap<String, Object> stu = new HashMap<>();
											stu.put("학년", student.getHak());
											stu.put("data", student);
											objects.add(stu);
									  }
									  , ArrayList::addAll)
				.forEach((v) -> System.out.println(v + " // "));

	}


}
