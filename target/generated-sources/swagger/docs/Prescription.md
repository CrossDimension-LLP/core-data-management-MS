
# Prescription

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Id of Particular Prescription   | 
**relatedPrescriptions** | **List&lt;byte[]&gt;** |  |  [optional]
**doctorId** | **String** | id of the doctor  | 
**patient** | [**Patient**](Patient.md) |  |  [optional]
**departmentId** | **String** | id of the doctor&#39;s department(though it might not be needed)  |  [optional]
**hospitalId** | **String** | id of the hospital(though it might not be needed)  |  [optional]
**referredBy** | **String** | if patient is referred by any other doctor  |  [optional]
**patientType** | [**PatientType**](PatientType.md) |  | 
**medicalHistory** | **String** | detailed medical history of the patient  |  [optional]
**diseaseSymptoms** | **String** | details about the disease and the symptoms  |  [optional]
**clinicalFindings** | **String** | clinical findings from the lab report, if provided  |  [optional]
**diagnosis** | **String** | diagnosis of the disease  |  [optional]
**notes** | **String** | small notes while prescribing  |  [optional]
**conductedProcedure** | **String** | procedure followed while diagnosing the patient, if possible  |  [optional]
**medicines** | [**List&lt;MedicineDetails&gt;**](MedicineDetails.md) |  |  [optional]
**prescribedLabTest** | **String** | list of lab test(s) to be done  |  [optional]
**adviceGiven** | **String** | any advice given by doctor to the patient to follow  |  [optional]
**followUpDate** | **String** | follow up date if required  |  [optional]
**prescription** | **byte[]** | pdf version of the prescription  |  [optional]



