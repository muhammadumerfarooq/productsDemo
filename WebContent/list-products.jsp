<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Products List App</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
<script src="js/sorttable.js"></script>
</head>

<%-- <%
	List<Product> products = (List<Product>) request.getAttribute("PRODUCT-LIST");
%> --%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Products List</h2>


		</div>
	</div>
<br>
	<div id="searchword">
		 <label  for="search">Search Here:</label>
		<input type="text"
			id="search" name="Submit">
		<button onclick="sortTable()">Submit</button>
	</div>

	<div id="container">
		<div id="content">
			<table id="mytable" class="sortable">
				<tr>
					<th>Contract Plan
					<input id="ContractPlan" class = "checkmark" type="checkbox" checked="checked" onclick="checkmarkclick()">
					</th>
					<th>Contract
					<input id="Contract" class = "checkmark" type="checkbox" checked="checked" onclick="checkmarkclick()">
					</th>
					<th>Brand Name
					<input id="Brand" class = "checkmark"  type="checkbox" checked="checked"  onclick="checkmarkclick()">
					</th>
					<th>Plan Name
					<input id="Plan"  class = "checkmark"  type="checkbox" checked="checked"  onclick="checkmarkclick()">
					</th>
					<th>State
					<input id="State" class = "checkmark"  type="checkbox" checked="checked"  onclick="checkmarkclick()">
					</th>
					<th>State Abbreviation
					<input id="Abbreviation" class = "checkmark"  type="checkbox" checked="checked"  onclick="checkmarkclick()">
					</th>
					<th>Product Type
					<input id="Type" class = "checkmark"  type="checkbox" checked="checked"  onclick="checkmarkclick()">
					</th>
				</tr>
			
				<c:forEach var = "tempProduct" items="${PRODUCT_LIST}">
					
				<tr>
					<td>${tempProduct.contractplansegcompl}</td>
					<td>${tempProduct.contract}></td>					
					<td>${tempProduct.brandname}</td>
					<td>${tempProduct.planname}></td>
					<td>${tempProduct.state}></td>
					<td>${tempProduct.stateabbreviation}></td>
					<td>${tempProduct.producttype}></td>

				</tr>
			  </c:forEach>
			</table>
		</div>
	</div>


	<script>
	function checkmarkclick(){
		event.stopPropagation()
	}
		function sortTable() {
			var input, filter, table, tr, td, i, j;
			
			var Contract = 	 document.getElementById("Contract")
			var ContractPlan = 	 document.getElementById("ContractPlan");
			var Brand =	 document.getElementById("Brand")
			var Plan =	 document.getElementById("Plan")         
			var State =	 document.getElementById("State")             
			var Abbreviation =	 document.getElementById("Abbreviation")
			var Type =	 document.getElementById("Type")      

			
			input = document.getElementById("search");
			filter = input.value.toUpperCase();
			table = document.getElementById("mytable");

			tr = table.getElementsByTagName("tr");

			var exists = false;
			for (i = 0; i < tr.length; i++) {
				 exists = false;
				for (j = 0; j < tr[i].getElementsByTagName("td").length; j++) {
					td = tr[i].getElementsByTagName("td")[j];
				
				var checked = 	j == 0 ? ContractPlan.checked : 
					j == 1 ? Contract.checked : j == 2 ? Brand.checked : 
					j == 3 ? Plan.checked	: j == 4 ? State.checked : 
					j == 5 ? Abbreviation.checked :
					j == 6 ? Type.checked : false;
					
				
					if (td && checked) {
						console.log(td.innerHTML.toUpperCase() , " ",td.innerHTML.toUpperCase().indexOf(filter))
						if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
							tr[i].style.display = "";
							exists = true;
						} else {
							tr[i].style.display = exists == false ? "none"  : "";
						//	tr[i].style.display = "none" 
						}
					}

				}
			}
		}
	</script>

</body>


</html>