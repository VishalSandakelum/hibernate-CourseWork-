package lk.ijse.HostalMangement.dao.custom.impl;

import lk.ijse.HostalMangement.dao.custom.ReservationDao;
import lk.ijse.HostalMangement.entity.ReservationEntity;
import org.hibernate.Session;

public class ReservationDaoImpl implements ReservationDao {

    private Session session;

    public ReservationDaoImpl(){}

    @Override
    public Integer Save(ReservationEntity reservationEntity) {
        return (int)session.save(reservationEntity);
    }

    @Override
    public ReservationEntity Get(Integer reservation_id) {
        return session.get(ReservationEntity.class, reservation_id);
    }

    @Override
    public void Update(ReservationEntity reservationEntity) {
        session.update(reservationEntity);
    }

    @Override
    public void Delete(ReservationEntity reservationEntity) {
        session.delete(reservationEntity);
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }
}
