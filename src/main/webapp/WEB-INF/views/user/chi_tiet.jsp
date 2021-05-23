<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

	<div class="container" >
        <div class="container-fluid">
            <div class="breadcrumb rows" >
                <div class="col-lg-7 col-sm-5 text-primary">Chi tiết sản phẩm</div>
                <div class="col-lg-5 col-sm-7">
                    <button class="btn btn-outline-warning col-lg-3 col-sm-12" href="DatHang/id=${product.id}">Đặt hàng:</button>
                    <button class="btn btn-outline-danger col-lg-3 col-sm-12">Xóa</button>
                    <c:if test="${product.numberInWare > 0}">
                    	<button class="btn btn-success col-lg-4 col-sm-12">Số lương: ${product.numberInWare}</button>	
                    </c:if>
                    
                    <c:if test="${product.numberInWare <= 0}">
                    	<button class="btn btn-danger col-lg-4 col-sm-12">Hết hàng</button>
                    </c:if>
                </div>
            </div>
            <div style="display: inline-block;">
                <img src="data:image/jsp;base64, ${mainImage.base64Image }" class="col-lg-8" style="float: left;">
                <div class="col-lg-4" style="float: right;">
                    <div><h1 class="text text-dark">${product.name }</h1> </div>
                    <div><h5 class="text text-secondary">${product.description }</h5></div>
                    
                </div>
            </div>
            <div class="rows" >
            	<c:forEach items="${listImage}" var="image" >
            		<img src="data:image/jsp;base64, ${image.base64Image}" style="max-width: 33%; margin-left: 15px; margin-top: 15px; height: 200px;" >
            	</c:forEach>   
               
            </div>
            
        </div>
        
    </dib>

</body>
</html>