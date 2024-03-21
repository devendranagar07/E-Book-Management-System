<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<c:if test="${empty obj }">
	<c:redirect url="../login.jsp"></c:redirect>
</c:if>
<meta charset="ISO-8859-1">
<%@ include file="/components/css.jsp"%>
<title>Add Books</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
			<c:if test="${not empty successmsg }">
				<div class="alert alert-success my-3">${successmsg }</div>
				<c:remove var="successmsg" scope="session"/>
			</c:if>
			<c:if test="${not empty failedmsg }">
				<div class="alert alert-danger my-3">${failedmsg }</div>
				<c:remove var="failedmsg" scope="session"/>
			</c:if>
		<div class="row my-5">
			<div class="col-md-4 offset-4">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h3>Add Book</h3>
					</div>
					<div class="card-body">
						<form action="../BookAdd" method="post" enctype="multipart/form-data">
							<div class="mb-3 form-group">
								<label for="exampleInputPassword1">Book Name</label>
								<input type="text" class="form-control" required id="exampleInputText1" name="bname">
							</div>
							<div class="mb-3 form-group">
								<label for="exampleInputText1">Author Name</label> 
								<input type="text" class="form-control" id="exampleInputText1" required name="baname">
							</div>
							<div class="mb-3 form-group">
								<label for="exampleInputPassword1">Price</label>
								<input type="number" class="form-control" id="exampleInputNumber1" required name="bprice">
							</div>
							<div class="mb-3 form-group">
								<label for="inputState">Book Categories</label>
								<select id="inputState" name="category" class="form-control">
									<option selected>-----Select-----</option>
									<option value="new">New Book</option>									
									<option value="old">Old Book</option>									
								</select>
							</div>
							<div class="mb-3 form-group">
								<label for="inputState">Book Status</label>
								<select id="inputState" name="bstatus" class="form-control">
									<option selected>-----Select-----</option>
									<option value="active">Active</option>
									<option value="inactive">Inactive</option>								
								</select>
							</div>
							<div class="mb-3 form-group">
								<label>Upload Photo</label>
								<input type="file" accept="image/*" class="form-control-file" id="exampleFormControlFile1" name="bimg">
							</div>
							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/components/footer.jsp" %>
</body>
</html>