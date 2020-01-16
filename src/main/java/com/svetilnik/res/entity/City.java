package com.svetilnik.res.entity;

import javax.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;
    private String message;

    public City() {
    }

    public City(String name, String message) {
        this.name = name;
        this.message = message;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = (int) (prime * result + id);
        result = prime * result +
                ((message == null) ? 0 : message.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        City city = (City) o;
        return id == ((City) o).id
                && (name == ((City) o).name
                || (name != null && name.equals(city.getName()))) && (message == city.message
                || (message != null && message.equals(city.getMessage())
        ));

    }
}
