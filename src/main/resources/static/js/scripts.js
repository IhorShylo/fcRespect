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
            console.log("ERROR");
            clearInputs();
        }
    });
    console.log("OutOfMethod");
    clearInputs();
}

function formSuccess() {
    $("#msgSubmit").removeClass("hidden");
}

function clearInputs() {
    $("#name").val('');
    $("#email").val('');
    $("#message").val('');
}