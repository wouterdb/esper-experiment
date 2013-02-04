package dnet.monitor.cep;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPServiceDestroyedException;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.client.deploy.DeploymentException;
import com.espertech.esper.client.deploy.ParseException;
import com.espertech.esperio.amqp.AMQPSource;

import dnet.monitor.cep.model.Alert;
import dnet.monitor.cep.model.Alerts;
import dnet.monitor.cep.model.Metric;

public class EsperTest {
	
	public static void main(String[] args) throws EPServiceDestroyedException, IOException, ParseException, DeploymentException {
		Configuration config = new Configuration();
		//config.configure("configuration.xml");
		
		config.addImport(AMQPSource.class.getPackage().getName() + ".*");
		config.addImport(Alerts.class);
		config.addEventType("metric", Metric.class);
		config.addEventType("alert", Alert.class);
		//config.addEventType("collectdmetric", CollectdMetric.class);
		
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
		epService.initialize();
		
		epService.getEPAdministrator().getDeploymentAdmin().readDeploy("core.epl",null,null,null);
		epService.getEPAdministrator().getDeploymentAdmin().readDeploy("rules.epl",null,null,null);
		
		File f = new File("rules.epl");
		if(f.exists())
			epService.getEPAdministrator().getDeploymentAdmin().readDeploy(new FileInputStream(f), null, null, null);
		
		
		/*epService.getEPAdministrator().createEPL("select host,count(host) from metric.win:time_batch(10 sec) group by host").addListener(new UpdateListener() {
			
			public void update(EventBean[] newEvents, EventBean[] oldEvents) {
				for (int i = 0; i < newEvents.length; i++) {
					System.out.println("flowrate:" +newEvents[i].getUnderlying());
				}
				
			}
		});*/
		
		
		
		
		epService.getEPAdministrator().createEPL("select * from flaps").addListener(new UpdateListener() {
			
			public void update(EventBean[] newEvents, EventBean[] oldEvents) {
				for (int i = 0; i < newEvents.length; i++) {
					System.out.println("Flaps:" +newEvents[i].getUnderlying());
				}
				
			}
		});;
		
		epService.getEPAdministrator().createEPL("select * from alert").addListener(new UpdateListener() {
			
			public void update(EventBean[] newEvents, EventBean[] oldEvents) {
				for (int i = 0; i < newEvents.length; i++) {
					System.out.println("alert:" +newEvents[i].getUnderlying());
				}
				
			}
		});
		
		/*epService.getEPAdministrator().createEPL("select * from changes").addListener(new UpdateListener() {
			
			public void update(EventBean[] newEvents, EventBean[] oldEvents) {
				for (int i = 0; i < newEvents.length; i++) {
					System.out.println("change:" +newEvents[i].getUnderlying());
				}
				
			}
		});*/

		epService.getEPRuntime().getDataFlowRuntime().instantiate("MetricsOut").start();

		epService.getEPRuntime().getDataFlowRuntime().instantiate("MetricsIn").start();
		
		  
		
	}

}
