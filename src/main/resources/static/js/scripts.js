$(function () {
    $("#form-submit").click(submitForm);
});

function submitForm() {
    // Initiate Variables With Form Content
    let request = {
        name: $("#name").val(),
        phone: $("#phone").val(),
        email: $("#email").val(),
        message: $("#message").val()
    };

    $.ajax({
        type: "POST",
        url: "/contacts/form-process",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(request),
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
    $("#phoneError").addClass("hidden");
    $("#emailError").addClass("hidden");
    $("#messagelError").addClass("hidden");
}

function formError(data) {
    let respErrors = data.responseJSON.errors;
    let showNameError = false;
    let showPhoneError = false;
    let showEmailError = false;
    let showMessageError = false;

    for (index = 0; index < respErrors.length; index++) {
        if (respErrors[index].field === 'name') {
            document.getElementById("nameError").innerHTML = respErrors[index].message;
            showNameError = true;
        }
        if (respErrors[index].field === 'phone') {
            document.getElementById("phoneError").innerHTML = respErrors[index].message;
            showPhoneError = true;
        }
        if (respErrors[index].field === 'email') {
            document.getElementById("emailError").innerHTML = respErrors[index].message;
            showEmailError = true;
        }
        if (respErrors[index].field === 'message') {
            document.getElementById("messagelError").innerHTML = respErrors[index].message;
            showMessageError = true;
        }
    }

    if (showNameError) {
        $("#nameError").removeClass("hidden");
    } else {
        $("#nameError").addClass("hidden");
    }
    if (showPhoneError) {
        $("#phoneError").removeClass("hidden");
    } else {
        $("#phoneError").addClass("hidden");
    }
    if (showEmailError) {
        $("#emailError").removeClass("hidden");
    } else {
        $("#emailError").addClass("hidden");
    }
    if (showMessageError) {
        $("#messagelError").removeClass("hidden");
    } else {
        $("#messagelError").addClass("hidden");
    }
}


function clearInputs() {
    $("#name").val('');
    $("#phone").val('');
    $("#email").val('');
    $("#message").val('');
}