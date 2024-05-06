package io.javabrains.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CachingService {

	public List<String> getList(){
		return Arrays.asList("hima","bindu","vadlamani","hbv");
	}
}
