package dnet.monitor.cep.model;

import java.util.Date;

public class Alert {

	String host;
	String type;
	float value;
	String level;
	Date time;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Alert [host=" + host + ", type=" + type + ", value=" + value
				+ ", level=" + level + ", time=" + time + "]";
	}
	

	
}
