package com.hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue(value="test")
public class Test 
{
	
	@Id
	int id;
	String name;
}
@Entity
@DiscriminatorValue(value="a")
//@AttributeOverrides({
//	@AttributeOverride(name="id",column=@Column(name="Id"))
//})
@PrimaryKeyJoinColumn(name="Id")
class A extends Test
{
//	@OneToOne(cascade=CascadeType.ALL)
	@OneToMany(mappedBy="")
	@JoinTable(joinColumns={@JoinColumn(name="dgrsd")})
	Test t;
}