package dev.spring.petclinic.service;

import java.util.List;

import dev.spring.petclinic.model.Owner;

public interface OwnerService {
	
	// lastName과 일치하는 한 명의 Owner 정보 반환
	Owner findByLastName(String lastName);
	
	// sql에서 like 연산자를 활용한 lastName 검색 기능
	List<Owner> findAllByLastNameLike(String lastName);
	
	Owner findById(Long ownerId);

}
