package br.com.tresdaniel.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tresdaniel.data.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
