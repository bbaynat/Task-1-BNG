package jm.task.core.jdbc.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table
@ToString
@NoArgsConstructor

public class User {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Byte age;

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

}
