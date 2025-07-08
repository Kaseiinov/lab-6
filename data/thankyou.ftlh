<#import "layout.ftlh" as main>
<@main.layout>

    <div class="container-my flex flex-col align-center">
    <h1>${candidate.name} Thank you for your vote!</h1>
    <main class="flex flex-wrap align-center">
    <div class="card">
      <div class="flex flex-col align-center" href="#">
        <img src="images/${candidate.photo}">
        <p>Now I have ${candidate.percentage}%. Thank you for your vote!</p>
      </div>
    </div>

    </main>
    <a class="back flex align-center" href="/">back to main</a>
    <p>-------------------------------------------------------</p>
    <a class="back flex align-center" href="/votes">Show total votes</a>

    </div>
</@main.layout>