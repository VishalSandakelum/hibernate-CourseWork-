package lk.ijse.HostalMangement.bo.custom;

import lk.ijse.HostalMangement.bo.SuperBo;
import lk.ijse.HostalMangement.dto.StudentDTO;

public interface StudentBo extends SuperBo {
    int SaveStudent();
    StudentDTO getStudent(int student_id);
    boolean UpdateStudent(StudentDTO studentDTO);
    boolean DeleteCustomer(StudentDTO studentDTO);
}
