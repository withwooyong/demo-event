package com.example.demoevent.event.listener;

import com.example.demoevent.entity.EventLog;
import com.example.demoevent.event.MemberEvent;
import com.example.demoevent.repository.EventLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @TransactionalEventListener 옵션
 * 1. @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
 * default 값이며, 트랜잭션이 commit 되었을 때 이벤트를 실행
 * 2. @TransactionalEventListener(phase = TransactionPhase.ROLLBACK)
 * 트랜잭션이 rollback 되었을 때 이벤트를 실행
 * 3. @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
 * 트랜잭션이 completion(commit 또는 rollback) 되었을 때 이벤트 실행
 * 4. @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
 * 트랜잭션이 commit 되기 전에 이벤트를 실행
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberEventListener {

    private final EventLogRepository eventLogRepository;

    @EventListener
    public void defaultEventListener(MemberEvent event) {
        log.info("defaultEventListener ---> {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void transactionalEventListenerBeforeCommit(MemberEvent event) {
        log.info("TransactionPhase.BEFORE_COMMIT ---> {}", event);
    }

    /**
     * @TransactionalEventListener의 경우
     * event publisher의 트랜잭션 안에서 동작하며,
     * 커밋이 된 이후 추가 커밋을 허용하지 않기 때문에
     * insert, update, delete 같은 작업이 필요한 경우
     * 이벤트 리스너에서 @Transactional(propagation = Propagation.REQUIRES_NEW)를 추가 설정 필요
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transactionalEventListenerAfterCommit(MemberEvent event) {
        log.info("TransactionPhase.AFTER_COMMIT ---> {}", event);
        eventLogRepository.save(new EventLog(1L, "contents1"));
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void transactionalEventListenerAfterRollback(MemberEvent event) {
        log.info("TransactionPhase.AFTER_ROLLBACK ---> {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void transactionalEventListenerAfterCompletion(MemberEvent event) {
        log.info("TransactionPhase.AFTER_COMPLETION ---> {}", event);
    }
}