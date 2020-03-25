package com.seriouscompanyname.serverhospital.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String surname;
    private String name;
    private String middleName;

    public Person(Person person) {
        this.surname = person.getSurname();
        this.name = person.getName();
        this.middleName = person.getMiddleName();
    }

    public StringProperty getFullName() {
        return new SimpleStringProperty(surname + " " +
                name + " " +
                middleName);
    }
}
