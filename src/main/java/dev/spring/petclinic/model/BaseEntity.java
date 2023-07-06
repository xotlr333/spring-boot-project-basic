package dev.spring.petclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Lombok getter()
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자, 접근레벨 Protected
@MappedSuperclass
public class BaseEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public BaseEntity(Long id) {
		this.id = id;
	}
}
