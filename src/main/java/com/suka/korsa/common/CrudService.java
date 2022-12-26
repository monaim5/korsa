package com.suka.korsa.common;

import java.util.List;

public interface CrudService<E, D> {
	E create(D dto);
	E retrieve(String id);
	E update(String id, D Dto);
	void delete(String id);
	List<E> list();


}
