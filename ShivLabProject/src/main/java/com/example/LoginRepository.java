package com.example;


import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository <SetData, Integer> {
	SetData findByUsername(String username);
}
