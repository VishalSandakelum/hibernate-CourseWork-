package lk.ijse.HostalMangement.dao.custom.impl;

import lk.ijse.HostalMangement.dao.custom.QueryDao;
import lk.ijse.HostalMangement.entity.LoginEntity;
import lk.ijse.HostalMangement.entity.ReservationEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDaoImpl implements QueryDao {

    private Session session;

    public QueryDaoImpl(){}

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }

    @Override
    public LoginEntity Get(int id) {
        return session.get(LoginEntity.class, id);
    }

    @Override
    public void Update(LoginEntity loginEntity) {
        session.update(loginEntity);
    }

    @Override
    public List<ReservationEntity> getAllPendingPayDetails() {
        String hql = "SELECT r\n" +
                "FROM ReservationEntity r\n" +
                "LEFT JOIN StudentEntity s ON r.Student = s.StudentId\n" +
                "WHERE r.Status = 'PENDING'";
        Query query = session.createQuery(hql);
        List<ReservationEntity> list = query.list();
        return list;
    }

}
