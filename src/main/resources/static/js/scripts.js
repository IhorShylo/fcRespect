$(function () {
    // cancels the form submission
    $("#form-submit").click(submitForm);
});

function submitForm() {
    // Initiate Variables With Form Content
    var name = $("#name").val();
    var email = $("#email").val();
    var message = $("#message").val();

    $.ajax({
        type: "POST",
        url: "/contacts/form-process",
        data: "name=" + name + "&email=" + email + "&message=" + message,
        success: function (data) {
            formSuccess();
        },
        error: function (data) {
            formError();
        }
    });
    clearInputs();
}

function formSuccess() {
    $("#msgSubmit").removeClass("hidden");
    $("#nameError").addClass("hidden");
    $("#emailError").addClass("hidden");
    $("#messagelError").addClass("hidden");
}

function formError() {
    $("#nameError").removeClass("hidden");
    $("#emailError").removeClass("hidden");
    $("#messagelError").removeClass("hidden");
}


function clearInputs() {
    $("#name").val('');
    $("#email").val('');
    $("#message").val('');
}