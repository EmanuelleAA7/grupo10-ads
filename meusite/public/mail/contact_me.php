<?php
// Check for empty fields
if(empty($_POST['nameEmpresa'])           ||
   empty($_POST['cnpj'])                  ||
   empty($_POST['email'])                 ||
   empty($_POST['nameRepresentante'])     ||
   empty($_POST['emailRepresentante'])    ||
   empty($_POST['phone'])                 ||
   (empty($_POST['']) 
   !filter_var($_POST['email','emailrepresentante'],FILTER_VALIDATE_EMAIL))
   {
   echo "No arguments Provided!";
   return false;
   }
   
$nameEmpresa = strip_tags(htmlspecialchars($_POST['nameEmpresa']));
$nameRepresentante = strip_tags(htmlspecialchars($_POST['nameRepresentante']));
$cpnj = strip_tags(htmlspecialchars($_POST['cnpj']));
$email_address = strip_tags(htmlspecialchars($_POST['email']));
$emailRepresentante_address = strip_tags(htmlspecialchars($_POST['emailRepresentante']));
$phone = strip_tags(htmlspecialchars($_POST['phone']));

   
// Create the email and send the message
$to = 'amandanunes.contato@gmail.com'; // Add your email address inbetween the '' replacing yourname@yourdomain.com - This is where the form will send a message to.
$email_subject = "Website Contact Form:  $nameEmpresa, $nameRepresentante";
$email_body = "You have received a new message from your website contact form.\n\n"."Here are the details:\n\nName: $nameEmpresa $nameRepresentante\n\nEmail: $email_address $emailRepresentante_address\n\nPhone: $phone";
$headers = "From: contatoCerberus@gmail.com\n"; // This is the email address the generated message will be from. We recommend using something like noreply@yourdomain.com.
$headers .= "Reply-To: $email_address, $emailRepresentante_address";   
mail($to,$email_subject,$email_body,$headers);
echo "MENSAGEM ENVIADA COM SUCESSO"
return true;         
?>