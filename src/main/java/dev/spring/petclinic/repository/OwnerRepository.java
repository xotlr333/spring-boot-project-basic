package dev.spring.petclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.spring.petclinic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{

	// lastName과 일치하는 한 명의 Owner 정보 반환
	Owner findByLastName(String lastName);
	
	// sql에서 like 연산자를 활용한 lastName 검색 기능
	List<Owner> findAllByLastNameLike(String lastName);
	
	Optional<Owner> findById(Long ownerId);
	
}
