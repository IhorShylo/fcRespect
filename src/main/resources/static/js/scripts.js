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
    let resp = data.responseJSON;
    let showNameError = false;
    let showPhoneError = false;
    let showEmailError = false;
    let showMessageError = false;

    for (index = 0; index < resp.length; index++) {
        if (resp[index].field === 'name') {
            document.getElementById("nameError").innerHTML = resp[index].message;
            showNameError = true;
        }
        if (resp[index].field === 'phone') {
            document.getElementById("phoneError").innerHTML = resp[index].message;
            showPhoneError = true;
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