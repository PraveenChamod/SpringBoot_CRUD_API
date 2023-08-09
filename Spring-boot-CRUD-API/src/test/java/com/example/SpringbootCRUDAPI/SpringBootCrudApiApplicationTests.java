package com.example.SpringbootCRUDAPI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringbootCRUDAPI.entity.EventEntity;
import com.example.SpringbootCRUDAPI.repository.EventRepository;

@SpringBootTest
class SpringBootCrudApiApplicationTests {
	@Autowired
	EventRepository eventRepository;
	
	UUID eventId = UUID.randomUUID();

	//testing create operation
	@Test
	@Order(1)
	public void testCreate() {
		EventEntity event = new EventEntity();
		
		event.setEventId(eventId);
		event.setTransId("0000abf8-d1f5-4536-8fb0-36fe934b1f28");
		event.setTransTms("20151022102011927EDT");
		event.setRcNum("10002");
		event.setClientId("RPS-00001");
		event.setEventCnt(1);
		event.setLocationCd("DESTINATION");
		event.setLocationId1("T8C");
		event.setLocationId2("1J7");
		event.setAddrNbr("0000000001");
		
		eventRepository.save(event);
		
		assertNotNull(eventRepository.findById(eventId).get());
	}
	
	@Test
	@Order(2)
	public void testReadlAll() {
		List<EventEntity> list = eventRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testReadById() {
	    Optional<EventEntity> optionalEvent = eventRepository.findById(eventId);
	    assertThat(optionalEvent.isPresent());
	    EventEntity e = optionalEvent.get();
	    assertEquals("DESTINATION", e.getLocationCd());
	}

	
	@Test
	@Order(4)
	public void testUpdate() {
	    Optional<EventEntity> optionalEvent = eventRepository.findById(eventId);
	    assertThat(optionalEvent.isPresent());
	    EventEntity e = optionalEvent.get();
	    e.setLocationCd("DESTINATION 01");
	    eventRepository.save(e);
	    assertNotEquals("DESTINATION", eventRepository.findById(eventId).get().getLocationCd());
	}

	
	@Test
	@Order(5)
	public void testDelete() {
		eventRepository.deleteById(eventId);
		assertThat(eventRepository.existsById(eventId));
	}

}
