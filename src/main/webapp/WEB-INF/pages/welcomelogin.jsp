<!DOCTYPE html>
<html>
<link rel="SHORTCUT ICON" href="static/images/favicon.png" />
<link rel="icon" href="static/images/favicon.png" type="image/png" />

    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous">
    </script>

    <style>
        body{
        	margin: 0;
        	padding: 0;
        	display: flex;
        	justify-content: center;
        	align-items: center;
        	min-height: 100vh;
        	font-family: 'Jost', sans-serif;
        	background: #00acee;
        }
        .main{
        	width: 350px;
        	height: 600px;
        	background: red;
        	overflow: hidden;
        	background: url("https://doc-08-2c-docs.googleusercontent.com/docs/securesc/68c90smiglihng9534mvqmq1946dmis5/fo0picsp1nhiucmc0l25s29respgpr4j/1631524275000/03522360960922298374/03522360960922298374/1Sx0jhdpEpnNIydS4rnN4kHSJtU1EyWka?e=view&authuser=0&nonce=gcrocepgbb17m&user=03522360960922298374&hash=tfhgbs86ka6divo3llbvp93mg4csvb38") no-repeat center/ cover;
        	border-radius: 10px;
        	box-shadow: 5px 20px 50px #000;
        }
        #chk{
        	display: none;
        }
        .Login{
        	position: relative;
        	width:100%;
        	height: auto;
        }
        label{
        	color: #fff;
        	font-size: 1.3em;
        	justify-content: center;
        	display: flex;
        	margin-top: 30px;
        	margin-bottom: 0px;
        	font-weight: bold;
        	cursor: pointer;
        	transition: .5s ease-in-out;
        }
        input{
        	width: 60%;
        	height: 20px;
        	background: #e0dede;
        	justify-content: center;
        	display: flex;
        	margin: 0px auto 20px;
        	padding: 10px;
        	border: none;
        	outline: none;
        	border-radius: 5px;
        }
        button{
        	width: 60%;
        	height: 40px;
        	margin: 10px auto;
        	justify-content: center;
        	display: block;
        	color: #fff;
        	background: #573b8a;
        	font-size: 1em;
        	font-weight: bold;
        	margin-top: 20px;
        	outline: none;
        	border: none;
        	border-radius: 5px;
        	transition: .2s ease-in;
        	cursor: pointer;
        }
        button:hover{
        	background: #6d44b8;
        }

        h4{
            margin-left: 30PX;
            COLOR: #FFFFFF;
        }
        .name_lable{
            margin-left: 150px;
            COLOR: #FFFFFF
        }
        .email_lable{
            margin-left: 150px;
            COLOR: #FFFFFF
        }
        .password_lable{
            margin-left: 140px;
            COLOR: #FFFFFF
        }


    </style>
	<title>Slide Navbar</title>
	<link rel="stylesheet" type="text/css" href="slide navbar style.css">
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>
<body>
	<div class="main">
		<input type="checkbox" id="chk" aria-hidden="true">

		<div class="Login">
        				<form>
        					<label for="chk" aria-hidden="true">Login your account</label>
        					<h4>Welcome to the social network of coders</h4>

        					<lable for="email" class="email_lable">Email</lable><br>
        					<input id="signup-email" type="email" name="email" placeholder="Email" required="">
        					<lable for="password" class="password_lable">Password</lable><br>
        					<input id="signup-password" type="password" name="pswd" placeholder="Password" required="">
        					<button type = "button" id = "btn-signup">Login</button>
        					<p style="color:red; display:none" id="signup-error"></p>
                        </form>
       </div>

	</div>

	<script>
	    function validateSignUpForm(){

	        var email = $("#signup-email").val();
	        var password = $("#signup-password").val();

	        var error = "";

	        if(!email){
	            error += "Email is Empty";
	        }
	        if(!password){
	            error += "Password is empty";
	        }

	        if(password.length <= 3){
	            error +="Password Length Must Be Greater Than 3 Characters";
	        }

	        $("#signup-error").html(error);

	        if(error.length >0){
	            return false;
	        }

	        return true;
	    }
	    $("#btn-signup").click(function(){
	        var isFormValid = validateSignUpForm();
	        if(isFormValid){
	            $("#signup-error").hide();


                var email = $("#signup-email").val();
                var password = $("#signup-password").val();

	            var user = {

	            "email" : email,
	            "password" : password
	            };

	            $.ajax({
	                type: "post",
	                url: "/login/welcome",
	                data: JSON.stringify(user),
	                success: function(response){
	                    if(response){
	                        if(!!response){
	                           if(response.is_logined===true){
	                           location.href="/user/welcome";
	                           }
	                           else{
	                            $("#signup-password").val("");
	                            $("#signup-error").html(response.message);
	                             $("#signup-error").show();
	                           }
	                        }
	                    }
	                },
	                contentType: 'application/json'
	            });

	        }else{
	            $("#signup-error").show();
	        }
	    });
	</script>
</body>
</html>