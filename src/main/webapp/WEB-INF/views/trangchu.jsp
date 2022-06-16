<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tra Cứu Thông Tin Tuyển Sinh</title>
<link rel="stylesheet" href="../../css/index.css" />
</head>
<body>
	<h1>TRA CỨU THÔNG TIN TUYỂN SINH</h1>
	
	<div class="logo"></div>
	

	<form:form class="form" method = "post" action="uploadFile" enctype="multipart/form-data" modelAttribute="myFile">
        <h2>Vui lòng UPLOAD file Excel để hiển thị thông tin tuyển sinh</h2>
        <div class="upload">
	Chọn File: <input type="file" name="multipartFile" /> <br /> <br/>
        </div>
	
	<input type="submit" value="Submit" class="submit" />
	
	
	</form:form>
	
	<footer></footer>
	
</body>
</html>