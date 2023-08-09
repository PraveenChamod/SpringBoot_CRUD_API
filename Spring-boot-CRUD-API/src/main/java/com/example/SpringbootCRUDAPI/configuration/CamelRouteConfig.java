package com.example.SpringbootCRUDAPI.configuration;

import org.apache.camel.Configuration;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringbootCRUDAPI.service.EventService;

@Configuration
public class CamelRouteConfig extends RouteBuilder {
	@Autowired
	private EventService eventService;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		restConfiguration().component("servlet");
		
		rest("/events")
			.get()
				.to("direct:getAllEvents")
			.get("/{eventId}")
				.to("direct:getEventById")
			.post()
				.to("direct:createEvent")
			.post("/{eventId}")
				.to("direct:updateEvent")
			.delete("/{eventId}")
				.to("direct:deleteEvent");
				
		from("direct:getAllEvents")
			.setBody()
				.method(eventService, "getAllEvents");
		
		from("direct:getUserById")
        	.setBody()
            	.method(eventService, "getEventById(${header.eventId})");
		
		from("direct:createEvent")
			.setBody()
				.method(eventService, "createEvent");
		
		from("direct:updateEvent")
			.setBody()
				.method(eventService, "createEvent(${header.eventId})");
		
		from("direct:deleteEvent")
			.setBody()
				.method(eventService, "deleteEvent(${header.eventId})");
	}

}
