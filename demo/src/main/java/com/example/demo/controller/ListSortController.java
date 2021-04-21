package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RequestInputDTO;
import com.example.demo.Exception.InvalidInput;
import com.example.demo.service.SortingService;


@RestController
public class ListSortController {
	
	@Autowired
	private SortingService sortingService;
	
	@GetMapping(path = "/test")
	public ResponseEntity<Object> test(@RequestBody RequestInputDTO dto) {
		if(dto.getList1() == null || dto.getList2() == null || (dto.getList1().isEmpty() && dto.getList2().isEmpty())) {
			throw new InvalidInput("In valid Input");
		}
		List<Integer> sortedList = sortingService.listSorting(dto);
		ResponseEntity<Object> re = new ResponseEntity<>(sortedList, HttpStatus.OK);
		return re;
	}

}
