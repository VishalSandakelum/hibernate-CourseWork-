package lk.ijse.HostalMangement.bo.custom.Impl;

import lk.ijse.HostalMangement.bo.custom.ReservationBo;
import lk.ijse.HostalMangement.dto.ReservationDTO;

public class ReservationBoImpl implements ReservationBo {
    @Override
    public int SaveReservationDetails() {
        return 0;
    }

    @Override
    public ReservationDTO getReservationDetails(int reservation_id) {
        return null;
    }

    @Override
    public boolean UpdateReservationDetails(ReservationDTO reservationDTO) {
        return false;
    }

    @Override
    public boolean DeleteReservationDetails(ReservationDTO reservationDTO) {
        return false;
    }
}
