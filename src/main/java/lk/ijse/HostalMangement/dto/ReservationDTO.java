package lk.ijse.HostalMangement.dto;


import lk.ijse.HostalMangement.entity.ReservationEntity;
import lk.ijse.HostalMangement.entity.RoomEntity;
import lk.ijse.HostalMangement.entity.StudentEntity;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDTO {

    private String ReservationId;
    private Timestamp OrderDateTime;
    private StudentEntity Student;
    private RoomEntity Room;
    private String Status;

    public ReservationEntity ToEntity(){
        ReservationEntity reservation = new ReservationEntity();
        reservation.setReservationId(this.ReservationId);
        reservation.setOrderDateTime(this.OrderDateTime);
        reservation.setStudent(this.Student);
        reservation.setRoom(this.Room);
        reservation.setStatus(this.Status);
        return reservation;
    }

}
