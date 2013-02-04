package wdb.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class WebSockets extends WebSocketServer implements Consumer{

	private Connection connection;
	private Channel channel;
	private Set<WebSocket> openSockets = new HashSet<WebSocket>();
	
	
	public static void main(String[] args) throws IOException {
		new WebSockets();
	}
	
	public WebSockets() throws IOException{
		super(new InetSocketAddress(8887));
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("192.168.122.159");
	    factory.setUsername("guest");
	    factory.setPassword("guest");
	    connection = factory.newConnection();
	    channel = connection.createChannel();
	    
	    String queue = channel.queueDeclare().getQueue();
	    channel.queueBind(queue, "logs", "");
	    
	    channel.basicConsume(queue, this);
	    start();
	}

	@Override
	public synchronized void onClose(WebSocket arg0, int arg1, String arg2, boolean arg3) {
		openSockets.remove(arg0);
	}

	@Override
	public synchronized void onError(WebSocket arg0, Exception ex) {
		ex.printStackTrace();
		openSockets.remove(arg0);
	}

	@Override
	public void onMessage(WebSocket arg0, String arg1) {
		System.out.println(arg1);
	}

	@Override
	public synchronized void onOpen(WebSocket arg0, ClientHandshake arg1) {
		openSockets.add(arg0);
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

	public synchronized void handleDelivery(String consumerTag, Envelope envelope,
			BasicProperties properties, byte[] body) throws IOException {
		String msg = new String(body);
		for (WebSocket s : openSockets) {
			s.send(msg);
		}
	}

	public void handleShutdownSignal(String consumerTag,
			ShutdownSignalException sig) {
		for (WebSocket s : openSockets) {
			s.close(0);
		}
		
	}

	public void handleRecoverOk(String consumerTag) {
		// TODO Auto-generated method stub
		
	}

}
