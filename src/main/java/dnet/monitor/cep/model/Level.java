package dnet.monitor.cep.model;

public enum Level {
	
	OK("OK"),WARN("WARN"),ALERT("alert");
	
	private final String level;
	
	private Level(String name){
		this.level = name;
	}

	public String getLevel() {
		return level;
	}

}
