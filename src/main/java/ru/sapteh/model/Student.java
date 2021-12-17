package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "student", schema = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int IdColumn;

    @NonNull
    @Column(name = "first_name",nullable = false)
    private String firstNameColumn;

    @NonNull
    @Column(name = "last_name",nullable = false)
    private String lastNameColumn;

    @NonNull
    @Column(name = "age",nullable = false)
    private int ageColumn;


}