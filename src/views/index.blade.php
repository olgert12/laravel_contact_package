<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    
    <h3>My first larvel package</h3>

    <form action="{{ url('contact') }}" method="POST">
        @csrf
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" placeholder="John"><br>
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email" placeholder="Doe@doe.com"><br><br>
        <input type="submit" value="Submit">
    </form> 

</body>
</html>