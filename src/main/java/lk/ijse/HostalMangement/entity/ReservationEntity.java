package lk.ijse.HostalMangement.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @Column(name = "reservation_id")
    private String ReservationId;
    @CreationTimestamp
    @Column(name = "date_")
    private Timestamp orderDateTime;
    @Column(name = "")
    @Column(name = "")
    @Column(name = "")

}
