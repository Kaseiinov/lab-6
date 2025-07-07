<#import "../layout.ftlh" as main>
<@main.layout>
<main>
    <form action="/register" method="post">
        <fieldset>
            <div class="legend">
                <p>Welcome!</p>
                <img src="/images/1.jpg" alt="coins" style="display:block; width: 200px; height: 200px;">
            </div>
            <div class="form-element">
                <label for="user-email">email</label>
                <input type="email" name="email" id="user-email" placeholder="your email" required autofocus>
            </div>
            <div class="form-element">
                <label for="user-firstName">First name</label>
                <input type="text" name="user-firstName" id="user-firstName" placeholder="your first name" required>
            </div>
            <div class="form-element">
                <label for="user-lastName">Last Name</label>
                <input type="text" name="user-lastName" id="user-lastName" placeholder="your last name" required>
            </div>
            <div class="form-element">
                <label for="user-password">password</label>
                <input type="password" name="user-password" id="user-password" placeholder="your password" required>
            </div>
            <div class="hr-line">
                <span class="details">one more step to go</span>
            </div>
            <div class="form-element">
                <button class="register-button" type="submit">Register!</button>
            </div>
        </fieldset>
    </form>
</main>
</@main.layout>