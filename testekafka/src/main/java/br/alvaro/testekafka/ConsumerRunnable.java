package br.alvaro.testekafka;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerRunnable implements Runnable {

	private static final String HELLO_KAFKA = "Hello-Kafka";
	private KafkaConsumer<Long, String> consumidor = null;

	public ConsumerRunnable() {
		Prop prop = new Prop();
		this.consumidor = new KafkaConsumer<Long, String>(prop.getProps());
	}

	public void run() {
		List<String> topicos = new ArrayList<String>();
		//https://www.tutorialspoint.com/apache_kafka/index.htm
		topicos.add(HELLO_KAFKA);

		try {
			this.consumidor.subscribe(topicos);
			
			System.out.println("Consumindo do tópico: " + topicos.get(0));

			while (true) {
				System.out.println("Trabalhando...");
				ConsumerRecords<Long, String> records = consumidor.poll(100);
				for (ConsumerRecord<Long, String> record : records) {
					System.out.println(record.value());
				}
			}
		} catch (Exception e) {
		consumidor.close(); 
	} finally {
		consumidor.close();
	}

}

}
