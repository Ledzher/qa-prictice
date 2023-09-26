package com.example.qaprictice.entity;

import com.example.qaprictice.enums.TypeAnswer;
import jakarta.persistence.*;

@Entity
@Table(name = "questionnaire")
public class Questionnaire{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title" , nullable = false)
    private String title;

    @Column
    @Enumerated(value = EnumType.STRING)
    private TypeAnswer typeAnswer;

    public Questionnaire(){}

    public Questionnaire(String title) {
        this.title = title;
    }

    public TypeAnswer getTypeAnswer() {
        return typeAnswer;
    }

    public void setTypeAnswer(TypeAnswer typeAnswer) {
        this.typeAnswer = typeAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
