package lk.ijse.HostalMangement.dao.custom;

import lk.ijse.HostalMangement.dao.SuperDao;
import lk.ijse.HostalMangement.entity.LoginEntity;
import lk.ijse.HostalMangement.entity.ReservationEntity;
import org.hibernate.Session;

import java.util.List;

public interface QueryDao extends SuperDao {
    void SetSession(Session session);
    LoginEntity Get(int id);
    void Update(LoginEntity loginEntity);
    List<ReservationEntity> getAllPendingPayDetails();
}
