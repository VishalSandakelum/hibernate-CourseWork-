package lk.ijse.HostalMangement.bo.custom.Impl;

import lk.ijse.HostalMangement.bo.custom.RoomBo;
import lk.ijse.HostalMangement.dto.RoomDTO;

public class RoomBoImpl implements RoomBo {
    @Override
    public int SaveRoom() {
        return 0;
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
