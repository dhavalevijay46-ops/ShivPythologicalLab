package com.example;

import org.springframework.stereotype.Service;

import jakarta.persistence.*;

@Entity
@Table(name = "patient") // 🔥 important
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String gender;
    private String phone;
    private String Type;
    public Patient(Long id, String name, int age, String gender, String phone, String type, String status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		Type = type;
		this.status = status;
	}
	private String status;
    

    // Constructors
    public Patient() {}

    public Patient(String name, int age, String gender, String phone, String status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}