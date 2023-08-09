package com.example.SpringbootCRUDAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SpringbootCRUDAPI.entity.EventEntity;
import com.example.SpringbootCRUDAPI.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	EventRepository eventRepository;
	
	public ResponseEntity<List<EventEntity>> getAllEvents(){
		try {
			List<EventEntity> eventList = new ArrayList<>();
			eventRepository.findAll().forEach(eventList::add);
			
			if(eventList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(eventList, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<EventEntity> getEventById(@PathVariable UUID eventId){
		try {
			EventEntity eventObj = eventRepository.findById(eventId).orElse(null);
			
			if(eventObj != null) {
				// have to return eventObj here
				return new ResponseEntity<>(eventObj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<EventEntity> createEvent(@RequestBody EventEntity event){
		try {
			EventEntity eventObj = eventRepository.save(event);
			return new ResponseEntity<>(eventObj, HttpStatus.CREATED);
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<EventEntity> updateEvent(@PathVariable UUID eventId, @RequestBody EventEntity updatedEvent){
		try {
			EventEntity event = eventRepository.findById(eventId).orElse(null);
			
			if(event != null) {
				event.setTransId(updatedEvent.getTransId());
	            event.setTransTms(updatedEvent.getTransTms());
	            event.setRcNum(updatedEvent.getRcNum());
	            event.setClientId(updatedEvent.getClientId());
	            event.setEventCnt(updatedEvent.getEventCnt());
	            event.setLocationCd(updatedEvent.getLocationCd());
	            event.setLocationId1(updatedEvent.getLocationId1());
	            event.setLocationId2(updatedEvent.getLocationId2());
	            event.setAddrNbr(updatedEvent.getAddrNbr());
	            
				EventEntity updatedEventObj = eventRepository.save(event);
				
				return new ResponseEntity<>(updatedEventObj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<EventEntity> deleteEvent(@PathVariable UUID eventId){
		try {
			EventEntity event = eventRepository.findById(eventId)
	                .orElse(null);

	        if (event != null) {
	            eventRepository.delete(event);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
		} catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
