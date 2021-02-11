package com.cameronsmith.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.dojooverflow.models.Tag;

public interface TagRepo extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	List <Tag> findBySubjectContaining(String search);
}
