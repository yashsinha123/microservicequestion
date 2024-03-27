package org.bridgelabz.questionservice.service;

import org.bridgelabz.questionservice.model.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QService {

    Mono<Question> SaveQuestion( Question question);

    Flux<Question> GetQuestion();

    Mono<Question> GetQuestionbyID(long id);

    Mono<Void> DeleteQuestionByid(long id);
    //Mono<Question> Update(Question question,long id);

    Flux<Question> questionbyquizid(long id);




}
