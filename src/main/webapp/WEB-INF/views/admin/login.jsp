<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<div class="container">
        <div class="card card-login mt-5 col-lg-5 col-sm-10 border border-primary" style="margin-left: 30%;">
          <div class="card-header border border-primary">Login</div>
          <div class="card-body">
            <form action="authenciate">
              <div class="form-group mt-3">
                <div class="form-label-group">
                  <input type="text" id="inputEmail" class="form-control" placeholder="Username" required="required" autofocus="autofocus"
                  name="username">
                  
                </div>
              </div>
              <div class="form-group mt-3">
                <div class="form-label-group">
                  <input type="password" id="inputPassword" class="form-control" placeholder="Password" 
                  name="password" required="required">
                  
                </div>
              </div>
              <div class="form-group mt-5">
                <div class="checkbox">
                  <label>
                    <input type="checkbox" value="remember-me">
                    Remember Password
                  </label>
                </div>
              </div>
              <button class="btn btn-success btn-block" style="color: white;">Login </button>
            </form>
          </div>
        </div>
      </div>
</body>
</html>