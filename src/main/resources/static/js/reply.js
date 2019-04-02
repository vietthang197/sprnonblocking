var roomCode = localStorage.getItem('roomCode');
var roomName = localStorage.getItem('roomName');

var stompClient = null;

function setConnected(connected) {
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);

  if (connected) {
    $("#conversation").show();
  } else {
    $("#conversation").hide();
  }
  $("#greetings").html("");
}

function connect() {
  var socket = new SockJS('http://localhost:8080/tutorialspoint-websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings/' + roomCode, function (greeting) {
      console.log(greeting);
      var data = JSON.parse(greeting.body);
      showGreeting(data.message, data.type);
    });
  });
}
function disconnect() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}
function sendMessage() {
  stompClient.send("/app/hello/"+ roomCode +"/" + roomName + "/admin" , {}, JSON.stringify({'message': $("#message").val(), 'type':'ADMIN'}));
  $("#message").val("");
}
function showGreeting(message, type) {
  if (type === 'ADMIN') {
    $("#data-chatbox").append(' <div class="container chatbox-container darker">\n'
        + '      <img src="https://www.w3schools.com/w3images/avatar_g2.jpg" alt="Avatar" class="right" style="width:100%;">\n'
        + '      <p>' + message + '</p>\n'
        + '      <span class="time-left">11:01</span>\n'
        + '    </div>');
  } else {
    $('#data-chatbox').append('<div class="container chatbox-container">\n'
        + '      <img src="https://www.w3schools.com/w3images/bandmember.jpg" alt="Avatar" style="width:100%;">\n'
        + '      <p>' + message +'</p>\n'
        + '      <span class="time-right">11:00</span>\n'
        + '    </div>');
  }

}
$(function () {
  $( "form" ).on('submit', function (e) {e.preventDefault();});
  connect();
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendMessage(); });
});

