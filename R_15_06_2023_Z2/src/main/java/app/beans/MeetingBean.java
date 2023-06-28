package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.dto.Meeting;

public class MeetingBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static HashMap<String, List<Meeting>> meetings = new HashMap<>();

	public boolean add(String username, Meeting meeting) {
		List<Meeting> userMeetings = meetings.get(username);
	    
	    // If the user doesn't have any meetings yet, create a new list
	    if (userMeetings == null) {
	        userMeetings = new ArrayList<>();
	        meetings.put(username, userMeetings);
	    }
	    
	    // Add the meeting to the user's list
	    boolean added = userMeetings.add(meeting);
	    
	    // Return true if the meeting was successfully added
	    return added;
	}

	public List<Meeting> getAll(String username) {
		return meetings.getOrDefault(username, new ArrayList<>());
	}

	public boolean remove(String username, Meeting meeting) {
		if (meetings.containsKey(username)) {
			meetings.get(username).remove(meeting);
			return true;
		}
		return false;
	}

	public int numberOfMeetings(String username) {
		if (meetings.get(username) == null)
			return 0;
		return meetings.get(username).size();
	}
}
