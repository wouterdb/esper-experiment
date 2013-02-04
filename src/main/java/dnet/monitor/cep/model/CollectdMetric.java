package dnet.monitor.cep.model;

import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class CollectdMetric {

	private Date time;
	private String host,plugin,pluginI,type,typeI;
	private float[] values;
	private String opts;

	public CollectdMetric(String name, String opts, String vals) {
		super();
		parseID(name);
		this.opts = opts;
		parseVals(vals);
	}

	private void parseVals(String vals) {
		StringTokenizer st = new StringTokenizer(vals,":");
		String time = st.nextToken();
		
		this.time = new Date(Long.parseLong(time.replaceAll("\\.","")));
		values = new float[st.countTokens()];
		for (int i = 0; i < values.length; i++) {
			values[i]=Float.parseFloat(st.nextToken());
		}	
	}

	private void parseID(String id) {
		StringTokenizer st = new StringTokenizer(id,"/");
		this.host=st.nextToken();
		String[] plug = st.nextToken().split("-",2);
		this.plugin = plug[0];
		if(plug.length>1)
			this.pluginI = plug[1];
		String[] type = st.nextToken().split("-",2);
		this.type=type[0];
		if(type.length>1)
			this.typeI = type[1];		
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

	public float[] getValues() {
		return values;
	}

	public String getOpts() {
		return opts;
	}

	@Override
	public String toString() {
		return "Metric [time=" + time + ", host=" + host + ", plugin=" + plugin
				+ ", pluginI=" + pluginI + ", type=" + type + ", typeI="
				+ typeI + ", values=" + Arrays.toString(values) + ", opts="
				+ opts + "]";
	}
	
	

}
