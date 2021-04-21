package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.RequestInputDTO;

@Service
public class SortingService {
	public List<Integer> listSorting(RequestInputDTO dto) {
		List<Integer> merged = new ArrayList<>();
		merged.addAll(dto.getList1());
		merged.addAll(dto.getList2());
		Collections.sort(merged);
		return merged;
	}
}
