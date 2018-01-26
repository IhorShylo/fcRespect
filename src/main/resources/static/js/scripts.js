$("#contactForm").submit(function(event){
    // cancels the form submission
    console.log("HELLO FROM JS");
    event.preventDefault();
    submitForm();
});

function submitForm(){
    // Initiate Variables With Form Content
    console.log("HELLO FROM JS SUBMIT FORM METHOD");
    var name = $("#name").val();
    var email = $("#email").val();
    var message = $("#message").val();

    $.ajax({
        type: "POST",
        url: "/form-process",
        data: "name=" + name + "&email=" + email + "&message=" + message,
        success : function(text){
            if (text == "success"){
                formSuccess();
            }
        }
    });
}
function formSuccess(){
    $( "#msgSubmit" ).removeClass( "hidden" );
}