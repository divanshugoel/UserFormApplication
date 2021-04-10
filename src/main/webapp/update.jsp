<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<style>
Body {
	font-family: Calibri, Helvetica, sans-serif;
	background-color: rgba(245, 245, 245, 0.877);
}

button {
	background-color: #4cacafb4;
	width: 50%;
	color: rgb(5, 5, 5);
	padding: 15px;
	margin: 10px 0px;
	border: none;
	cursor: pointer;
}

/* form {   
                border: 3px solid #0e0101;   
            }    */
input[type=text], input[type=password], input[type=email], input[type=number]
	{
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: block;
	border: 2px solid rgb(1, 7, 1);
	box-sizing: border-box;
}

button:hover {
	opacity: 0.7;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	margin: 10px 5px;
}

.container {
	padding: 100px;
	background-color: lightblue;
}
</style>


<script type = "text/javascript">
function validate() {
	if( document.updateform.phonenumber.value == "" || isNaN( document.updateform.phonenumber.value ) ||
            document.updateform.phonenumber.value.length != 10 ){
		
		document.updateform.phonenumber.focus() ;
		alert( "Please provide the correct phone number" );
	 return false;
}
	else{
		return (true);
	}
}
</script>
</head>

<body>
	<center>
		<h1>!!!!!!Update User Details!!!!!</h1>
	</center>

	<div id="container">
		<div id="wrapper" class= "container">

			<div id=" update" class="update user">
				<form action="./update"  name = "updateform" onsubmit = "return(validate());" method="POST">
					<label>First Name : </label> <input type="text"
						placeholder="Enter your first name" name="firstname" required>
					</br> <label>Last Name : </label> <input type="text"
						placeholder="Enter your Last name" name="lastname" required>
					</br> <label>Password : </label> <input type="password"
						placeholder="Enter Password" name="password" required> </br> <label>Email
						: </label> <br> <input type="email" placeholder="Enter your Email"
						name="email" required> </br> <label>Address : </label> <input
						type="text" placeholder="Enter your address" name="address"
						required> </br> <label>PhoneNumber : </label> <br> <input
						type="number" placeholder="Enter your phone number"
						name="phonenumber" required> </br>
					<button type="submit">Update</button>
				</form>
			</div>
			<div class="back">
				<form action="./home">
					<button type="submit">back</button>
				</form>
			</div>
			<div class="logout">
				<form action="./logout">
					<button type="submit">Logout</button>
				</form>
			</div>
        
			
		</div>
	</div>

</body>

</html>