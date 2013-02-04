package dnet.monitor.cep;


import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;

public class AMQPDump {
	
	public static void main(String[] args) throws IOException {
		 ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("verdana");
		    factory.setUsername("guest");
		    factory.setPassword("guest");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    
		    String queue = channel.queueDeclare().getQueue();
		    channel.queueBind(queue, "metrics", "");
		    channel.basicConsume(queue, new Consumer() {
				
				public void handleShutdownSignal(String consumerTag,
						ShutdownSignalException sig) {
					// TODO Auto-generated method stub
					
				}
				
				public void handleRecoverOk(String consumerTag) {
					// TODO Auto-generated method stub
					
				}
				
				public void handleDelivery(String arg0, Envelope arg1,
						BasicProperties arg2, byte[] arg3) throws IOException {
					System.out.println(new String(arg3));
					System.out.println("--------------");
				}
				
				public void handleConsumeOk(String consumerTag) {
					// TODO Auto-generated method stub
					
				}
				
				public void handleCancelOk(String consumerTag) {
					// TODO Auto-generated method stub
					
				}
				
				public void handleCancel(String consumerTag) throws IOException {
					// TODO Auto-generated method stub
					
				}
			});
		    
	}

}
