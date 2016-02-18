package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);

}

/*
 * For Reference 
@RepositoryRestResource(collectionResourceRel="people", path="people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
	
	public Page<Person> findByLastName(@Param("name") String name, Pageable pageable);
	
	public List<Person> findByLastNameStartsWith(@Param("name") String name);
	
} */

