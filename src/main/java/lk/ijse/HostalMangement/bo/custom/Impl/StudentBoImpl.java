package lk.ijse.HostalMangement.bo.custom.Impl;

import lk.ijse.HostalMangement.bo.custom.StudentBo;
import lk.ijse.HostalMangement.dto.StudentDTO;

public class StudentBoImpl implements StudentBo {
    @Override
    public int SaveStudent() {
        return 0;
    }

    @Override
    public StudentDTO getStudent(int student_id) {
        return null;
    }

    @Override
    public boolean UpdateStudent(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public boolean DeleteCustomer(StudentDTO studentDTO) {
        return false;
    }
}
