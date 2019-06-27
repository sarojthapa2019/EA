package edu.mum.cs.helloworldboot.component.impl;

import edu.mum.cs.helloworldboot.component.MessageOrigin;
import org.springframework.stereotype.Component;


@Component
public class HelloWorldMessageOrigin implements MessageOrigin {
 
	public String getMessage() {
		  return "Hello World!";	}
 }
