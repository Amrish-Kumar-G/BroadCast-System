<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<! DOCTYPE html>  
<html lang="en" >  
<head>  
  <meta charset="UTF-8">  
  <title> Sign Up  
</title>  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">  
<link href="https://fonts.googleapis.com/css2?family=Rubik+Moonrocks&display=swap" rel="stylesheet">
</head>  
<style>  
body {  
          background-repeat: no-repeat, repeat;  
          background-position: center;  
          background-size: cover;  
          padding-top: 50px; 
          background-image: url('./images/background4.gif');
            /* background-color: rgb(12, 11, 11); */
        }  
        .login-form {  
          background:rgba(0, 0, 0, 0);  
          margin-top: 40px;  
          margin-bottom: 100px;  
          padding: 100px;  
          border-radius: 50px;  
          color: white;  
          box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);  
        }  
        .login-heading {  
          text-align: center;  
          margin-top: 20px;  
        }  
        /* .btn-primary {
            position: relative;
            display: block;
            align-items: center;
            border: #29ccd7 block;
          margin-left:38%;   
          text-align: center;
          align-content: center;
          width:120px;
          background-color:whitesmoke ;
          color:black;
          border-radius: 4px; 
          font-weight: bolder;
          font-size: larger;
          font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        } */
        /* .btn-primary:hover{
            background-color: #29ccd7;
            color:white;
        }   */
        .form-login{
            text-align: center;
            padding:20 0 0;
            color:white;
        }
        .login-button{
            color:orange;
            font-weight: bold;
            font-size: large;
        }
        .login-button:hover{
            text-decoration: none;
            color:orange;
            font-weight: bolder;
            font-size: larger;
        }
        label{
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
            font-size: large;
        }
        .forbutton{
            box-shadow: 5px 5px 5px black;
            border-radius: 10px;
            width:100px;
            background-color: orange;
            font-weight: bold;
            font-size: large;
            color:black;
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
            /* margin-left:35%; */}
        .forbutton:hover{
            background-color: orange;
            /* width:110px;
            height: 40px; */
            font-size: larger;
        }
        .heading{
            color:orange;
            /* font-family: 'Rubik Moonrocks', cursive; */
            font-family:Arial, Helvetica, sans-serif;
            font-weight: bolder;
        }
        label{
            color:orange;
        }
</style>  
<body>    
<script defer type="text/javascript" src='./jsfiles/signup.js'>
    
    </script>
    <div class="container">  
      <div class="row">  
        <div class="col-md-8 offset-md-2">  
          <div class="login-form"> 
            <h1 class="text-center heading"> Sign Up </h1> 
            <form id="form"  action="register" method="post"  name="f1">  
              <div class="form-group"> 
                <br> 
                <label >Name </label>  
                <input type="text" class="form-control" id="name" name="name" placeholder="name">  
                <!-- <small id="emailHelp" class="form-text text-muted"> We'll never share your email with anyone else. </small>   -->
              </div> 
              <div class="form-group">  
                <label > Password </label>  
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="">  
              </div> 
              <div class="form-group">  
                <label > Confirm Password </label>  
                <input type="password" class="form-control" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password" value="">  
              </div>
              <div class="form-group">  
                <label > Nick Name </label>  
                <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Nickname" >  
              </div>
              <div class="form-group">  
                <label > Mobile Number </label>  
                <input type="number" class="form-control" id="mobilenumber" name="mobilenumber" placeholder="Mobile Number" >  
              </div>  
              <div class="form-group form-check" id="error" style="color:red;">  
              </div> 
              <br> 
              <button type="submit" class="btn btn-primary bt-lg forbutton" id='submit'> Signup </button>  
              <p class="form-login">Already a User? <a href="index.jsp" class="login-button">Login</a> </p>
            </form>  
          </div>  
        </div>  
      </div>  
    </div>  
    
  </body>  
</html>