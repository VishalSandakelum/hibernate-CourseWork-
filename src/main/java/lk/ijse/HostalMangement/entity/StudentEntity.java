package lk.ijse.HostalMangement.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @Column(name = "student_id", length = 40)
    private String StudentId;
    @Column(name = "student_name",nullable = false, length = 50 )
    private String Name;
    @Column(name = "address",nullable = false,  columnDefinition = "TEXT" )
    private String Address;
    @Column(name = "contact_number",nullable = false, length = 50 )
    private String ContactNumber;
    @Column(name = "dob",nullable = false, length = 50 )
    private String DateOfBirth;
    @Column(name = "gender",nullable = false, length = 50 )
    private String Gender;

    public StudentEntity() {
    }

    public StudentEntity(String studentId, String name, String address, String contactNumber, String dateOfBirth, String gender) {
        StudentId = studentId;
        Name = name;
        Address = address;
        ContactNumber = contactNumber;
        DateOfBirth = dateOfBirth;
        Gender = gender;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
