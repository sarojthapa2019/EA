Annotations & JavaConfig

Removed JavaConfiguration.class which used for Configuration.
Integrated it with HelloWorld which looks like SpringBoot Entry class

@Configuration
@ComponentScan("edu.mum") // search the edu.mum.component package for @Component classes
public class JavaConfiguration {

}


