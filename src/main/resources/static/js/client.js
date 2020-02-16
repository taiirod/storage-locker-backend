/**
 * Created by stephan on 20.03.16.
 */

$(function () {
   // VARIABLES =============================================================
   var TOKEN_KEY = "jwtToken"
   var $notLoggedIn = $("#notLoggedIn");
   var $loggedIn = $("#loggedIn").hide();
   var $response = $("#response");
   var $login = $("#login");
   var $userInfo = $("#userInfo").hide();

   // FUNCTIONS =============================================================

   $("#teste").click(showUserInformation);

   function showUserInformation() {
      $.ajax({
         url: "http://localhost:8080/pessoa/todas",
         type: "GET",
         contentType: "application/json; charset=utf-8",
         dataType: "json",
         success: function (data) {
            console.log(data);
            /*var $userInfoBody = $userInfo.find("#userInfoBody");

            $userInfoBody.append($("<div>").text("Username: " + data.username));
            $userInfoBody.append($("<div>").text("Firstname: " + data.firstname));
            $userInfoBody.append($("<div>").text("Lastname: " + data.lastname));
            $userInfoBody.append($("<div>").text("Email: " + data.email));

            var $authorityList = $("<ul>");
            data.authorities.forEach(function (authorityItem) {
               $authorityList.append($("<li>").text(authorityItem.name));
            });
            var $authorities = $("<div>").text("Authorities:");
            $authorities.append($authorityList);

            $userInfoBody.append($authorities);
            $userInfo.show();*/
         }
      });
   }
});
