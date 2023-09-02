package lk.ijse.HostalMangement.dao.custom.impl;

import lk.ijse.HostalMangement.dao.custom.StudentDao;
import lk.ijse.HostalMangement.entity.StudentEntity;
import org.hibernate.Session;

public class StudentDaoImpl implements StudentDao {

    private Session session;

    public StudentDaoImpl(){}

    @Override
    public String Save(StudentEntity studentEntity) {
        return (String) session.save(studentEntity);
    }

    @Override
    public StudentEntity Get(String id) {
        return session.get(StudentEntity.class,id);
    }

    @Override
    public void Update(StudentEntity studentEntity) {
        session.update(studentEntity);
    }

    @Override
    public void Delete(StudentEntity studentEntity) {
        session.delete(studentEntity);
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }
}
