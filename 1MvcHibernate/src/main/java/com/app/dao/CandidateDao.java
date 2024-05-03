package com.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.app.entity.Candidate;

@Component
public class CandidateDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	// create
	@Transactional
	public void createCandidate(Candidate candidate) {

		this.hibernateTemplate.save(candidate);

	}

	
	
}



