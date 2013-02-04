package dnet.monitor.cep;


import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EsperPump {
	
	public static void main(String[] args) throws IOException {
		 ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    factory.setUsername("guest");
		    factory.setPassword("guest");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    
		    channel.exchangeDeclare("metrics", "direct");
		    for(int i = 0;i<10;i++){
		    	
		    	channel.basicPublish("metrics", "metrics", null, "1 key value".getBytes());
		    }
		    channel.close();
	}

}
