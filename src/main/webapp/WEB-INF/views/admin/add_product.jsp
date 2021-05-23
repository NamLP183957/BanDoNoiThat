<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
	<div id="content-wrapper" class="col-xl-10 col-sm-9 mt-3"
		style="float: right;">
		<form class="form-horizonal" action="saveProduct?type=${type}" enctype="multipart/form-data" method="post">
			<div class="form-group form-check-inline w-100">
				<label class="col-sm-2 col-xl-2 text-dark" for="name"><h5>Tên
						sản phẩm:</h5></label>
				<div class="col-sm-10 col-xl-9">
					<input type="text" class="form-control" id="name"
						placeholder="tên sản phẩm" name="name">
				</div>
			</div>

			<div class="form-group form-check-inline w-100">
				<label class="col-sm-2 col-xl-2 text-dark" for="description"><h5>Mô
						tả:</h5></label>
				<div class="col-sm-10 col-xl-9 text-dark">
					<textarea class="form-control" id="décription" rows="5"
						placeholder="mô tả sản phẩm" name="description"></textarea>
				</div>
			</div>
			<div class="form-group form-check-inline w-100">
				<label class="col-sm-2 col-xl-2 text-dark" for="price"><h5>Giá</h5></label>
				<div class="col-sm-10 col-xl-9">
					<input type="text" class="form-control" id="price"
						placeholder="Giá sản phẩm" name="price">
				</div>
			</div>

			<div class="form-group form-check-inline w-100">
				<label class="col-sm-2 col-xl-2 text-dark" for="number"><h5>Số
						lượng trong kho</h5></label>
				<div class="col-sm-10 col-xl-9">
					<input type="text" class="form-control" id="number"
						placeholder="Số lượng" name="number">
				</div>
			</div>

			<div class="form-group form-check-inline w-100">
				<label class="col-sm-2 col-xl-2 text-dark" for="style"><h5>Phong
						cách</h5></label>
				<div class="col-sm-10 col-xl-9">
					<input type="text" class="form-control" id="style"
						placeholder="Phong cách" name="style">
				</div>
			</div>

			<div class="form-group form-check-inline w-100">
				<label class="col-sm-2 col-xl-2 text-dark" for="images"><h5>Hình
						ảnh</h5></label>
				<div class="col-sm-10 col-xl-9">
					<input type="file" id="images" name="images" multiple="multiple">
				</div>
			</div>

			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Thêm</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>