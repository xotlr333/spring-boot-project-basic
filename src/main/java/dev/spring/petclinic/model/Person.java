package dev.spring.petclinic.model;

import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Lombok getter()
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자, 접근레벨 Protected
@MappedSuperclass
public class Person extends BaseEntity{


	private String firstName;
	
	private String lastName;
	
	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
