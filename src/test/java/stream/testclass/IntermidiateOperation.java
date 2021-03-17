package stream.testclass;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class IntermidiateOperation {

	@Test
	public void 자르기() {
		int[] numbers = IntStream.range(1, 10).toArray();
		assertThat(numbers).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

		int[] four2five = Arrays.stream(numbers)
				.skip(3)
				.limit(2)
				.toArray();
		assertThat(four2five).isEqualTo(new int[]{4, 5});

		int[] one2five = Arrays.stream(numbers).limit(5).toArray();
		assertThat(one2five).isEqualTo(new int[]{1, 2, 3, 4, 5});
	}

	@Test
	public void 거르기() {
		int[] numbers = new int[]{1, 1, 2, 2, 4, 5, 5, 6, 7, 9, 12};

		// 2의 배수
		int[] evenNumbers = Arrays.stream(numbers)
				.filter(v -> v % 2 == 0)
				.toArray();
		assertThat(evenNumbers).isEqualTo(new int[]{2, 2, 4, 6, 12});

		// 중복제거
		int[] distinctNumbers = Arrays.stream(numbers)
				.distinct()
				.toArray();
		assertThat(distinctNumbers).isEqualTo(new int[]{1, 2, 4, 5, 6, 7, 9, 12});

		// 2의 배수이면서 3의 배수인 요소
		int[] filterChain = Arrays.stream(numbers)
				.filter(v -> v % 2 == 0)
				.filter(v -> v % 3 == 0)
				.toArray();
		assertThat(filterChain).isEqualTo(new int[]{6, 12});
		
		// 이렇게 해도 되지만 난 체인 방식이 더 읽기 편하네
		int[] filterChain2 = Arrays.stream(numbers)
				.filter(v -> v % 2 == 0 && v % 3 == 0)
				.toArray();
		assertThat(filterChain2).isEqualTo(new int[]{6, 12});

	}

	@Test
	public void 정렬() {

	}
}