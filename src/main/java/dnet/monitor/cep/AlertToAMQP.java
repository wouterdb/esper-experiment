package dnet.monitor.cep;

import com.espertech.esperio.amqp.ObjectToAMQPCollector;
import com.espertech.esperio.amqp.ObjectToAMQPCollectorContext;

import dnet.monitor.cep.model.Alert;

public class AlertToAMQP implements ObjectToAMQPCollector {

	public void collect(ObjectToAMQPCollectorContext context) {
		Alert alert = (Alert) context.getObject();
		context.getEmitter().send(alert.toString().getBytes());
	}

}
