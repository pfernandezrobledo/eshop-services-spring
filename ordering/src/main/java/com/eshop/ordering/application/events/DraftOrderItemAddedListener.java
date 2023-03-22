package com.eshop.ordering.application.events;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.eshop.ordering.domain.events.DraftOrderItemAdded;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DraftOrderItemAddedListener {
    
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void handle(DraftOrderItemAdded eventObject) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        String orderJson = mapper.writerWithDefaultPrettyPrinter()
                                 .writeValueAsString(eventObject.getOrder());

        log.info("ORDER JSON: DraftOrderItemAddedListener");
        log.info(orderJson);
    }
}
