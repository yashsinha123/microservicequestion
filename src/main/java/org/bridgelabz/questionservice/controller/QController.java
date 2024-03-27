package org.bridgelabz.questionservice.controller;

import org.bridgelabz.questionservice.model.Question;
import org.bridgelabz.questionservice.service.QService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/questions")
public class QController {


    @Autowired
    private QService service;
    @PostMapping("/SaveQuestion")
    public Mono<Question> RegisterQuestion(@RequestBody Question question){
        return service.SaveQuestion(question);
    }
    @GetMapping("/GetAllQuestion")
    public Flux<Question> GetAllQuestion(){
        return  service.GetQuestion();
    }
    @GetMapping("/GeById/{id}")
    public  Mono<Question> GetByID(@PathVariable long id){
        return  service.GetQuestionbyID(id);
    }
    @DeleteMapping("/deleteQuestion/{id}")
    public  Mono<Void> deleteById(@PathVariable long id){
        return service.DeleteQuestionByid(id);
    }
//    @PutMapping("/updateQuestion/{id}")
//    public Mono<Question> UpdateQuestion(@RequestBody Question question, @PathVariable long id){
//        return service.Update(question,id);
//
//    }
    @GetMapping("/getbyquizid/{quizId}")
    public Flux<Question> getbyQuizId(@PathVariable String quizId ){
        return  service.questionbyquizid(Long.parseLong(quizId));

    }


}
