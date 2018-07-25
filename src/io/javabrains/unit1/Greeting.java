package io.javabrains.unit1;

@FunctionalInterface
public interface Greeting {
	static Greeting DEFAULT = () -> System.out.println("Hello default");
	public void perform();

}
