# PrescriptionManagementApi

All URIs are relative to *https://octosolutions.in/coreDataManagement/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletePrescriptions**](PrescriptionManagementApi.md#deletePrescriptions) | **DELETE** /prescription | Prescription Deletion by filter
[**getPrescriptions**](PrescriptionManagementApi.md#getPrescriptions) | **GET** /prescription | List of Prescriptions available
[**savePrescription**](PrescriptionManagementApi.md#savePrescription) | **POST** /prescription | Insertion of prescription
[**updatePrescription**](PrescriptionManagementApi.md#updatePrescription) | **PATCH** /prescription | Prescription Updation by filter


<a name="deletePrescriptions"></a>
# **deletePrescriptions**
> Prescription deletePrescriptions(filters)

Prescription Deletion by filter

delete Prescription

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.PrescriptionManagementApi;


PrescriptionManagementApi apiInstance = new PrescriptionManagementApi();
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Prescription result = apiInstance.deletePrescriptions(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PrescriptionManagementApi#deletePrescriptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Prescription**](Prescription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPrescriptions"></a>
# **getPrescriptions**
> Prescription getPrescriptions(filters)

List of Prescriptions available

Produces List of Prescriptions available

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.PrescriptionManagementApi;


PrescriptionManagementApi apiInstance = new PrescriptionManagementApi();
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Prescription result = apiInstance.getPrescriptions(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PrescriptionManagementApi#getPrescriptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Prescription**](Prescription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="savePrescription"></a>
# **savePrescription**
> Prescription savePrescription(prescriptionInput)

Insertion of prescription

Creates New entry of a prescription

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.PrescriptionManagementApi;


PrescriptionManagementApi apiInstance = new PrescriptionManagementApi();
Prescription prescriptionInput = new Prescription(); // Prescription | 
try {
    Prescription result = apiInstance.savePrescription(prescriptionInput);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PrescriptionManagementApi#savePrescription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prescriptionInput** | [**Prescription**](Prescription.md)|  |

### Return type

[**Prescription**](Prescription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updatePrescription"></a>
# **updatePrescription**
> Prescription updatePrescription(patchElement, filters)

Prescription Updation by filter

Produces List of Prescriptions

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.PrescriptionManagementApi;


PrescriptionManagementApi apiInstance = new PrescriptionManagementApi();
PatchElement patchElement = new PatchElement(); // PatchElement | \"Prescription patch element\" 
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Prescription result = apiInstance.updatePrescription(patchElement, filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PrescriptionManagementApi#updatePrescription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patchElement** | [**PatchElement**](PatchElement.md)| \&quot;Prescription patch element\&quot;  |
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Prescription**](Prescription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

