Exception:
HTTP Status 500 - Could not write content: No serializer found for class org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) ) (through reference chain: java.util.HashMap[&quot;departments&quot;]-&gt;java.util.UnmodifiableRandomAccessList[0]
http://www.greggbolinger.com/ignoring-hibernate-garbage-via-jsonignoreproperties/

No need for explicit add, already supported by web-starter
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
</dependency>
