package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	private Client() {}

	public static void main(String args[]){

		String host = (args.length < 1) ? "localhost" : args[0];

		System.out.println("Host : " + host);

		try {

			Registry registry = LocateRegistry.getRegistry(host);
			System.out.println("After LocateRegistry");
			Hello stub = (Hello) registry.lookup("Hello");
			System.out.println("After registry.lookup(hello)");

			String response = stub.sayHello();
			System.out.println("After stub.sayHello()");

			System.out.println("response : " + response);

		} catch (Exception e) {
			System.err.println("Client exception : " + e.toString());
			e.printStackTrace();
		}
	}

}
