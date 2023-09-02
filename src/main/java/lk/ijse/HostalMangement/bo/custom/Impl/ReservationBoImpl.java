package lk.ijse.HostalMangement.bo.custom.Impl;

import lk.ijse.HostalMangement.bo.custom.ReservationBo;
import lk.ijse.HostalMangement.config.SessionFactoryConfig;
import lk.ijse.HostalMangement.dao.DaoFactory;
import lk.ijse.HostalMangement.dao.custom.ReservationDao;
import lk.ijse.HostalMangement.dto.ReservationDTO;
import lk.ijse.HostalMangement.entity.ReservationEntity;
import lk.ijse.HostalMangement.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationBoImpl implements ReservationBo {

    ReservationDao reservationDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.RESERVATION);

    @Override
    public int SaveReservationDetails(ReservationDTO reservationDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction  = session.beginTransaction();
        try {
            reservationDao.SetSession(session);
            int save = reservationDao.Save(reservationDTO.ToEntity());
            transaction.commit();
            session.close();
            return save;
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return 0;
        }
    }

    @Override
    public ReservationDTO getReservationDetails(int reservation_id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        try {
            reservationDao.SetSession(session);
            ReservationEntity reservation = reservationDao.Get(reservation_id);
            session.close();
            return reservation.ToDto();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean UpdateReservationDetails(ReservationDTO reservationDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            reservationDao.SetSession(session);
            reservationDao.Update(reservationDTO.ToEntity());
            transaction.commit();
            session.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean DeleteReservationDetails(ReservationDTO reservationDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            reservationDao.SetSession(session);
            reservationDao.Delete(reservationDTO.ToEntity());
            transaction.commit();
            session.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
    }
}
