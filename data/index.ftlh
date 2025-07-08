<#import "layout.ftlh" as main>
<@main.layout>

    <div class="container-my flex flex-col align-center">
        <h1>Vote for us</h1>
        <main class="flex flex-wrap align-evenly">
            <#if candidates??>
                <#list candidates as candidate>
                    <div class="card">
                        <form action="/thankyou" method="get" class="flex flex-col align-center">
                            <img src="images/${candidate.photo}">
                            <p>${candidate.name}</p>
                            <input name="candidateId" type="hidden" value="${candidate.id}">
                            <button type="submit" class="vote flex align-center">Vote</button>
                        </form>
                    </div>
                </#list>
            </#if>
        </main>

        <p>-------------------------------------------------------</p>
        <a class="back flex align-center" href="/votes">Show total votes</a>
    </div>

</@main.layout>

