<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理端登录界面</title>
<style type="text/css">
	*{
		padding:10;
		margin:0;
		font-family:宋体;
		letter-spacing:.05em;
	}
	html{
		height:100%;
	}
	body{
	    height: 100vh;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    /*background: linear-gradient(35deg, #CCFFFF, #FFCCCC);*/
	    overflow: hidden;
		background-image: url(http://118.202.41.251:8080/BookManagement/Book/Image/book.png);
	}
	.container{
	    position: relative;
	    z-index: 1;
	    background-color: #fff;
	    border-radius: 15px;
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	    width: 350px;
	    height: 550px;
	    box-shadow: 0 5px 20px rgba(0,0,0,0.1);
	}
	.container .title{
	    font-size: 26px;
	    margin: 65px auto 70px auto;
	}
	.container input{
	    width: 280px;
	    height: 30px;
	    text-indent: 8px;
	    border: none;
	    border-bottom: 1px solid #ddd;
	    outline: none;
	    margin: 12px auto;
	}
	.container #button{
	    width: 280px;
	    height: 40px;
	    margin: 35px auto 40px auto;
	    border: none;
	    background: linear-gradient(35deg, #CCFFFF, #FFCCCC);
	    color: #fff;
	    font-weight: bold;
	    letter-spacing: 8px;
	    border-radius: 10px;
	    cursor: pointer;
	    /* 动画过渡 */
		transition: 0.5s;
	}
	.container #button:hover{
	    background: linear-gradient(35deg, #CCFFFF, #FFCCCC);
	    background-position-x: -280px;
	}
	.container a{
	    color: plum;
	    text-decoration: none;
	}
</style>

</head>
<body>
	<div class="container">
		<div class="login">
			<br>
			<div class="title" align="center">
				<b>管理员登录</b>
			</div>
			<div class="input">
				<form action="http://118.202.41.251:8080/BookManagement/AdminLogin" method="post">
					<center>
					<br>
					<input name="loginjudge" value="null" type="hidden">
						<input type="text" name="account" 
							class="input-item" size="22" placeholder="账号" required><br>
						<br> 
						<input type="password" name="password" 
							class="input-item" size="22" placeholder="密码" required><br>
						<br> <input type="submit" value="登录" name="button" id="button">
					</center>
				</form>
				<br>
				<div class="other" align="center">
                <a href="user_login.jsp">用户端登录</a>
                </div>
			</div>
		</div>
	</div>
</body>
</html>