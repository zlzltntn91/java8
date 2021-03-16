package lambda.testclass;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.IntFunction;
import java.util.function.ObjIntConsumer;

@Slf4j
public class PrimitiveFunctionalInterfaceTest {

	@Test
	public void primitive_int(){
		IntFunction<Integer> intFunction = v -> v + 1;
		log.info(intFunction.apply(2) + "");

		ObjIntConsumer objIntConsumer = (obj, v) -> {
			log.info(obj.toString());
			log.info(v + "");
		};
		objIntConsumer.accept("dldll", 3);
	}
}
