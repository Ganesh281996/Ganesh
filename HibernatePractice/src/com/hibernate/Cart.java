package com.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	long id;
	
	@ManyToMany(targetEntity=Item.class,cascade=CascadeType.ALL)
	@JoinTable(name="JoinedTable",
	joinColumns={@JoinColumn(name="gdghd")},
	inverseJoinColumns={@JoinColumn(name="dfhfgn")})
	List<Item> items;
}

@Entity
@Table(name="Item")
class Item
{
	@Id
	@Column(name="ItemId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	long itemId;
}