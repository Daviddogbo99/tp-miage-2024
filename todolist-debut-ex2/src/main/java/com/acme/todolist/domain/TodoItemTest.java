package com.acme.todolist.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

public class TodoItemTest {

    @Test
    public void testFinalContentLate() {
        // Crée un item en retard de plus de 24 heures
        Instant now = Instant.now();
        Instant late = now.minus(25, ChronoUnit.HOURS); // 25 heures de retard
        TodoItem lateItem = new TodoItem("1", late, "Tâche en retard");

        // Vérifie que la méthode finalContent() retourne la bonne chaîne avec le label '[LATE!]'
        assertEquals("[LATE!] Tâche en retard", lateItem.finalContent());
    }

    @Test
    public void testFinalContentNotLate() {
        // Crée un item en retard de moins de 24 heures
        Instant now = Instant.now();
        Instant notLate = now.minus(23, ChronoUnit.HOURS); // 23 heures de retard
        TodoItem notLateItem = new TodoItem("2", notLate, "Tâche pas encore en retard");

        // Vérifie que la méthode finalContent() retourne la description initiale sans ajout de label
        assertEquals("Tâche pas encore en retard", notLateItem.finalContent());
    }

    @Test
    public void testIsLateTrue() {
        // Crée un item en retard de plus de 24 heures
        Instant now = Instant.now();
        Instant late = now.minus(25, ChronoUnit.HOURS); // 25 heures de retard
        TodoItem lateItem = new TodoItem("3", late, "Tâche en retard");

        // Vérifie que la méthode isLate() retourne true
        assertTrue(lateItem.isLate());
    }

    @Test
    public void testIsLateFalse() {
        // Crée un item en retard de moins de 24 heures
        Instant now = Instant.now();
        Instant notLate = now.minus(23, ChronoUnit.HOURS); // 23 heures de retard
        TodoItem notLateItem = new TodoItem("4", notLate, "Tâche pas encore en retard");

        // Vérifie que la méthode isLate() retourne false
        assertFalse(notLateItem.isLate());

    }
}


