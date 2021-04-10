<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<style>
Body {
	font-family: Calibri, Helvetica, sans-serif;
	background-color: rgba(160, 156, 218, 0.877);
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
		<h1>LOGIN SUCCESSFUL</h1>
		<h2>Hello ${USERNAME}</h2>

	</center>

	<div id="container_demo">
		<div id="wrapper">
			<div id="continueusing">
				<form action= "./home"  method="POST">
				<button type="submit">
							Continue using the app
						</button>
					</form>
					</div>
			<div class="logout">
				<form action="./logout">
					<button type="submit">Logout</button>
				</form>
			</div>
			
			 
          <br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br>
			<div class="back">
				<form action="./login">
					<button type="submit">back</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
