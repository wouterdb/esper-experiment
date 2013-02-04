package dnet.monitor.cep;

import static org.junit.Assert.*;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import dnet.monitor.cep.model.Metric;

public class AMQPJsonToMetricTest {

	@Test
	public void test() throws ParseException {
		String line = "{\"value_name\": \"read\", \"plugin\": \"disk\", \"interval\": 10.0, \"value\": 0, \"host\": \"verdana.cs.kuleuven.be\", \"time\": 1350567949, \"plugin_instance\": \"sda3\", \"statname\": \"disk.sda3.disk_ops.read\", \"type\": \"disk_ops\"}";
		
		Metric m = new AMQPJsonToMetric().parseLine(line);
		
		System.out.println(m);
	}

}
