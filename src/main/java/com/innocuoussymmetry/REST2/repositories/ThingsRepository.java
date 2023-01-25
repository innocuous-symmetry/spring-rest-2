package com.innocuoussymmetry.REST2.repositories;

import com.innocuoussymmetry.REST2.models.Thing;
import org.springframework.data.repository.CrudRepository;

public interface ThingsRepository extends CrudRepository<Thing, Integer> { }
