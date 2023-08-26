package app.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Meeting implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String date;
	private String topic;
	private String location;

	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meeting(String name, String date, String topic, String location) {
		super();
		this.name = name;
		this.date = date;
		this.topic = topic;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, location, name, topic);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meeting other = (Meeting) obj;
		return Objects.equals(date, other.date) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && Objects.equals(topic, other.topic);
	}

	@Override
	public String toString() {
		return "Meeting [name=" + name + ", date=" + date + ", topic=" + topic + ", location=" + location + "]";
	}
	
	

}
