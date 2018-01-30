$(function () {
    // cancels the form submission
    $("#form-submit").click(submitForm);
});

function submitForm() {
    // Initiate Variables With Form Content
    let name = $("#name").val();
    let email = $("#email").val();
    let message = $("#message").val();

    $.ajax({
        type: "POST",
        url: "/contacts/form-process",
        data: "name=" + name + "&email=" + email + "&message=" + message,
        success: function (data) {
            formSuccess();
            $('#myModal').modal('show');
            clearInputs();
        },
        error: function (data) {
            formError(data);
        }
    });
}

function formSuccess() {
    $("#nameError").addClass("hidden");
    $("#emailError").addClass("hidden");
    $("#messagelError").addClass("hidden");
}

function formError(data) {
    let resp = data.responseJSON;
    let showNameError = false;
    let showEmailError = false;
    let showMessageError = false;

    for (index = 0; index < resp.length; index++) {
        if (resp[index].field === 'name') {
            document.getElementById("nameError").innerHTML = resp[index].message;
            showNameError = true;
        }
        if (resp[index].field === 'email') {
            document.getElementById("emailError").innerHTML = resp[index].message;
            showEmailError = true;
        }
        if (resp[index].field === 'message') {
            document.getElementById("messagelError").innerHTML = resp[index].message;
            showMessageError = true;
        }
    }

    if (showNameError) {
        $("#nameError").removeClass("hidden");
    } else {
        $("#nameError").addClass("hidden");
    }
    if (showEmailError) {
        $("#emailError").removeClass("hidden");
    } else {
        $("#emailError").addClass("hidden");
    }
    if (showMessageError){
        $("#messagelError").removeClass("hidden");
    } else {
        $("#messagelError").addClass("hidden");
    }
}


function clearInputs() {
    $("#name").val('');
    $("#email").val('');
    $("#message").val('');
}