/*
 * 
 * 
 *
 * 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.ContactMedium;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.DepartmentType;
import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.model.GenderRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Doctor
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-12-09T21:54:17.090+05:30")
public class Doctor {
  @SerializedName("id")
  private String id = null;

  @SerializedName("aadharId")
  private String aadharId = null;

  @SerializedName("firstName")
  private String firstName = null;

  @SerializedName("middleName")
  private String middleName = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("fullName")
  private String fullName = null;

  @SerializedName("doctorRegistrationId")
  private String doctorRegistrationId = null;

  @SerializedName("digiDoctorId")
  private String digiDoctorId = null;

  @SerializedName("departmentId")
  private String departmentId = null;

  @SerializedName("hospitalId")
  private String hospitalId = null;

  @SerializedName("qualification")
  private String qualification = null;

  @SerializedName("joiningDate")
  private String joiningDate = null;

  @SerializedName("designation")
  private String designation = null;

  @SerializedName("dateOfBirth")
  private String dateOfBirth = null;

  @SerializedName("gender")
  private GenderRef gender = null;

  @SerializedName("sections")
  private DepartmentType sections = null;

  @SerializedName("contact")
  private ContactMedium contact = null;

  public Doctor id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Id of Particular Doctor  
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Id of Particular Doctor  ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Doctor aadharId(String aadharId) {
    this.aadharId = aadharId;
    return this;
  }

   /**
   * Aadhar Id of Particular Doctor  
   * @return aadharId
  **/
  @ApiModelProperty(required = true, value = "Aadhar Id of Particular Doctor  ")
  public String getAadharId() {
    return aadharId;
  }

  public void setAadharId(String aadharId) {
    this.aadharId = aadharId;
  }

  public Doctor firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * first name of a doctor 
   * @return firstName
  **/
  @ApiModelProperty(value = "first name of a doctor ")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Doctor middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

   /**
   * Middle name of a doctor 
   * @return middleName
  **/
  @ApiModelProperty(value = "Middle name of a doctor ")
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Doctor lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * last name of a doctor 
   * @return lastName
  **/
  @ApiModelProperty(value = "last name of a doctor ")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Doctor fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

   /**
   * full name of doctor 
   * @return fullName
  **/
  @ApiModelProperty(value = "full name of doctor ")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Doctor doctorRegistrationId(String doctorRegistrationId) {
    this.doctorRegistrationId = doctorRegistrationId;
    return this;
  }

   /**
   * govt registration id of a doctor 
   * @return doctorRegistrationId
  **/
  @ApiModelProperty(required = true, value = "govt registration id of a doctor ")
  public String getDoctorRegistrationId() {
    return doctorRegistrationId;
  }

  public void setDoctorRegistrationId(String doctorRegistrationId) {
    this.doctorRegistrationId = doctorRegistrationId;
  }

  public Doctor digiDoctorId(String digiDoctorId) {
    this.digiDoctorId = digiDoctorId;
    return this;
  }

   /**
   * digi doctor id 
   * @return digiDoctorId
  **/
  @ApiModelProperty(required = true, value = "digi doctor id ")
  public String getDigiDoctorId() {
    return digiDoctorId;
  }

  public void setDigiDoctorId(String digiDoctorId) {
    this.digiDoctorId = digiDoctorId;
  }

  public Doctor departmentId(String departmentId) {
    this.departmentId = departmentId;
    return this;
  }

   /**
   * department id 
   * @return departmentId
  **/
  @ApiModelProperty(required = true, value = "department id ")
  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public Doctor hospitalId(String hospitalId) {
    this.hospitalId = hospitalId;
    return this;
  }

   /**
   * hospital id 
   * @return hospitalId
  **/
  @ApiModelProperty(value = "hospital id ")
  public String getHospitalId() {
    return hospitalId;
  }

  public void setHospitalId(String hospitalId) {
    this.hospitalId = hospitalId;
  }

  public Doctor qualification(String qualification) {
    this.qualification = qualification;
    return this;
  }

   /**
   * highest qualification of a doctor 
   * @return qualification
  **/
  @ApiModelProperty(value = "highest qualification of a doctor ")
  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  public Doctor joiningDate(String joiningDate) {
    this.joiningDate = joiningDate;
    return this;
  }

   /**
   * date of joining in the hospital 
   * @return joiningDate
  **/
  @ApiModelProperty(value = "date of joining in the hospital ")
  public String getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(String joiningDate) {
    this.joiningDate = joiningDate;
  }

  public Doctor designation(String designation) {
    this.designation = designation;
    return this;
  }

   /**
   * designation of a doctor in the hospital 
   * @return designation
  **/
  @ApiModelProperty(value = "designation of a doctor in the hospital ")
  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public Doctor dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

   /**
   * date of birth of a doctor(for analytics purpose) 
   * @return dateOfBirth
  **/
  @ApiModelProperty(value = "date of birth of a doctor(for analytics purpose) ")
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Doctor gender(GenderRef gender) {
    this.gender = gender;
    return this;
  }

   /**
   * Get gender
   * @return gender
  **/
  @ApiModelProperty(value = "")
  public GenderRef getGender() {
    return gender;
  }

  public void setGender(GenderRef gender) {
    this.gender = gender;
  }

  public Doctor sections(DepartmentType sections) {
    this.sections = sections;
    return this;
  }

   /**
   * Get sections
   * @return sections
  **/
  @ApiModelProperty(required = true, value = "")
  public DepartmentType getSections() {
    return sections;
  }

  public void setSections(DepartmentType sections) {
    this.sections = sections;
  }

  public Doctor contact(ContactMedium contact) {
    this.contact = contact;
    return this;
  }

   /**
   * Get contact
   * @return contact
  **/
  @ApiModelProperty(value = "")
  public ContactMedium getContact() {
    return contact;
  }

  public void setContact(ContactMedium contact) {
    this.contact = contact;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Doctor doctor = (Doctor) o;
    return Objects.equals(this.id, doctor.id) &&
        Objects.equals(this.aadharId, doctor.aadharId) &&
        Objects.equals(this.firstName, doctor.firstName) &&
        Objects.equals(this.middleName, doctor.middleName) &&
        Objects.equals(this.lastName, doctor.lastName) &&
        Objects.equals(this.fullName, doctor.fullName) &&
        Objects.equals(this.doctorRegistrationId, doctor.doctorRegistrationId) &&
        Objects.equals(this.digiDoctorId, doctor.digiDoctorId) &&
        Objects.equals(this.departmentId, doctor.departmentId) &&
        Objects.equals(this.hospitalId, doctor.hospitalId) &&
        Objects.equals(this.qualification, doctor.qualification) &&
        Objects.equals(this.joiningDate, doctor.joiningDate) &&
        Objects.equals(this.designation, doctor.designation) &&
        Objects.equals(this.dateOfBirth, doctor.dateOfBirth) &&
        Objects.equals(this.gender, doctor.gender) &&
        Objects.equals(this.sections, doctor.sections) &&
        Objects.equals(this.contact, doctor.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, aadharId, firstName, middleName, lastName, fullName, doctorRegistrationId, digiDoctorId, departmentId, hospitalId, qualification, joiningDate, designation, dateOfBirth, gender, sections, contact);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Doctor {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    aadharId: ").append(toIndentedString(aadharId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    doctorRegistrationId: ").append(toIndentedString(doctorRegistrationId)).append("\n");
    sb.append("    digiDoctorId: ").append(toIndentedString(digiDoctorId)).append("\n");
    sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
    sb.append("    hospitalId: ").append(toIndentedString(hospitalId)).append("\n");
    sb.append("    qualification: ").append(toIndentedString(qualification)).append("\n");
    sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
    sb.append("    designation: ").append(toIndentedString(designation)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    sections: ").append(toIndentedString(sections)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

