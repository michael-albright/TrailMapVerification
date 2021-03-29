package com.tts.trailMapVerification;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class HikeDetailsForm 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	@Size(min=1, max=30)
	private String name;
	
	@NotNull
	private Integer amountOfPeople;
	
	@NotNull
	@Min(0)
	@Max(7)
	private Integer nightsOnTrail;
	
	@Column
	@CreationTimestamp
	private Date startedTrailAt;
	
	public String getName() {
		return name;
	}

	public HikeDetailsForm() {
		super();
	}
	
	
	public HikeDetailsForm(@NotNull @Size(min = 1, max = 30) String name, @NotNull Integer amountOfPeople,
			@NotNull @Min(0) @Max(7) Integer nightsOnTrail, Date startedTrailAt) {
		super();
		this.name = name;
		this.amountOfPeople = amountOfPeople;
		this.nightsOnTrail = nightsOnTrail;
		this.startedTrailAt = startedTrailAt;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmountOfPeople() {
		return amountOfPeople;
	}

	public void setAmountOfPeople(Integer amountOfPeople) {
		this.amountOfPeople = amountOfPeople;
	}

	public Integer getNightsOnTrail() {
		return nightsOnTrail;
	}

	public void setNightsOnTrail(Integer nightsOnTrail) {
		this.nightsOnTrail = nightsOnTrail;
	}
	
	public Date getStartedTrailAt() {
		return startedTrailAt;
	}

	public void setStartedTrailAt(Date startedTrailAt) {
		this.startedTrailAt = startedTrailAt;
	}

	
	public String toString()
	{
		return "Details(ID: " + id + "Name: " + this.name + 
				", Number of people hiking: " + this.amountOfPeople + 
				", Nights out on trail: " + this.nightsOnTrail + 
				"Date/Time trail started: " + startedTrailAt + ")";
	}
	
}
