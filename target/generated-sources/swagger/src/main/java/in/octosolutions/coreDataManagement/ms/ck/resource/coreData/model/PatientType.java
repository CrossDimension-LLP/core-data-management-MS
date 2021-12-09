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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets PatientType
 */
@JsonAdapter(PatientType.Adapter.class)
public enum PatientType {
  
  OP("OP"),
  
  IP("IP");

  private String value;

  PatientType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static PatientType fromValue(String text) {
    for (PatientType b : PatientType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<PatientType> {
    @Override
    public void write(final JsonWriter jsonWriter, final PatientType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public PatientType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return PatientType.fromValue(String.valueOf(value));
    }
  }
}

