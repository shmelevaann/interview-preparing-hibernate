package ru.chiffa.lesson5;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private Double mark;

    public Student() {
    }

    public Student(String name, Double mark) {
        this.name = name;
        this.mark = mark;
    }
}
