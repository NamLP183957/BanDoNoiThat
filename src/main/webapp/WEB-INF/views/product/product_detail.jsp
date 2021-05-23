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
	<link href="<c:url value='/template/admin/css/product_detail.css' />" type="text/css" rel="stylesheet">
	<div class="col-lg-10 col-sm-9" style="float: right;">
		<div class="container-fluid">
			<div class="breadcrumb rows">
				<div class="col-lg-7 col-sm-5 text-primary">Chi tiết sản phẩm</div>
				<div class="col-lg-5 col-sm-7 row">
					<form class="col-lg-4 col-sm-12"
						action="deleteProduct?id=${product.id}&type=${product.type}"
						method="post">
						<button type="submit" class="btn btn-outline-danger"
							style="width: 100%" onclick="return deleteConfirm()">Xóa</button>
					</form>
					
					<button class="col-lg-4 col-sm-12 btn btn-outline-success"
						form="addImage">Lưu </button>
				</div>
			</div>
			<div style="display: inline-block; width: 100%;">
				<img id="mainImage" src="data:image/jpg;base64, ${mainImage.base64Image}"
					class="col-lg-8" style="float: left;">
				<div class="col-lg-4" style="float: right;">
					<h3 class="text-success">${updateStatus}</h3>
					<form class="form-horizonal"
						action="updateProduct?id=${product.id}"
						enctype="multipart/form-data" method="post">
						<div class="form-group form-check-inline w-100">
							<label class="col-sm-2 col-xl-2 text-dark" for="name">Tên:</label>
							<div class="col-sm-10 col-xl-9">
								<input type="text" class="form-control" id="name"
									placeholder="tên sản phẩm" name="name" value="${product.name}">
							</div>
						</div>

						<div class="form-group form-check-inline w-100">
							<label class="col-sm-2 col-xl-2 text-dark" for="description">Mô
								tả: </label>
							<div class="col-sm-10 col-xl-9 text-dark">
								<textarea class="form-control" id="décription" rows="5"
									placeholder="mô tả sản phẩm" name="description">${product.description}</textarea>
							</div>
						</div>
						<div class="form-group form-check-inline w-100">
							<label class="col-sm-2 col-xl-2 text-dark" for="price">Giá:
							</label>
							<div class="col-sm-10 col-xl-9">
								<input type="text" class="form-control" id="price"
									placeholder="Giá sản phẩm" name="price"
									value="${product.price}">
							</div>
						</div>

						<div class="form-group form-check-inline w-100">
							<label class="col-sm-2 col-xl-2 text-dark" for="number">Còn
								lại: </label>
							<div class="col-sm-10 col-xl-9">
								<input type="text" class="form-control" id="number"
									placeholder="Số lượng" name="number"
									value="${product.numberInWare }">
							</div>
						</div>

						<div class="form-group form-check-inline w-100">
							<label class="col-sm-2 col-xl-2 text-dark" for="style">Phong
								cách</label>
							<div class="col-sm-10 col-xl-9">
								<input type="text" class="form-control" id="style"
									placeholder="Phong cách" name="style" value="${product.style}">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-success">Chỉnh sửa</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="rows">
				<c:forEach items="${listImage}" var="img">
					<img class="imageProduct" src="data:image/jsp;base64, ${img.base64Image}">
				</c:forEach>
				<img id="insertImage" class="imageProduct" src="#" style="display: none">
				<form id="addImage" action="addImage?id=${product.id}" enctype="multipart/form-data" method="post">
					<label style="cursor: pointer;">
						<i class="far fa-plus-square"
							style="font-size: 60px; padding-top: 100px;"></i>
						<input type="file" onchange="readURL(this);" name="image"
						style="opacity: 0; z-index: -1; position: absolute;">
					</label>
				</form>

			</div>

		</div>

	</div>

	<script type="text/javascript">
		function deleteConfirm() {
			return confirm("Bạn có chắc muốn xóa không?")
		}

		function readURL(input){
			if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#insertImage')
                        .attr('src', e.target.result);
                    $('#insertImage').css("display", "inline")
                };

                reader.readAsDataURL(input.files[0]);
            }
		}
	</script>
	<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
</body>
</html>