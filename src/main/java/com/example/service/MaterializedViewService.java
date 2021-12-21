package com.example.service;

import com.example.entity.UserView;
import com.example.repository.UserViewRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class MaterializedViewService {

    private final UserViewRepository viewRepository;
    private final SessionFactory sessionFactory;

    public List<UserView> getAllViews(){
        return viewRepository.findAll();
    }

    public UserView getViewById(Long id){
        return viewRepository.findById(id).orElseThrow();
    }

    public void refreshView(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createSQLQuery("REFRESH MATERIALIZED VIEW user_single_table_view").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
