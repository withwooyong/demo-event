package com.example.demoevent.event;

import com.example.demoevent.entity.EventLog;
import com.example.demoevent.repository.EventLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberEventListener {

    private final EventLogRepository eventLogRepository;

    @EventListener
    public void defaultEventListener(SavedMemberEvent event) {
        log.info("defaultEventListener ---> {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void transactionalEventListenerBeforeCommit(SavedMemberEvent event) {
        log.info("TransactionPhase.BEFORE_COMMIT ---> {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transactionalEventListenerAfterCommit(SavedMemberEvent event) {
        log.info("TransactionPhase.AFTER_COMMIT ---> {}", event);
        eventLogRepository.save(new EventLog(1L, "contents1"));
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void transactionalEventListenerAfterRollback(SavedMemberEvent event) {
        log.info("TransactionPhase.AFTER_ROLLBACK ---> {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void transactionalEventListenerAfterCompletion(SavedMemberEvent event) {
        log.info("TransactionPhase.AFTER_COMPLETION ---> {}", event);
    }
}