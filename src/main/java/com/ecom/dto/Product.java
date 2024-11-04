package com.ecom.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Component
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min=3,max=20 , message = "* Enter Charecters between 3~20")
	private String name;
	
	@NotNull(message = "*Enter proper price ")
	@DecimalMax(value = "100000" ,message = "*Enter below 1L/-")
	@DecimalMin(value = "1",message = "*Enter Above 1/-")
	private double price;
	
	@NotNull(message = "*Enter proper value ")
	@DecimalMax(value = "10000" ,message = "*Enter below 10k")
	@DecimalMin(value = "1",message = "*Enter Above 1")
	private int stock;
	
	@Size(min=5,max=100,message = "Enter Between 5~100 words")
	private String description;
	
	private String imageLink;
	
	@NotEmpty(message = "*Enter Something")
	private String category;
	private boolean approved;
	
	@ManyToOne
	Seller seller;
	public int getQuantity(List<Item> items)
	{
		int quantity=0;
		if(items==null)
			return quantity;
		else {
		for(Item item:items)
		{
			if(this.name.equals(item.getName()))
				quantity=item.getQuantity();
		}
		return quantity;
		}
	}
}
