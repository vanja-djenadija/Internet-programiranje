package app.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import app.beans.MeetingBean;
import app.dto.Meeting;

@Path("/rest")
public class RESTConsumer {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		return "HELLO";
	}

	@GET
	@Path("/{username}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Meeting> getByUsernameDate(@PathParam("username") String username,
			@PathParam("date") String date) {
		ArrayList<Meeting> filtered = new ArrayList<Meeting>();
		try {
			ArrayList<Meeting> meetings = (ArrayList<Meeting>) new MeetingBean().getAll(username);
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			for (Meeting m : meetings) {
				if (m.getDate().equals(d))
					filtered.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filtered;

	}
}
