
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sign in and Sign up</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        .signin-signup {
            position: absolute;
            top: 50%;
            left: 75%;
            transform: translate(-50%, -50%);
            display: grid;
            grid-template-columns: 1fr;
            z-index: 8;
        }

        .signup-signup{
            position: absolute;
            top: 42%;
            left: 22%;
            transform: translate(-50%,-50%);
            display: grid;
            grid-template-columns: 1fr;
            z-index: 5;
        }

        .container.sign-up-mode .signup-signup{
            z-index: 8;
            transition: 4s ease-in-out;
        }

        .container.sign-up-mode .signin-signup{
            transition: 3s ease-in-out;
        }



        .error{
          position: absolute;
          justify-content: center;
          align-items: center;
          left: 432px;
          width: 400px;
          z-index: 6;
          bottom: 534px;
        }

        :root {
          --shadow-color: #FF9E9E;
          --shadow-color-light: #f70d1a;
        }


        span {
          margin: calc(50vh - 40px) auto 0 auto;
          font-size: 26px;
          text-transform: uppercase;
          font-family: "Archivo Black", "Archivo", sans-serif;
          font-weight: normal;
          display: block;
          height: auto;
          text-align: center;
        }

        .error {
          color: #f70d1a;
          animation: neon 3s infinite;
        }

        @keyframes neon {
          0% {
            text-shadow: -1px -1px 1px var(--shadow-color-light), -1px 1px 1px var(--shadow-color-light), 1px -1px 1px var(--shadow-color-light), 1px 1px 1px var(--shadow-color-light),
            0 0 3px var(--shadow-color-light), 0 0 10px var(--shadow-color-light), 0 0 20px var(--shadow-color-light),
            0 0 30px var(--shadow-color), 0 0 40px var(--shadow-color), 0 0 50px var(--shadow-color), 0 0 70px var(--shadow-color), 0 0 100px var(--shadow-color), 0 0 200px var(--shadow-color);
          }
          50% {
            text-shadow: -1px -1px 1px var(--shadow-color-light), -1px 1px 1px var(--shadow-color-light), 1px -1px 1px var(--shadow-color-light), 1px 1px 1px var(--shadow-color-light),
            0 0 5px var(--shadow-color-light), 0 0 15px var(--shadow-color-light), 0 0 25px var(--shadow-color-light),
            0 0 40px var(--shadow-color), 0 0 50px var(--shadow-color), 0 0 60px var(--shadow-color), 0 0 80px var(--shadow-color), 0 0 110px var(--shadow-color), 0 0 210px var(--shadow-color);
          }
          100% {
            text-shadow: -1px -1px 1px var(--shadow-color-light), -1px 1px 1px var(--shadow-color-light), 1px -1px 1px var(--shadow-color-light), 1px 1px 1px var(--shadow-color-light),
            0 0 3px var(--shadow-color-light), 0 0 10px var(--shadow-color-light), 0 0 20px var(--shadow-color-light),
            0 0 30px var(--shadow-color), 0 0 40px var(--shadow-color), 0 0 50px var(--shadow-color), 0 0 70px var(--shadow-color), 0 0 100px var(--shadow-color), 0 0 200px var(--shadow-color);
          }
        }
    </style>
</head>

<body>

<div class="container">

  <span class="error"> <s:property value="massage"/> </span>

  <div class="forms-container">
    <div class="signin-signup">
      <form method="get" action="login.action" class="sign-in-from">
        <h2 class="titile">Sign In</h2>

        <div class="input-field">
          <i class="fas fa-user"></i>
          <input type="text" placeholder="Username" id="user_name1" name="user_name" required/>
        </div>
        <div class="input-field">
          <i class="fas fa-lock"></i>
          <input type="password" placeholder="Password" id="password1" name="password" required />
        </div>
        <input type="submit" class="btn btn-solid" value="Login">
        <p class="social-text">Or Sign in with social platforms</p>
        <div class="social-media">
          <a href="#" class="social-icon">
            <i class="fab fa-facebook-f"></i>
          </a>
          <a href="#" class="social-icon">
            <i class="fab fa-twitter"></i>
          </a>
          <a href="#" class="social-icon">
            <i class="fab fa-google"></i>
          </a>
          <a href="#" class="social-icon">
            <i class="fab fa-linkedin-in"></i>
          </a>
        </div>
      </form>
    </div>

    <div class="signup-signup">

      <form method="post" action="signup.action" class="sign-up-from">
        <h2 class="titile">Sign Up</h2>
        <div class="input-field">
          <i class="fas fa-user"></i>
          <input type="text" placeholder="Username" id="user_name" name="user_name" required />
        </div>
        <div class="input-field">
          <i class="fas fa-envelope"></i>
          <input type="email" placeholder="Email" id="email_address" name="email_address" required />
        </div>
        <div class="input-field">
          <i class="fas fa-lock"></i>
          <input type="password" placeholder="Password" id="password" name="password" required />
        </div>
        <input type="submit" class="btn btn-solid" value="Sign Up" id="submituser">
        <p class="social-text">Or Sign Up with social platforms</p>

        <div class="social-media">
          <a href="#" class="social-icon">
            <i class="fab fa-facebook-f"></i>
          </a>
          <a href="#" class="social-icon">
            <i class="fab fa-twitter"></i>
          </a>
          <a href="#" class="social-icon">
            <i class="fab fa-google"></i>
          </a>
          <a href="#" class="social-icon">
            <i class="fab fa-linkedin-in"></i>
          </a>
        </div>
      </form>
    </div>


  </div>
  <div class="panels-container">
    <div class="panel left_panel">
      <div class="content">
        <h3>New Here ?</h3>
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
        <button class="btn transparent" id="sign-up-button">Sign Up</button>
      </div>
      <img src="${pageContext.request.contextPath}/img/undraw_working_remotely_jh40.svg" alt="" class="image">

    </div>

    <div class="panel right_panel">
      <div class="content">
        <h3>One Of Us</h3>
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
        <button class="btn transparent" id="sign-in-button">Sign In</button>
      </div>
      <img src="${pageContext.request.contextPath}/img/undraw_Login_re_4vu2.svg" alt="" class="image">
    </div>
  </div>
</div>

<script type="text/javascript">

  const sign_in_btn = document.querySelector('#sign-in-button');
  const sign_up_btn = document.querySelector('#sign-up-button');

  const sign_up_input = document.querySelector('#submituser');

  const container = document.querySelector('.container');

  sign_up_btn.addEventListener('click',()=>{
    container.classList.add('sign-up-mode');
  })

  sign_in_btn.addEventListener('click',()=>{
    container.classList.add('sign-in-mode');
  })

  sign_up_input.addEventListener('click',()=>{
    container.classList.add('error-massage');
  })


</script>
</body>
</html>
