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
</head>

<body>
	<center>
		<h1>!!!!!!User Details!!!!!</h1>
	</center>

	<div id="container">
		<div id="wrapper"  class ="container ">
			<div id="get user details " class="user details">
				<form action="./home" method="POST">
					<label>First Name : </label> &nbsp; &nbsp; <input type="text"
						name="firstname" value=${firstname}> <label>Last
						Name : </label> &nbsp; &nbsp; <input type="text" value=${lastname
						} name="lastname"> <label>Email : </label> &nbsp; &nbsp; <input
						type="email" value=${email } name="email"> <label>Address
						: </label> &nbsp; &nbsp; <input type="text" value=" ${address} "
						+ name="address"> <label>PhoneNumber : </label> &nbsp;
					&nbsp; <input type="number" value=${phonenumber
						} name="phonenumber">
					<button type="submit">click here to return to home page</button>
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