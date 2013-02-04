package dnet.monitor.cep;

import java.io.IOException;
import java.util.Date;

import javax.naming.OperationNotSupportedException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.espertech.esper.epl.metric.MetricsExecutor;
import com.espertech.esperio.amqp.AMQPToObjectCollector;
import com.espertech.esperio.amqp.AMQPToObjectCollectorContext;

import dnet.monitor.cep.model.Metric;


public class AMQPJsonToMetric implements AMQPToObjectCollector{

	
	
	public void collect(AMQPToObjectCollectorContext context) {
		String json = new String(context.getBytes());
			
		try {
			context.getEmitter().submit(parseLine(json));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	Metric parseLine(String json) throws ParseException {
		JSONParser parser=new JSONParser();
		JSONObject p = (JSONObject) parser.parse(json);
		
		return new Metric(new Date((Long)p.get("time")*1000),
						 (String)p.get("host"), 
						 (String)p.get("plugin"),
						 (String)p.get("plugin_instance"),
						 (String)p.get("type"),
						 (String)p.get("statname"),
						 (String)p.get("value_name"),
						 ((Number)p.get("value")).floatValue(),
						 ((Number)p.get("interval")).intValue());
	}

}
