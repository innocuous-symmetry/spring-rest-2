package com.innocuoussymmetry.REST2.repositories;

import com.innocuoussymmetry.REST2.models.Stuff;
import org.springframework.data.repository.CrudRepository;
import java.sql.*;

public interface StuffRepository extends CrudRepository<Stuff, Integer> { }
