<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>THÔNG TIN TUYỂN SINH</title>
<link rel="stylesheet" href="../../css/ketqua.css" />
</head>
<body>
	<h1>TRA CỨU THÔNG TIN TUYỂN SINH</h1>
	<div class="form">
		<form:form method="post" action="search" modelAttribute="timkiem" class="form">
			<div class="input">
				<span>Mã Học Sinh :</span>
				<form:input path="maHocSinh"/>
			</div>
			<div class="input" style="margin-left:22px;">
				<span>Họ Và Tên :</span>
				<form:input path="hoTen" />
			</div>
			<input type="submit" value="Tìm Kiếm" style="margin: auto;"/>
		</form:form>
	</div>
	
	<table>
		<tr>
			<td>STT</td>
			<td>Trường Tiểu Học</td>
			<td>Quận/Huyện</td>
			<td>Mã Học Sinh</td>
			<td>Lớp</td>
			<td>Họ và tên</td>
			<td>Ngày</td>
			<td>Tháng</td>
			<td>Năm</td>
			<td>Giới tính</td>
			<td>Nơi sinh</td>
			<td>Dân tộc</td>
			<td>Hộ khẩu thường trú</td>
			<td>Điện thoại liên hệ</td>
			<td>Tổng điểm năm lớp 1</td>
			<td>Tổng điểm năm lớp 2</td>
			<td>Tổng điểm năm lớp 3</td>
			<td>Tổng điểm năm lớp 4</td>
			<td>Tổng điểm năm lớp 5</td>
			<td>Tổng điểm kết quả 5 năm</td>
			<td>Điểm ưu tiên</td>
			<td>Tổng điểm sơ tuyển</td>
			<td>Ghi chú</td>
		</tr>
		<c:forEach items="${CacHocSinh}" var="item" >
			<tr>
				<td >${item.stt}</td>
				<td >${item.truong}</td>
				<td >${item.quanHuyen}</td>
				<td >${item.maHocSinh}</td>
				<td >${item.lop}</td>
				<td >${item.hoTen}</td>
				<td >${item.ngay}</td>
				<td >${item.thang}</td>
				<td >${item.nam}</td>
				<td >${item.gioiTinh}</td>
				<td >${item.noiSinh}</td>
				<td >${item.danToc}</td>
				<td >${item.hoKhau}</td>
				<td >${item.dienThoai}</td>
				<td >${item.diem1}</td>
				<td >${item.diem2}</td>
				<td >${item.diem3}</td>
				<td >${item.diem4}</td>
				<td >${item.diem5}</td>
				<td >${item.diem5nam}</td>
				<td >${item.uuTien}</td>
				<td >${item.tongDiem}</td>
				<td >${item.ghiChu}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>