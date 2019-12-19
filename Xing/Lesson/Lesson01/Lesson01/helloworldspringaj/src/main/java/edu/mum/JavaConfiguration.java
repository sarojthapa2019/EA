package edu.mum;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// search the edu.mum.component package for @Component classes
@ComponentScan("edu.mum")
public class JavaConfiguration {
}
