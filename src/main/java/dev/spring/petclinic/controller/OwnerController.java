package dev.spring.petclinic.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;

@Controller
@RequestMapping("/owners") // 
public class OwnerController {

	private OwnerService ownerService;
	
	@Autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	
	@GetMapping(path = "/find")
	public String findOwner(Model model) {
		System.out.println("findOwner");
		model.addAttribute("owner", Owner.builder().build());
		
		return "owners/findOwners";
	}
	
	@GetMapping
	public String processFindForm(Owner owner, Model model) {
		
		// 별도의 파라미터 값 없이/owners로 요청할 경우 모든 Owners 데이터 반환
		if(owner.getLastName() == null) {
			owner.setLastName("");
		}
		
		List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		
		if(owners.isEmpty()) {
			return "redirect:/owners/find";
		} else if (owners.size() == 1) {
			return "redirect:/owners/" + owners.get(0).getId() ;
		}
		
		/*
		 * 조건1. 해당하는 owner가 없을 경우 - owners/findOwners로 페이지 이동
		 * 조건2. owner가 1명일 경우, 결로에 owners/{ownerId}
		 * 조건3. 2명 이상의 owner일 경우
		 */
		
		model.addAttribute("listOwners", owners);
		
		return "owners/ownersList";
	}
	
	
	@GetMapping("/{ownerId}")
	public String showOwner(@PathVariable Long ownerId, Model model) {
		
		Owner owner = ownerService.findById(ownerId);
		model.addAttribute("owner", owner);
		
		return "owners/ownerDetails";
		
	}
	
}