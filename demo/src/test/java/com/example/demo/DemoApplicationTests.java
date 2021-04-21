package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.ListSortController;
import com.example.demo.service.SortingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DemoApplicationTests {

	private MockMvc mockMvc;

	@InjectMocks
	private ListSortController listSortController;

	@MockBean
	private SortingService sortingservice;

	private RequestInputDTO requestInputDTO;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(listSortController).build();

	}

	@Test
	public void possitiveTest() throws Exception {
		List<Integer> list1 = Arrays.asList(11, 3, 51);
		List<Integer> list2 = Arrays.asList(13, 35, 5);
		requestInputDTO = new RequestInputDTO();
		requestInputDTO.setList1(list1);
		requestInputDTO.setList2(list2);

		when(sortingservice.listSorting(requestInputDTO)).thenReturn(new ArrayList<Integer>());
		mockMvc.perform(MockMvcRequestBuilders.get("/test").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(requestInputDTO))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void negativeTest1() throws Exception {
		requestInputDTO = new RequestInputDTO();
		requestInputDTO.setList1(null);
		requestInputDTO.setList2(null);

		when(sortingservice.listSorting(requestInputDTO)).thenReturn(new ArrayList<Integer>());
		mockMvc.perform(MockMvcRequestBuilders.get("/test").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(requestInputDTO))).andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void negativeTest2() throws Exception {
		requestInputDTO = new RequestInputDTO();
		List<Integer> list2 = Arrays.asList(13, 35, 5);
		requestInputDTO.setList1(null);
		requestInputDTO.setList2(list2);

		when(sortingservice.listSorting(requestInputDTO)).thenReturn(new ArrayList<Integer>());
		mockMvc.perform(MockMvcRequestBuilders.get("/test").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(requestInputDTO))).andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void negativeTest3() throws Exception {
		requestInputDTO = new RequestInputDTO();
		List<Integer> list1 = Arrays.asList();
		List<Integer> list2 = Arrays.asList();
		requestInputDTO.setList1(list1);
		requestInputDTO.setList2(list2);

		when(sortingservice.listSorting(requestInputDTO)).thenReturn(new ArrayList<Integer>());
		mockMvc.perform(MockMvcRequestBuilders.get("/test").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(requestInputDTO))).andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}

	private static String asJsonString(final Object obj) {
		try {
			String jsonObject = new ObjectMapper().writeValueAsString(obj);
			return jsonObject;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
