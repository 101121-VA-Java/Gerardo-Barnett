package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Videogame;

public interface VideogameDao{
	
	Videogame getVideogameById(int id);
	List<Videogame> getVideogames();
	int addVideogame(Videogame videogame);
	boolean updateVideogame(Videogame videogame);
	int deleteVideogame(int id);

}
