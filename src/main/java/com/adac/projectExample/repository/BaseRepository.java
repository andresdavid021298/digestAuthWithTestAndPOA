package com.adac.projectExample.repository;

import java.util.List;

public interface BaseRepository<Model> {

	Model getById(String id);
	List<Model> getAll();
	void addOrUpdate(Model newModel);
	void delete(String id);
	
}
