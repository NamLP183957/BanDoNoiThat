<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<div id="content-wrapper" class="col-xl-10 col-sm-9"
			style="float: right;">
			<div class="container-fluid">

				<div class="breadcrumb">
					<a href="#">Sản phẩm </a> / Mẫu thiết kế
				</div>

				<div class="container-fluid row">
					<button type="button"
						class="btn btn-outline-primary col-xl-2 col-sm-6 mb-3">Chung
						cư</button>
					<button type="button"
						class="btn btn-outline-warning col-xl-2 col-sm-6 mb-3">Khách
						sạn</button>
					<button type="button"
						class="btn btn-outline-secondary col-xl-2 col-sm-6 mb-3">Biệt
						thự</button>
					<button type="button"
						class="btn btn-outline-danger col-xl-2 col-sm-6 mb-3">Phòng
						khách</button>
					<button type="button"
						class="btn btn-outline-success col-xl-2 col-sm-6 mb-3">Phòng
						ngủ</button>
					<button type="button"
						class="btn btn-outline-info col-xl-2 col-sm-6 mb-3">Phòng
						bếp</button>
				</div>

				<div class="breadcrumb">
					<p>Chung cư</p>
				</div>

				<div class="container-fluid row">
					<div class="col-sm-10">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>STT</th>
									<th>Sản phẩm</th>
									<th>Chi tiết</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listProduct}" var="product">
									<tr> 
										<td>${product.id} </td>
										<td>${product.name} </td>
										<td><a href="productDetail?id=${product.id}">chi tiết </a></td>
									</tr>
								
								 </c:forEach>
							</tbody>
						</table>
					</div>

					<div class="col-sm-2">
						<button class="btn btn-primary col-sm-12 mb-3" onclick="location.href='addProduct?type=${type}'">Thêm</button>
					</div>
				</div>
			</div>

		</div>
</body>
</html>