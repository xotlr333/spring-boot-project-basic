package dev.spring.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {
	// Impl: Implement의 줄임 표현
	// -> OwnerService 인터페이스를 구현한 구현 클래스 OwnerServiceImpl
	
	private final OwnerRepository ownerRepository;
	
	@Autowired
	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		
		return ownerRepository.findAllByLastNameLike(lastName);
	}

	@Override
	public Owner findById(Long ownerId) {
		return ownerRepository.findById(ownerId).orElse(null);
	}
	
	

	/*
	 * 이상적인 인터페이스 - 구현체 네이밍 List - 인터페이스 'Array'List - 구현체 'Linked'List - 구현체
	 * 
	 * OwnerFinder - 조회 관련 메서드가 정의된 인터페이스 
	 * OwnerEditor - Insert, Update, Delete 관련 메서드가 정의된 인터페이스
	 * 
	 * OwnerManager - OwnerFinder, Editor 구현체
	 * 
	 */

}
