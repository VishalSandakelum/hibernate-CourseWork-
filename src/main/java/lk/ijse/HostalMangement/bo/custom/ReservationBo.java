package lk.ijse.HostalMangement.bo.custom;

import lk.ijse.HostalMangement.bo.SuperBo;
import lk.ijse.HostalMangement.dto.ReservationDTO;
import lk.ijse.HostalMangement.dto.StudentDTO;

public interface ReservationBo extends SuperBo {
    int SaveReservationDetails(ReservationDTO reservationDTO);
    ReservationDTO getReservationDetails(int reservation_id);
    boolean UpdateReservationDetails(ReservationDTO reservationDTO);
    boolean DeleteReservationDetails(ReservationDTO reservationDTO);
}
