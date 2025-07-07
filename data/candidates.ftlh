<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Vote for us!</title>
  <link rel="stylesheet" href="css/candidates.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-secondary">
  <div class="container-sm">
    <a class="navbar-brand" href="/">Voter</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/register">Register</a>
        </li>
        <li class="nav-item">
             <a class="nav-link" href="/login">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

  <div class="container-my flex flex-col align-center">
    <h1>Vote for us</h1>
    <main class="flex flex-wrap align-evenly">
    <#list candidates as candidate>
            <div class="card">
            <form action="/thankyou" method="get" class="flex flex-col align-center" href="#">
              <img src="images/${candidate.photo}">
              <p>${candidate.name}</p>
              <input name="candidateId" type="hidden" value="${candidate.id}">
              <button type="submit" class="vote flex align-center">Vote</button>
            </form>
          </div>
    </#list>

    </main>

    <p>-------------------------------------------------------</p>
    <a class="back flex align-center" href="/votes">Show total votes</a>
  </div>
</body>

</html>