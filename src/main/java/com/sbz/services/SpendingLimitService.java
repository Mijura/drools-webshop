package com.sbz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.models.SpendingLimit;
import com.sbz.repository.SpendingLimitRepository;

@Service
public class SpendingLimitService {

	@Autowired
	private SpendingLimitRepository repository;

	public void saveAll(List<SpendingLimit> limits) {
		repository.save(limits);
	}
}
