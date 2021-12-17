package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "groupa", schema = "groupa")

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idColumn;

    @NonNull
    @Column(name = "number", nullable = false)
    private String numberGroup;
}
