package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Videogame;

public class VideogameList implements VideogameDao{

	public List<Videogame> videogames = new ArrayList<Videogame>();
	
	
	
	
	public VideogameList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VideogameList(List<Videogame> videogames) {
		
		super();
		this.videogames = videogames;
	}

	@Override
	public Videogame getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videogame> getAll() {
		// TODO Auto-generated method stub
		return this.videogames;
	}

	@Override
	public int add(Videogame c) {
		// TODO Auto-generated method stub
		videogames.add(c);
		return c.getId();
		}

	@Override
	public boolean edit(Videogame c) {
		// TODO Auto-generated method stub
		for (Videogame v : videogames) {
			if (v.getId() == c.getId() && !v.equals(c)) {
				videogames.set(c.getId(), c);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
