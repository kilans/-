<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册页面</title>
<style type="text/css">
	*{
		padding:0;
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
		background-image: url(http://http://118.202.41.251:8080/BookManagement/Book/Login/user_login.jsp:8080/BookManagement/Book/Image/book.png);
	}
	.container{
	    position: relative;
	    z-index: 1;
	    background-color: #fff;
	    border-radius: 15px;
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	    width: 550px;
	    height: 720px;
	    box-shadow: 0 5px 20px rgba(0,0,0,0.1);
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
	    height: 20px;
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
			<div class="input">
				<form action="http://http://118.202.41.251:8080/BookManagement/Book/Login/user_login.jsp:8080/BookManagement/UserRegister" method="post">
					<center>
					<br>
					<input name="loginjudge" value="null" type="hidden">
						<input type="text" name="sid" 
							class="input-item" size="20" placeholder="学号" required><br>
						<br>
						<input type="text" name="name" 
							class="input-item" size="20" placeholder="姓名" required><br>
						<br>
						<input type="text" name="sex" 
							class="input-item" size="20" placeholder="性别" required><br>
						<br>
						<input type="text" name="major" 
							class="input-item" size="20" placeholder="专业" required><br>
						<br>
						<input type="text" name="account" 
							class="input-item" size="20" placeholder="账号" required><br>
						<br> 
						<input type="password" name="password" 
							class="input-item" size="20" placeholder="密码" required><br>
						<br>
						<br> <input type="submit" value="注册"  name="button" id="button">
					</center>
				</form>
				<br>
				<div class="other" align="center">
                <a href="admin_login.jsp">管理端登录</a><br>
                                            已有账号？<a href="user_login.jsp">去登陆</a>
                </div>
			</div>
		</div>
	</div>
</body>
</html>