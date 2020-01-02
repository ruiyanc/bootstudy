package rui.chapter;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerStart {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "yanrui";
    public static void main(String[] args) {
        Properties properties = new Properties();
        //设置key序列化起
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //设置重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        //设置值序列化器
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //设置集群地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "kafka-demo", "hello kafka");
        try {
            Future<RecordMetadata> send = producer.send(record);
            RecordMetadata recordMetadata = send.get();
            System.out.println("topic:" + recordMetadata.topic());
            System.out.println("partition:" + recordMetadata.partition());
            System.out.println("offset:" + recordMetadata.offset());

            //异步发送
            producer.send(record,  (RecordMetadata metadata, Exception exception) -> {
                if (exception == null) {
                    System.out.println(metadata.partition() + ":" + metadata.offset());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }
}
