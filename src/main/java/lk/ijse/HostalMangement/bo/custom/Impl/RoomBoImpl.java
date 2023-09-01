package lk.ijse.HostalMangement.bo.custom.Impl;

import lk.ijse.HostalMangement.bo.custom.RoomBo;
import lk.ijse.HostalMangement.config.SessionFactoryConfig;
import lk.ijse.HostalMangement.dao.DaoFactory;
import lk.ijse.HostalMangement.dao.custom.RoomDao;
import lk.ijse.HostalMangement.dto.RoomDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomBoImpl implements RoomBo {

    private static RoomBoImpl roomBoImpl;
    private final RoomDao roomDao;

    private RoomBoImpl(){
        roomDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.ROOM);
    }

    public static RoomBoImpl getInstance(){
        return (roomBoImpl==null) ? roomBoImpl = new RoomBoImpl() : roomBoImpl;
    }

    @Override
    public int SaveRoom(RoomDTO roomDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDao.SetSession(session);
            int save = roomDao.Save(roomDTO.ToEntity());
            transaction.commit();
            session.close();
            return save;
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return -1;
        }
        
    }

    @Override
    public RoomDTO getRoom(int room_type_id) {
        return null;
    }

    @Override
    public boolean UpdateRoom(RoomDTO roomDTO) {
        return false;
    }

    @Override
    public boolean DeleteRoom(RoomDTO roomDTO) {
        return false;
    }
}
