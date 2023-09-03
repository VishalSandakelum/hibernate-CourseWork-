package lk.ijse.HostalMangement.bo.custom;

import lk.ijse.HostalMangement.bo.SuperBo;
import lk.ijse.HostalMangement.dto.StudentDTO;

public interface StudentBo extends SuperBo {
    String SaveStudent(StudentDTO studentDto);
    StudentDTO getStudent(String student_id);
    boolean UpdateStudent(StudentDTO studentDTO);
    boolean DeleteStudent(StudentDTO studentDTO);
}
