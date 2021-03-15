package nestedClass;

@FunctionalInterface
public interface AnonymousClass {
	void hello();

	static int max() {
		return 0;
	}

	default int min() {
		return 0;
	}
}
