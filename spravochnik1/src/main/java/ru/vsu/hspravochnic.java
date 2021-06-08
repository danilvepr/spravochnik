package ru.vsu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vsu.model.abonent;


import java.util.List;

@Repository
public class hspravochnic implements spravochnic {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(abonent chelovec) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(chelovec);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(chel(id));
    }

    @Override
    public void edit(int id, abonent chelovec) {
        Session session = sessionFactory.getCurrentSession();
        chelovec.setId(id);
        session.update(chelovec);
    }

    @Override
    public abonent chel(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(abonent.class, id);
    }

    @Override
    public List<abonent> poisk(String isk) {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<abonent> abonen() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from abonent").list();
    }
}
