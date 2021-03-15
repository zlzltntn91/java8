package nestedClass;

import org.junit.Test;

public class NestedTest {

	@Test
	public void 익명클래스() {

		AnonymousClass anonymousClass = new AnonymousClass() {
			@Override
			public void hello() {
				System.out.println("hello Anonymous");
			}
		};

		AnonymousClass lambda = () -> System.out.println("hello anonymous");

		anonymousClass.hello();
		lambda.hello();
	}

	@Test
	public void 익명클래스2() {
		AnonymousClass anonymousClass = () -> System.out.println("람다");
		anonymousClass.hello();
	}
}
