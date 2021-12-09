# DoctorManagementApi

All URIs are relative to *https://octosolutions.in/coreDataManagement/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteDoctors**](DoctorManagementApi.md#deleteDoctors) | **DELETE** /doctor | Doctor Deletion by filter
[**getDoctors**](DoctorManagementApi.md#getDoctors) | **GET** /doctor | List of Doctors available
[**saveDoctor**](DoctorManagementApi.md#saveDoctor) | **POST** /doctor | Insertion of doctor
[**updateDoctor**](DoctorManagementApi.md#updateDoctor) | **PATCH** /doctor | Doctor Updation by filter


<a name="deleteDoctors"></a>
# **deleteDoctors**
> Doctor deleteDoctors(filters)

Doctor Deletion by filter

delete Doctor

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.DoctorManagementApi;


DoctorManagementApi apiInstance = new DoctorManagementApi();
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Doctor result = apiInstance.deleteDoctors(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DoctorManagementApi#deleteDoctors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Doctor**](Doctor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDoctors"></a>
# **getDoctors**
> Doctor getDoctors(filters)

List of Doctors available

Produces List of Doctors available

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.DoctorManagementApi;


DoctorManagementApi apiInstance = new DoctorManagementApi();
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Doctor result = apiInstance.getDoctors(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DoctorManagementApi#getDoctors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Doctor**](Doctor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="saveDoctor"></a>
# **saveDoctor**
> Doctor saveDoctor(doctorInput)

Insertion of doctor

Creates New entry of a doctor

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.DoctorManagementApi;


DoctorManagementApi apiInstance = new DoctorManagementApi();
Doctor doctorInput = new Doctor(); // Doctor | 
try {
    Doctor result = apiInstance.saveDoctor(doctorInput);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DoctorManagementApi#saveDoctor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **doctorInput** | [**Doctor**](Doctor.md)|  |

### Return type

[**Doctor**](Doctor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateDoctor"></a>
# **updateDoctor**
> Doctor updateDoctor(patchElement, filters)

Doctor Updation by filter

Produces List of Doctors

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.DoctorManagementApi;


DoctorManagementApi apiInstance = new DoctorManagementApi();
PatchElement patchElement = new PatchElement(); // PatchElement | \"Doctor patch element\" 
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Doctor result = apiInstance.updateDoctor(patchElement, filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DoctorManagementApi#updateDoctor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patchElement** | [**PatchElement**](PatchElement.md)| \&quot;Doctor patch element\&quot;  |
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Doctor**](Doctor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

