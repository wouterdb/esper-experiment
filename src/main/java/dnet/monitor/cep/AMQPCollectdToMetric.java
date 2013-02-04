package dnet.monitor.cep;

import java.text.DateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import com.espertech.esperio.amqp.AMQPToObjectCollector;
import com.espertech.esperio.amqp.AMQPToObjectCollectorContext;

import dnet.monitor.cep.model.CollectdMetric;

public class AMQPCollectdToMetric implements AMQPToObjectCollector{
	
	public void collect(AMQPToObjectCollectorContext ctx) {
		String s = new String(ctx.getBytes());
		
		ctx.getEmitter().submit(parseLine(s));
	}

	CollectdMetric parseLine(String s) {
		StringTokenizer st = new StringTokenizer(s.trim()," ");
		String pv = st.nextToken();
		assert(pv.equals("PUTVAL"));
		String name = st.nextToken();
		String opts = st.nextToken();
		String vals = st.nextToken();
		
		return new CollectdMetric(name,opts,vals);
	}

}
