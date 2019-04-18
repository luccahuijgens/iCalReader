package iotalarm.domain;

import java.util.Date;

public class Event {
private int id;
private String title;
private String location;
private Date date;

public Event(int id, String title, String location, Date date) {
	super();
	this.id = id;
	this.title = title;
	this.location = location;
	this.date = date;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}



}
