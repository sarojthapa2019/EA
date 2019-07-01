hibernate-ehcache is deprecated. use hibernate-jcache instead.
need to add both dependencies.

<dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-jcache</artifactId>
            <version>${hibernate.version}</version>
        </dependency>
        <dependency>
            <groupId>org.ehcache</groupId>
            <artifactId>ehcache</artifactId>
            <version>3.7.1</version>
        </dependency>