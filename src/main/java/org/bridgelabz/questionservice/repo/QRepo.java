package org.bridgelabz.questionservice.repo;

import org.bridgelabz.questionservice.model.Question;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QRepo extends R2dbcRepository<Question,Long> {
    Flux<Question> findByQuizId(Long quizId);
}
