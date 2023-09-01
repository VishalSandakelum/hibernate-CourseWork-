package lk.ijse.HostalMangement.dao.custom.impl;

import lk.ijse.HostalMangement.dao.custom.RoomDao;
import lk.ijse.HostalMangement.entity.RoomEntity;
import org.hibernate.Session;

public class RoomDaoImpl implements RoomDao {

    private Session session;

    public RoomDaoImpl(){}

    @Override
    public Integer Save(RoomEntity roomEntity) {
        return (int) session.save(roomEntity);
    }

    @Override
    public RoomEntity Get(Integer id) {
        return session.get(RoomEntity.class,id);
    }

    @Override
    public void Update(RoomEntity roomEntity) {
        session.update(roomEntity);
    }

    @Override
    public void Delete(RoomEntity roomEntity) {
        session.delete(roomEntity);
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }
}
