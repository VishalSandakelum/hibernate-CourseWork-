package lk.ijse.HostalMangement.dao.custom;

import lk.ijse.HostalMangement.dao.CrudDao;
import lk.ijse.HostalMangement.dao.SuperDao;
import lk.ijse.HostalMangement.entity.RoomEntity;
import org.hibernate.Session;

public interface RoomDao extends CrudDao<RoomEntity,Integer> {
    void SetSession(Session session);
}
