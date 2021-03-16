package etc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ForForEachStreamTest {

	List<Integer> nums;

	@Before
	public void createList_100_000() {
		nums = new ArrayList<>();
		for (int i = 0; i < 100_000; i++) {
			nums.add(i);
		}
	}

	@Test
	public void performance_for() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < nums.size(); i++) {
			int j = nums.get(i) + nums.get(i);
		}
		log.info("for : {}", System.currentTimeMillis() - start);
	}

	@Test
	public void performance_forEach() {
		long start = System.currentTimeMillis();
		for (int num : nums) {
			int j = num + num;
		}
		log.info("forEach : {}", System.currentTimeMillis() - start);
	}

	@Test
	public void performance_stream() {
		long start = System.currentTimeMillis();
		nums.stream().forEach(v -> {
			int j = v + v;
		});
		log.info("stream : {}", System.currentTimeMillis() - start);
	}
}
