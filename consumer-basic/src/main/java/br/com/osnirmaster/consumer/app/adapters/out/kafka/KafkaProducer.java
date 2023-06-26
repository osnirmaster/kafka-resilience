package br.com.osnirmaster.consumer.app.adapters.out.kafka;

import br.com.osnirmaster.consumer.app.domain.CreditContract;
import br.com.osnirmaster.consumer.app.domain.Quote;
import br.com.osnirmaster.consumer.app.domain.service.CommandBroker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class KafkaProducer implements CommandBroker {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, CommandCalculationSchemaJson> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, CommandCalculationSchemaJson> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CommandCalculationSchemaJson command) throws ExecutionException, InterruptedException {
        log.info("Payload: {}", command);
        CompletableFuture<SendResult<String, CommandCalculationSchemaJson>> future =
                kafkaTemplate.send(topicName, command.getCreditContract().getCreditAgreementId(), command);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Result: {}, {}, {}, {}", result.getProducerRecord().key(),
                        result.getProducerRecord().headers(),
                        result.getProducerRecord().topic(),
                        result.getProducerRecord().hashCode());

                log.info("Sent message=[" + command +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                log.error("Unable to send message=[" +
                        command + "] due to : " + ex.getMessage());
            }
        });
    }

    @Override
    public void sendCommand(Quote quote) throws ExecutionException, InterruptedException {
        for (CreditContract contract : quote.getCreditContracts()){
            CommandCalculationSchemaJson command = new CommandCalculationSchemaJson(quote);
            command.addCreditContract(contract);
            sendMessage(command);
        }
    }
}
