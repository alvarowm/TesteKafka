package br.alvaro.testekafka;

import java.util.Properties;

import org.apache.kafka.common.serialization.StringDeserializer;

public class Prop {

	Properties props;

	public Prop () {
		this.props = new Properties();
		props.put("enable.auto.commit", "true");
		props.put("group.id", "test");
		props.put("auto.commit.interval.ms", "1100");
		props.put("session.timeout.ms", "3300");
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.deserializer", StringDeserializer.class.getName());
		props.put("value.deserializer", StringDeserializer.class.getName());
	}

	public Properties getProps() {
		return props;
	}

}
