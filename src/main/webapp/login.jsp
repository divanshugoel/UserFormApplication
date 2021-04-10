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
input[type=text], input[type=password] {
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
		<h1>Login Form</h1>
	</center>
	<div class="container">
		<div id="wrapper">
			<div class="login page">
				<form action="./app" method="POST">

					<label>Username : </label> <input type="text"
						placeholder="Enter Username" name="username" required> </br> <label>Password
						: </label> <input type="password" placeholder="Enter Password"
						name="password" required> </br>
					<button type="submit">Login</button>
					<button type="button" class="cancelbtn">Cancel</button>
					<!-- TODO   CHANGE THE REFERENCE  TO RESET PASSWORD PAGE-->
					Forgot <a href="https://google.com"> Forget Password</a>

					<p color="red">
						<Strong> ${message3} </Strong> <br> <br> <b>
							${message4} </b>
					</p>
				</form>
			</div>


			<div class="back">
				<form action="./">
					<button type="submit">back to welcome page</button>
				</form>
			</div>
		</div>
	</div>

</body>

</html>