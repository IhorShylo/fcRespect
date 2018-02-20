$(function () {
    $("#contactForm-submit").click(submitContactForm);
    $("#file").on("change", uploadForm);
});


function uploadForm() {
    $.ajax({
        type: "POST",
        url: "/upload",
        data: new FormData($("#uploadForm")[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function (data) {
            console.log("Success");
            let fileName = data;
            console.log("fileName - " + fileName);
            let fullPath = 'http://localhost/files/tmp/' + fileName;
            console.log("fullPath - " + fullPath);
            $("#news-image").attr("src", fullPath);
        },
        error: function (data) {
            console.log("Error");
        }
    });
}

function submitContactForm() {
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
            contactFormSuccess();
            $('#myModal').modal('show');
            contactFormClearInputs();
        },
        error: function (data) {
            contactFormError(data);
        }
    });
}

function contactFormSuccess() {
    $("#nameError").addClass("hidden");
    $("#phoneError").addClass("hidden");
    $("#emailError").addClass("hidden");
    $("#messagelError").addClass("hidden");
}

function contactFormError(data) {
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


function contactFormClearInputs() {
    $("#name").val('');
    $("#phone").val('');
    $("#email").val('');
    $("#message").val('');
}