# DepartmentManagementApi

All URIs are relative to *https://octosolutions.in/coreDataManagement/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteDepartment**](DepartmentManagementApi.md#deleteDepartment) | **DELETE** /department | Department Deletion by filter
[**getDepartment**](DepartmentManagementApi.md#getDepartment) | **GET** /department | List of Departments available
[**saveDepartment**](DepartmentManagementApi.md#saveDepartment) | **POST** /department | Insertion of Department
[**updateDepartment**](DepartmentManagementApi.md#updateDepartment) | **PATCH** /department | Department Updation by filter


<a name="deleteDepartment"></a>
# **deleteDepartment**
> Department deleteDepartment(filters)

Department Deletion by filter

delete Department

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.DepartmentManagementApi;


DepartmentManagementApi apiInstance = new DepartmentManagementApi();
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Department result = apiInstance.deleteDepartment(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepartmentManagementApi#deleteDepartment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Department**](Department.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDepartment"></a>
# **getDepartment**
> Department getDepartment(filters)

List of Departments available

Produces List of Departments available

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.DepartmentManagementApi;


DepartmentManagementApi apiInstance = new DepartmentManagementApi();
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Department result = apiInstance.getDepartment(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepartmentManagementApi#getDepartment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Department**](Department.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="saveDepartment"></a>
# **saveDepartment**
> Department saveDepartment(departmentInput)

Insertion of Department

Creates New entry of a Department

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.DepartmentManagementApi;


DepartmentManagementApi apiInstance = new DepartmentManagementApi();
Department departmentInput = new Department(); // Department | 
try {
    Department result = apiInstance.saveDepartment(departmentInput);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepartmentManagementApi#saveDepartment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **departmentInput** | [**Department**](Department.md)|  |

### Return type

[**Department**](Department.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateDepartment"></a>
# **updateDepartment**
> Department updateDepartment(patchElement, filters)

Department Updation by filter

Produces List of Departments

### Example
```java
// Import classes:
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.invoker.ApiException;
//import in.octosolutions.coreDataManagement.ms.ck.resource.coreData.api.DepartmentManagementApi;


DepartmentManagementApi apiInstance = new DepartmentManagementApi();
PatchElement patchElement = new PatchElement(); // PatchElement | \"Department patch element\" 
List<String> filters = Arrays.asList("filters_example"); // List<String> | - supported qualifiers [==, >=, !=, <=, =@] - \";\" will act as filter separator - \",\" will act as value separator in a particular filter 
try {
    Department result = apiInstance.updateDepartment(patchElement, filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DepartmentManagementApi#updateDepartment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **patchElement** | [**PatchElement**](PatchElement.md)| \&quot;Department patch element\&quot;  |
 **filters** | [**List&lt;String&gt;**](String.md)| - supported qualifiers [&#x3D;&#x3D;, &gt;&#x3D;, !&#x3D;, &lt;&#x3D;, &#x3D;@] - \&quot;;\&quot; will act as filter separator - \&quot;,\&quot; will act as value separator in a particular filter  | [optional]

### Return type

[**Department**](Department.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

