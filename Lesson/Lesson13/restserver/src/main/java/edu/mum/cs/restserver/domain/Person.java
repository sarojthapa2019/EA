package edu.mum.cs.restserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@JacksonXmlRootElement(localName = "Customer")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty(localName = "firstName")
    private String name;

    private int age;

}
