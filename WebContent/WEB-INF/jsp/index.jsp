<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/themes/sunny/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	
	$("#findAll").click(function(event){
		$("#error-msg").hide();
		document.location.href="findAll.htm";
	});
	
	$("#findAllProductsInStock").click(function(event){
		$("#error-msg").hide();
		document.location.href="findAllProductsInStock.htm";
	});
	
	$("#findAllProductsOutOfStock").click(function(event){
		$("#error-msg").hide();
		document.location.href="findAllProductsOutOfStock.htm";
	});
	
	$("#searchProduct").click(function() { 

		var productId = $("#productId").val();
		if (productId==''){
		  	$("#error-msg").show();
		  	event.preventDefault();
		}
		else{
			$("#error-msg").hide();
		}
        $.ajax({
            url: "searchproduct.htm",
            type: "POST",
            data: {"productId": productId},
            success: function (response) {
            	var source = $('<div>' + response + '</div>');
              $("#productTable").html(source.find('#productTable'));
            }
        });  

});
});
</script>

<html>
<head>
<title>myRetail</title>

<body>
<div class="panel panel-default">
<div class="panel-heading">
  <h1>myRetail <small>Product Lookup</small></h1>
</div>
</div>
        
        <a href="#" id="findAll" class="btn btn-default" role="button">Find All Products</a>
        <a href="#" id="findAllProductsInStock" class="btn btn-default" role="button">Find All Products in Stock</a>
        <a href="#" id="findAllProductsOutOfStock" class="btn btn-default" role="button">Find All Products out of Stock</a>
        <br>
        <div class="input-group">
        	<span class="input-group-btn">
        		<a href="#" id="searchProduct" class="btn btn-default" role="button">Search</a>
        	</span>
        	<input id="productId" type="text" class="form-control" placeholder="Product Id">
      	</div>
   
   <br><br>
   
   <div class="panel panel-default">
   <div class="panel-heading"><h3>Product Details</h3></div>
   <table id= "productTable" class="table">
   		<tr>
   			<th>Product Id</th>
   			<th>Product Name</th>
   			<th>Product Description</th>
   			<th>Manufacturer</th>
   			<th>Quantity Available</th>
   		</tr>
   		<c:forEach var="product" items="${products}">
	   		<tr>
	   			<td>${product.productId}</td>
	   			<td>${product.name}</td>
	   			<td>${product.description}</td>
	   			<td>${product.manufacturer}</td>
	   			<td>${product.quantity}</td>
	   		</tr>
   			
   		</c:forEach>
   </table>
   </div>
   
  <div hidden="true" id="error-msg" class="alert alert-danger" role="alert">No product id entered to search!!!</div>
   
   
</body>
</html>