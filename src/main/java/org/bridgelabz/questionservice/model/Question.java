package org.bridgelabz.questionservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "question")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @Column("question_id")
    private Long questionId;
    @Column("question_text")
    private String question;
    @Column("quiz_id")
    private  Long quizId;

}
