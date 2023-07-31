package com.example.SistemaDeFarmacia.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "tb_prohibited")
public class Prohibited {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    private String numNote;
    private Double valueGrade;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "id.prohibited")
    private Set<EntryItems> entryItems = new HashSet<>();

    public Prohibited(){
    }

    public Prohibited(Long id, Instant date, String numNote, Double valueGrade, String description, User user) {
        this.id = id;
        this.date = date;
        this.numNote = numNote;
        this.valueGrade = valueGrade;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getNumNote() {
        return numNote;
    }

    public void setNumNote(String numNote) {
        this.numNote = numNote;
    }

    public Double getValueGrade() {
        return valueGrade;
    }

    public void setValueGrade(Double valueGrade) {
        this.valueGrade = valueGrade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<EntryItems> getEntryItems() {
        return entryItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prohibited that = (Prohibited) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
