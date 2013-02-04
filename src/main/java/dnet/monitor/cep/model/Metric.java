package dnet.monitor.cep.model;

import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class Metric {

	private Date time;
	private String host,plugin,pluginI,type,typeI, valueName;
	private float value;
	private int interval;

	public Metric(){}

	public Metric(Date time, String host, String plugin, String pluginI,
			String type, String typeI, String valueName, float value, int interval) {
		super();
		this.time = time;
		this.host = host;
		this.plugin = plugin;
		this.pluginI = pluginI;
		this.type = type;
		this.typeI = typeI;
		this.valueName = valueName;
		this.value = value;
	}

	public Date getTime() {
		return time;
	}

	public String getHost() {
		return host;
	}

	public String getPlugin() {
		return plugin;
	}

	public String getPluginI() {
		return pluginI;
	}

	public String getType() {
		return type;
	}

	public String getTypeI() {
		return typeI;
	}

	public float getValue() {
		return value;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}

	public void setPluginI(String pluginI) {
		this.pluginI = pluginI;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTypeI(String typeI) {
		this.typeI = typeI;
	}

	public void setValue(float value) {
		this.value = value;
	}

	
	

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((plugin == null) ? 0 : plugin.hashCode());
		result = prime * result + ((pluginI == null) ? 0 : pluginI.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeI == null) ? 0 : typeI.hashCode());
		result = prime * result + Float.floatToIntBits(value);
		result = prime * result
				+ ((valueName == null) ? 0 : valueName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Metric other = (Metric) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (plugin == null) {
			if (other.plugin != null)
				return false;
		} else if (!plugin.equals(other.plugin))
			return false;
		if (pluginI == null) {
			if (other.pluginI != null)
				return false;
		} else if (!pluginI.equals(other.pluginI))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeI == null) {
			if (other.typeI != null)
				return false;
		} else if (!typeI.equals(other.typeI))
			return false;
		if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
			return false;
		if (valueName == null) {
			if (other.valueName != null)
				return false;
		} else if (!valueName.equals(other.valueName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Metric [time=" + time + ", host=" + host + ", plugin=" + plugin
				+ ", pluginI=" + pluginI + ", type=" + type + ", typeI="
				+ typeI + ", valueName=" + valueName + ", value=" + value + "]";
	}


}
