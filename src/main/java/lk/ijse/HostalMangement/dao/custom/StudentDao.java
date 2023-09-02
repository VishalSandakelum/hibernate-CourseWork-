package lk.ijse.HostalMangement.dao.custom;

import lk.ijse.HostalMangement.dao.CrudDao;
import lk.ijse.HostalMangement.dao.SuperDao;
import lk.ijse.HostalMangement.entity.StudentEntity;
import org.hibernate.Session;

public interface StudentDao extends CrudDao<StudentEntity, String> {
    void SetSession(Session session);
}
