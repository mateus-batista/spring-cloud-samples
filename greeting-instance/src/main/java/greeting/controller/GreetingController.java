package greeting.controller;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import greeting.model.Greeting;

@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Bridger") String name, Principal principal) {
		System.out.println(principal.getName());
		return new Greeting(this.counter.incrementAndGet(),
				String.format(TEMPLATE, name));
	}
}
