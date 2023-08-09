package com.example.SpringbootCRUDAPI.toPojo;

import java.io.File;
import java.io.IOException;

import com.example.SpringbootCRUDAPI.entity.EventEntity;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojo {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objectmapper = new ObjectMapper();
		
		EventEntity event = objectmapper.readValue(
				new File("F:\\Randoli Assignment\\Final 2\\Spring-boot-CRUD-API\\src\\test\\resources\\sample-payload.json"), 
				EventEntity.class);
	}
}
