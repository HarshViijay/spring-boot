package com.spring.ormnew.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.ormnew.entities.Student;

import jakarta.transaction.Transactional;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student)
	{
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
