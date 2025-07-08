<#import "layout.ftlh" as main>
<@main.layout>

    <div class="container-my flex flex-col align-center">
    <h1>Who's winning?</h1>
    <main class="flex flex-wrap align-center">
    <#list sortedCandidates as sortedCan>
        <div class="card">
          <div class="flex flex-col align-center" href="#">
            <img src="images/${sortedCan.photo}">
            <p>${sortedCan.name}</p>
            <p>Votes: ${sortedCan.percentage}%</p>
          </div>
        </div>
    </#list>

    <a class="back flex align-center" href="/">back to main</a>
    </main>
    </div>
</@main.layout>