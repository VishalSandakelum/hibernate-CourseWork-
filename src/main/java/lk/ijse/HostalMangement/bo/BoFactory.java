package lk.ijse.HostalMangement.bo;

import lk.ijse.HostalMangement.bo.custom.Impl.LoginBoImpl;
import lk.ijse.HostalMangement.bo.custom.Impl.ReservationBoImpl;
import lk.ijse.HostalMangement.bo.custom.Impl.RoomBoImpl;
import lk.ijse.HostalMangement.bo.custom.Impl.StudentBoImpl;

public class BoFactory {

    private static BoFactory boFactory;
    private static StudentBoImpl studentBoImpl;
    private static ReservationBoImpl reservationBoImpl;
    private static RoomBoImpl roomBoImpl;
    private static LoginBoImpl loginBoImpl;

    private BoFactory(){}

    public static BoFactory getBoFactory(){
        return (boFactory==null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoType {
        STUDENT,ROOM,RESERVATION,LOGIN
    }

    public <SuperBo>SuperBo getBo(BoType boType){
        switch(boType){
            case STUDENT:
                return (SuperBo) ((studentBoImpl==null) ? studentBoImpl = new StudentBoImpl() : studentBoImpl);
            case ROOM:
                return (SuperBo) ((roomBoImpl==null) ? roomBoImpl = new RoomBoImpl() : roomBoImpl);
            case RESERVATION:
                return (SuperBo) ((reservationBoImpl == null) ? reservationBoImpl = new ReservationBoImpl() : reservationBoImpl);
            case LOGIN:
                return (SuperBo) ((loginBoImpl == null) ? loginBoImpl = new LoginBoImpl():loginBoImpl);
            default:
                return null;
        }
    }

}
