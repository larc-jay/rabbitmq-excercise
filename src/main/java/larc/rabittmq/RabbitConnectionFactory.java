package larc.rabittmq;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitConnectionFactory {
	private static Connection conn = null; 
	private static Channel channel = null;
	private static Map<String,Channel> channelMap = new HashMap<String,Channel>();
	public void init(){
			}
	public static Connection getConnection() throws TimeoutException{
		if(conn == null || !conn.isOpen()){
			ConnectionFactory factory = new ConnectionFactory();
			String hostLs = "localhost";
			if(hostLs == null)
				return null;
			String[] hostArr = hostLs.split(",");
			Address[] addrArr = new Address[hostArr.length];
			for(int i = 0 ; i < hostArr.length; i++){
				addrArr[i]= new Address(hostArr[i], Integer.parseInt("9090"));
			}
			try {
				List<Address> addrLs = Arrays.asList(addrArr);
				Collections.shuffle(addrLs);
				conn =  factory.newConnection(addrLs.toArray(addrArr));
				System.out.println("Connected to rabbitmq.");
				return conn;
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static Connection getConnection(String host, int port) throws TimeoutException{
		if(host == null || port < 0){
			return null;
		}
		if(conn == null || !conn.isOpen()){
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(host);
			factory.setPort(port);
			try {
				conn =  factory.newConnection();
				return conn;
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public  static Channel getChannel(Connection conn){
		if(conn == null)
			return null;
		if(channel == null || !channel.isOpen()){
			try {
				channel = conn.createChannel();
				return channel;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return channel;
	}
	
	public  static Channel getChannel(String queueName, Connection conn){
		if(conn == null || queueName == null)
			return null;
		if(channelMap.get(queueName) == null || !channelMap.get(queueName).isOpen()){
			try {
				Channel tmp = conn.createChannel();
				tmp.queueDeclare(queueName, true, false, false, null);
				channelMap.put(queueName, tmp) ;
				return tmp;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return channelMap.get(queueName);
	}
	
	public  static void closeChannel(Channel channel) throws TimeoutException{
		if(channel != null){
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Connection conn){
		if(conn != null && conn.isOpen()){
			try {
				conn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeConnection(){
		if(conn != null && conn.isOpen()){
			try {
				conn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public  static boolean exchangeDeclare(Channel channel, String exchangeName, String type, boolean isDurable){
		if(exchangeName == null || type == null)
			return false;
		try {
			channel.exchangeDeclare(exchangeName, type, isDurable);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public  static Channel exchangeDeclare(String exchangeName, String type, boolean isDurable) throws TimeoutException{
		if(exchangeName == null || type == null)
			return null;
		try {
			if(channel == null || !channel.isOpen()){
				channel = getChannel(getConnection());
			}
			channel.exchangeDeclare(exchangeName, type);
			
			return channel;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Channel getChannel(String queueName) throws TimeoutException{
		try {
			Channel channel = RabbitConnectionFactory.getChannel(queueName,RabbitConnectionFactory.getConnection());
			if(channel == null)
				return null;
			channel.basicQos(1);
			return channel;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
