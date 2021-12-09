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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Department
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-12-09T21:54:17.090+05:30")
public class Department {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("hospitalId")
  private String hospitalId = null;

  @SerializedName("pocDetails")
  private String pocDetails = null;

  @SerializedName("departmentStartingDate")
  private String departmentStartingDate = null;

  public Department id(String id) {
    this.id = id;
    return this;
  }

   /**
   * id of the department 
   * @return id
  **/
  @ApiModelProperty(required = true, value = "id of the department ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Department name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name of the department 
   * @return name
  **/
  @ApiModelProperty(required = true, value = "name of the department ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Department hospitalId(String hospitalId) {
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

  public Department pocDetails(String pocDetails) {
    this.pocDetails = pocDetails;
    return this;
  }

   /**
   * Phone number with the POCs details 
   * @return pocDetails
  **/
  @ApiModelProperty(value = "Phone number with the POCs details ")
  public String getPocDetails() {
    return pocDetails;
  }

  public void setPocDetails(String pocDetails) {
    this.pocDetails = pocDetails;
  }

  public Department departmentStartingDate(String departmentStartingDate) {
    this.departmentStartingDate = departmentStartingDate;
    return this;
  }

   /**
   * date of start functioning day of a department to get clear analysis of that department 
   * @return departmentStartingDate
  **/
  @ApiModelProperty(value = "date of start functioning day of a department to get clear analysis of that department ")
  public String getDepartmentStartingDate() {
    return departmentStartingDate;
  }

  public void setDepartmentStartingDate(String departmentStartingDate) {
    this.departmentStartingDate = departmentStartingDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Department department = (Department) o;
    return Objects.equals(this.id, department.id) &&
        Objects.equals(this.name, department.name) &&
        Objects.equals(this.hospitalId, department.hospitalId) &&
        Objects.equals(this.pocDetails, department.pocDetails) &&
        Objects.equals(this.departmentStartingDate, department.departmentStartingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, hospitalId, pocDetails, departmentStartingDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Department {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    hospitalId: ").append(toIndentedString(hospitalId)).append("\n");
    sb.append("    pocDetails: ").append(toIndentedString(pocDetails)).append("\n");
    sb.append("    departmentStartingDate: ").append(toIndentedString(departmentStartingDate)).append("\n");
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

