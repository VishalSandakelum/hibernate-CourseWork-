package lk.ijse.HostalMangement.entity;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @Column(name = "room_type_id",length = 50)
    private String RoomTypeId;
    @Column(name = "type",nullable = false, length = 50)
    private String Type;
    @Column(name = "key_money",nullable = false, length = 50)
    private String KeyMoney;
    @Column(name = "qty",nullable = false, length = 50)
    private int Qty;

    public RoomEntity() {
    }

    public RoomEntity(String roomTypeId, String type, String keyMoney, int qty) {
        RoomTypeId = roomTypeId;
        Type = type;
        KeyMoney = keyMoney;
        Qty = qty;
    }

    public String getRoomTypeId() {
        return RoomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        RoomTypeId = roomTypeId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getKeyMoney() {
        return KeyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        KeyMoney = keyMoney;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }
}
