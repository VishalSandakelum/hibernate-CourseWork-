package lk.ijse.HostalMangement.bo.custom;

import lk.ijse.HostalMangement.bo.SuperBo;
import lk.ijse.HostalMangement.dto.LoginDTO;

public interface LoginBo extends SuperBo {
    LoginDTO getPass(int ID);
    boolean UpdatePass(LoginDTO loginDTO);
}
