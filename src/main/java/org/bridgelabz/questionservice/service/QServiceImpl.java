package org.bridgelabz.questionservice.service;

import org.bridgelabz.questionservice.model.Question;
import org.bridgelabz.questionservice.repo.QRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class QServiceImpl implements QService{


    @Autowired
    private QRepo repo;

    private final WebClient quizWebClient;


   public QServiceImpl(@Value("${quizservice.baseurl}") String baseUrl) {
        this.quizWebClient = (WebClient) WebClient.builder()
                .baseUrl(baseUrl)
                .build();
   }
    @Override
    public Mono<Question> SaveQuestion(Question question) {
        return repo.save(question) ;
    }

    @Override
    public Flux<Question> GetQuestion() {
        return repo.findAll();
    }

    @Override
    public Mono<Question> GetQuestionbyID(long id) {
        return repo.findById(id);
    }

    @Override
    public Mono<Void> DeleteQuestionByid(long id) {
        return repo.deleteById(id);
    }

    @Override
    public Flux<Question> questionbyquizid(long id) {
        return repo.findByQuizId(id);
    }

//    @Override
//    public Mono<Question> Update(Question question, long id) {
//        return repo.findById(id)
//                .flatMap(exisitingQuestion ->{
//                    exisitingQuestion.setQuestion(question.getQuestion());
//                    exisitingQuestion.setQuizId(question.getQuizId());
//                    return  repo.save(question);
//                });
//    }

}
