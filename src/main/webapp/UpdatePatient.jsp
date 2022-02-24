<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
.p{
 color:black;
 font-size:40px;
 font-weight:bold;
}
.center {
    text-align:center;   
}
body {
  background-image: url('E://Web Base Java//HospitalManagement/medical.jpg');
  background-repeat: no-repeat;
  background-size: cover;
  margin-top:150px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Update Patient</title>
</head>
<body class="center">
<form  class ="center" action="UpdatePatient" method="post">
<div>Patient ID

<input type="number" name="PetId"/><br>
</div><br>
<div>Patient Name
<input type="text" name="PetName"/><br>
</div><br>
<div>Patient Address
<input type="text" name="PetAdd"/><br>
</div><br>
<div>Patient Phone
<input type="number" name="PetNo"/><br>
</div><br>
<input type="submit" value="Update"/>
</form>
<b >
<%= request.getAttribute("result") %>
</b>
</body>
</html>