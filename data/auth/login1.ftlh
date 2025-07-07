<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login form</title>
    <link rel="stylesheet" href="../css/forms2.css">
</head>

<body>
    <main>
        <form action="/login" method="post">
            <fieldset>
                <div class="legend">
                    <p>Welcome back!</p>
                    <img src="../images/form.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
                </div>
                <div class="form-element">
                    <label for="user-email">Email</label>
                    <input type="email" name="email" id="user-email" placeholder="Your email" required autofocus>
                </div>
                <div class="form-element">
                    <label for="user-password">Password</label>
                    <input type="password" name="password" id="user-password" placeholder="Your password" required>
                </div>
                <div class="hr-line">
                    <span class="details">Enter your credentials to continue</span>
                </div>
                <div class="form-element">
                    <button class="login-button" type="submit">Login!</button>
                </div>
            </fieldset>
        </form>
    </main>
</body>

</html>