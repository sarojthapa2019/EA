package edu.mum.cs.springbootwebjspdemo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = -908L;

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty // any characters including "space"
//	 @NotNull
//	 @NotBlank // must have characters BESIDES "space"
    @Size(min = 4, max = 50, message = "Size.firstName")
    private String firstName;

    @NotEmpty(message = "aaa")
    private String lastName;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    // @DateTimeFormat(iso = ISO.DATE) // yyyy-MM-dd
    // @DateTimeFormat(style = "L-") // July 12, 2001
    // @DateTimeFormat(pattern="hh:mm:ss")
    private LocalDate birthDate;

    // @NotEmpty //Gives NO Integer validation exception
    @NotNull
    private Integer salaryLevel;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
