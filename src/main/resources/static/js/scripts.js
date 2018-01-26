$(function() {
    // cancels the form submission
    $("#form-submit").click(submitForm);
});

function submitForm(){
    // Initiate Variables With Form Content
    var name = $("#name").val();
    var email = $("#email").val();
    var message = $("#message").val();

    $.ajax({
        type: "POST",
        url: "/contacts/form-process",
        data: "name=" + name + "&email=" + email + "&message=" + message,
        success : function(status){
                formSuccess();
        }
    });
}
function formSuccess(){
    $( "#msgSubmit" ).removeClass( "hidden" );
}