package lk.ijse.HostalMangement.bo.custom.Impl;

import lk.ijse.HostalMangement.bo.custom.LoginBo;
import lk.ijse.HostalMangement.config.SessionFactoryConfig;
import lk.ijse.HostalMangement.dao.DaoFactory;
import lk.ijse.HostalMangement.dao.custom.QueryDao;
import lk.ijse.HostalMangement.dto.LoginDTO;
import lk.ijse.HostalMangement.entity.LoginEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginBoImpl implements LoginBo {

    QueryDao queryDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.LOGIN);

    @Override
    public LoginDTO getPass(int ID) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        try {
            queryDao.SetSession(session);
            LoginEntity loginEntity = queryDao.Get(ID);
            session.close();
            return loginEntity.ToDTO();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean UpdatePass(LoginDTO loginDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            queryDao.SetSession(session);
            queryDao.Update(loginDTO.ToEntity());
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
    }
}
