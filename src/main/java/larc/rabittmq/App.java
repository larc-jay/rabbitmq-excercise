package larc.rabittmq;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import larc.rabittmq.obj.Parent;
public class App 
{
	private final static String QUEUE_NAME = "facebook_post";
	private static Connection conn = null; 
	private static Channel channel = null;
	public static void main( String[] args ) throws IOException, TimeoutException
	{
		getMessags();
		//readMessage();
	}
	private static Channel conn() throws IOException, TimeoutException{
		if(channel == null || !channel.isOpen()){
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		}
		return channel;
	}
	
	private static boolean sendMessage(JsonObject data) throws IOException, TimeoutException{
		try{
			ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		    channel.basicPublish("", QUEUE_NAME, null, data.toString().getBytes("UTF-8"));
		    channel.close();
		    connection.close();
		    return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	private static void getMessags() throws IOException, TimeoutException{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
					throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}


	//D:\FacebookCrawling\top50posts\output

	private  static void readMessage() throws JsonParseException, JsonMappingException, IOException, TimeoutException{
		ObjectMapper mapper = new ObjectMapper(); 
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try (Stream<Path> filePathStream=Files.walk(Paths.get("D:\\output"))) {
			filePathStream.forEach(filePath -> {
				if (Files.isRegularFile(filePath) && filePath.toString().endsWith(".json")) {
					try {
						Parent data = mapper.readValue(new File(filePath.toString()),  new TypeReference<Parent>(){});
						JsonObject json = new JsonObject();
						json.addProperty("accountType", data.getAccountTypes());
						json.addProperty("profileUrl", data.getProfileUrl());
						json.addProperty("screenUrl", data.getScreenNameUrl());
						json.addProperty("postCount", data.getPostCount());
						json.addProperty("name", data.getName());
						if(sendMessage(json)){
							System.out.println(data.getScreenName());
							Thread.sleep(2000);
						}else{
							System.out.println("Data not added in queue");
						}
					}catch(Exception e){
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				}else{
					System.out.println("File already processed ");
				}
			});
		}catch (Exception e) {
			 
		}finally{
			//channel.close();
			//conn.close();
		}
	}
	
	 
}
