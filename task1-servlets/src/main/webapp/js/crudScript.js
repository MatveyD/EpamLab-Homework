$(document).ready(function () {
  $('#buttonGet').click(function () {
    $.ajax({
      type: 'GET',
      url: 'crud',
      success: function (data) {
        console.log(data.length);

        $('#result').append("<br> Servlet inner state: " + data[0] + "<br>"
            + "Response: ");
        for (let i = 1; i < data.length; i++) {
          $('#result').append("<li>" + data[i] + "</li>");
        }
        }
    });
  });
  $('#buttonPost').click(function () {
    $.ajax({
      type: 'POST',
      url: 'crud',
      data: $('#postValue').val(),
      success: function (data) {
        console.log($('#postValue').val());
        $('#result').append("<br> Servlet inner state: " + data[0] + "<br> "
            + "Response: ");
          $('#result').append("<li>" + data[1] + "</li>");
      }
    });
  });
  $('#buttonPut').click(function () {
    let putValueId = $('#putId').val();
    let putValueName = $('#putValue').val();
    $.ajax({
      type: 'PUT',
      url: 'crud',
      data: $('#putId').val(),
      data: '{ "id" : "' + putValueId
      + '", "name" : "' + putValueName + '" }',
      success: function (data) {
        $('#result').append("<br> Servlet inner state: " + data[0] + "<br> "
        + "Old value: " + data[1] + "<br>"
            + "New value: " + data[2] + "<br>");

      }
    });
  });
  $('#buttonDelete').click(function () {
    let deleteValue = $('#deleteId').val();
    $.ajax({
      type: 'DELETE',
      url: 'crud',
      data: deleteValue,
      success: function (data) {
        $('#result').append("<br> Servlet inner state: " + data[0] + "<br> "
        + " Object" + deleteValue + " has been removed <br>");
      }
    });
  });
});


