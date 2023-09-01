package lk.ijse.HostalMangement.bo.custom;

import lk.ijse.HostalMangement.bo.SuperBo;
import lk.ijse.HostalMangement.dto.RoomDTO;

public interface RoomBo extends SuperBo {
    int SaveRoom(RoomDTO roomDTO);
    RoomDTO getRoom(int room_type_id);
    boolean UpdateRoom(RoomDTO roomDTO);
    boolean DeleteRoom(RoomDTO roomDTO);
}
