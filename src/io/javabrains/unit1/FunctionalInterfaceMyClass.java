package io.javabrains.unit1;

public class FunctionalInterfaceMyClass {

	public void greet(FunctionalInterfaceMy greeting) {
		System.out.println(greeting.authorize("aa"));
	}
	
	
	public static void main(String[] args) {
		FunctionalInterfaceMyClass greeter = new FunctionalInterfaceMyClass();
		
		
		FunctionalInterfaceMy lambdaGreeting = (s) -> s.equals("test");

		FunctionalInterfaceMy innerClassGreeting = new FunctionalInterfaceMy() {
			public boolean authorize(String s) {
				return s.equals("test");
			}
		};

		greeter.greet((s) -> s.equals("test"));
		greeter.greet(lambdaGreeting);
		greeter.greet(innerClassGreeting);

	}

}



