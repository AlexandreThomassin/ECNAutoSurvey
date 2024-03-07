<%-- 
    Document   : testmail
    Created on : 6 mars 2024, 23:08:16
    Author     : arthu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire d'envoi d'email</title>
</head>
<body>
    <h2>Formulaire d'envoi d'email</h2>
    <form action="sendMail.do" method="POST">
        <label for="destinataire">Adresse e-mail du destinataire:</label><br>
        <input type="email" id="destinataire" name="destinataire" required><br><br>

        <label for="username">Adresse e-mail :</label><br>
        <input type="email" id="username" name="username"><br>
        <label for="password">Mot de passe :</label><br>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Envoyer">
    </form>

</body>
</html>
