package com.challenge.minesweeper.dto;

public class EventDto {
	
	public enum Event {
		LEFT_CLICK, RIGHT_CLICK
	}
	
	Integer row;
	Integer column;
	Event event;
	
	public EventDto() {
		
	}
	
	public EventDto(Integer row, Integer column, Event event) {
		this.row = row;
		this.column = column;
		this.event = event;
	}
	
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	

}
