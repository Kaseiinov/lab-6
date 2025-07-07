<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login form</title>
    <link rel="stylesheet" href="../css/forms2.css">
</head>

<body>
    <main>
        <form action="/register" method="post">
            <fieldset>
                <div class="legend">
                    <p>Welcome!</p>
                    <img src="../images/form.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
                </div>
                <div class="form-element">
                    <label for="first-name">First Name</label>
                    <input type="text" name="first-name" id="first-name" placeholder="Your first name" required>
                </div>
                <div class="form-element">
                    <label for="last-name">Last Name</label>
                    <input type="text" name="last-name" id="last-name" placeholder="Your last name" required>
                </div>
                <div class="form-element">
                    <label for="user-email">Email</label>
                    <input type="email" name="email" id="user-email" placeholder="Your email" required autofocus>
                </div>
                <div class="form-element">
                    <label for="user-password">Password</label>
                    <input type="password" name="user-password" id="user-password" placeholder="Your password" required>
                </div>
                <div class="hr-line">
                    <span class="details">One more step to go</span>
                </div>
                <div class="form-element">
                    <button class="register-button" type="submit">Login!</button>
                </div>
            </fieldset>
        </form>
    </main>
</body>

</html>