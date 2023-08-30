package lk.ijse.HostalMangement.dao.custom;

import lk.ijse.HostalMangement.dao.CrudDao;
import lk.ijse.HostalMangement.dao.SuperDao;
import lk.ijse.HostalMangement.entity.ReservationEntity;
import org.hibernate.Session;

public interface ReservationDao extends CrudDao<ReservationEntity, Integer> {
    void SetSession(Session session);
}
