package io.getarrays.server.enumeration;

public enum Status {
	SERVER_UP("SERVER_UP"),
	SERVER_DOWN("SERVER_DOW");
	
	private final String status;
	
	Status(String string) {
		this.status = string;
	}
	
	public String getStatus() {
		return this.status;
	}
}
