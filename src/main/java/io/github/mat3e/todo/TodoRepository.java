package io.github.mat3e.todo;

import io.github.mat3e.HibernateUtil;
import io.github.mat3e.todo.Todo;

import java.util.List;
import java.util.Optional;

public class TodoRepository {
    List<Todo> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.createQuery("from Todo", Todo.class).list();

        transaction.commit();
        session.close();
        return result;
    }


    public Optional<Todo> findById(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.get(Todo.class, id);

        transaction.commit();
        session.close();
        return Optional.ofNullable(result);

    }
}
