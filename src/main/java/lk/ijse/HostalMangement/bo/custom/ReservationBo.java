package lk.ijse.HostalMangement.bo.custom;

import lk.ijse.HostalMangement.bo.SuperBo;
import lk.ijse.HostalMangement.dto.ReservationDTO;
import lk.ijse.HostalMangement.dto.RoomDTO;
import lk.ijse.HostalMangement.dto.StudentDTO;

public interface ReservationBo extends SuperBo {
    String SaveReservationDetails(ReservationDTO reservationDTO);
    ReservationDTO getReservationDetails(String reservation_id);
    boolean UpdateReservationDetails(ReservationDTO reservationDTO);
    boolean DeleteReservationDetails(ReservationDTO reservationDTO);
    StudentDTO GetStudentName(String ID);
    RoomDTO GetKeyMoney(String ID);
}
