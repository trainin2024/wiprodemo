package com.example.demo.dto;


	public class CustomerDTO {
	    private Long id;
	    private String name;

	    // Default constructor
	    public CustomerDTO() {
	    }

	    // Constructor with parameters
	    public CustomerDTO(Long id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    // Getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

		@Override
		public String toString() {
			return "CustomerDTO [id=" + id + ", name=" + name + "]";
		}
	    
	}