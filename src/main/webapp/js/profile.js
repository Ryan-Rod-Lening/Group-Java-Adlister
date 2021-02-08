$(document).ready(function() {
$('.pre-edit-form button').click(function(e) {
    e.preventDefault();
    $('.pre-edit-form').hide();
    $('.validation-fail-div').remove();
    $('.pre-edit-form').parent().append(
        `<form ACTION="/profile" METHOD="POST" class="edit-form mt-2" style="border-style: groove; padding: 20px 20px 10px 20px">
            <h4 class="mb-3 text-center">Edit Profile</h4>
             <div className="mb-3">
                <label htmlFor="inputUsername" className="form-label"><b>Username</b></label>
                <input style="float:right" name="inputUsername"type="text" className="form-control" id="inputUsername" value="${$('label#username-value')[0].innerHTML}">
            </div>
            <div className="mb-3">
                <label htmlFor="inputEmail" className="form-label"><b>Email address</b></label>
                <input name="inputEmail" type="text" className="form-control" id="inputEmail" aria-describedby="emailHelp" value="${$('label#email-value')[0].innerHTML}">
            </div>
            <div class="my-3" style="text-align: center">
            <button id="submit-edit-profile" type="submit" class="btn-primary blue" className="btn btn-primary blue">Save Edit</button>
            <button type="submit" class="cancel-edit btn-danger red" className="btn btn-danger red">Cancel Edit</button>
            </div>
        </form>`
    );
});
    var editAdForm;

    $('button#edit-ad-btn').click(function(e) {
        debugger
        e.preventDefault();
        // var thisAd = $($(this).parent().parent().children()[0].children[0]);
        editAdForm = $(this).parent().parent();
        $($(this).parent().parent().hide());
        $('.validation-fail-div').remove();
        $($(this).parent().parent()).parent().append(
            `<form id ="editAdForm" ACTION="/profile" METHOD="POST" class="edit-form mt-2" style="border-style: groove; padding: 20px 20px 10px 20px">
            <h4 class="mb-3 text-center">Edit Ad</h4>
             <div className="mb-3">
                <label htmlFor="adTitle" className="form-label"><b>Title</b></label>
                <input style="float:right" name="adTitle"type="text" className="form-control" id="adTitle" value="${$(this).parent().parent().children().children().children()[0].innerHTML}">
            </div>
            <div className="mb-3">
                <label for="adDescription" htmlFor="adDescription" className="form-label"><b>Description</b></label>
                <textarea style="float:right" name="adDescription" className="form-control" id="adDescription">${$(this).parent().parent().children().children()[1].innerHTML.trim()}</textarea>
            </div>
            <div class="my-3" style="text-align: center">
            <button id="submit-edit-ad" type="submit" class="btn-primary blue" className="btn btn-primary blue">Save Edit</button>
            <button id="submit-cancel-ad" type="submit" class="cancel-edit btn-danger red" className="btn btn-danger red">Cancel Edit</button>
            </div>
        </form>`
        );
    });

$('body').on('click', '.cancel-edit', function(e) {
    e.preventDefault();
    $('form').remove('.edit-form');
    $('.pre-edit-form').show();

});

$('body').on('click', '#submit-cancel-ad', function(e) {
    e.preventDefault();
    $('form').remove('#editAdForm');
    $(editAdForm).show();
})

    // $('body').on('click', '#submit-edit-profile', function(e) {
    //     validName();
    // });

    $('form').on('submit', '#submit-edit-profile', function (event) {
        validName();
        validEmail($('#inputEmail').val());
    });

    const email_regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;

    const validName = (e) => {
        //if name input text field is blank
        //jquery $.trim() used to remove whitespace to in case of incorrect validation error
        if ($.trim($('#inputUsername').val()) === '') {
            //prevent form submission and add error classes/msg
            e.preventDefault();
            $('.name-error').remove();
            $('#inputUsername').addClass('error');
            $('#inputUsername').before('<p class=name-error>Please enter a name.</p>');
            $('p').addClass('error-text');
            $('html,body').scrollTop(0);
            //otherwise remove error classes allow form submission
        } else {
            $('p').remove('.name-error');
            $('#name').removeClass('error');
        }
    };

    const validEmail = (inputText) => {
        //if email input text field does not match regular expression string
        if (!inputText.match(email_regex)) {
            //prevent form submission and add error classes/msg
            event.preventDefault();
            $('.email-error').remove();
            $('#inputEmail').addClass('error');
            $('#inputEmail').before('<p class=email-error>Please enter a valid email address.</p>');
            $('p.email-error').addClass('error-text');
        } else {
            //otherwise remove error classes and allow form submission
            $('p').remove('.email-error');
            $('#inputEmail').removeClass('error');
        }
    };

    //keyup event handler to run each time a key is pressed and released
    $('body').first().on('keyup', '#inputEmail' ,function() {
        var email = this.value;
        validateEmail(email);
    });

    function validateEmail(inputText) {
        //email regular expression string to match email input text field against
        var email_regex = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        //if current string does not match email_regex string template
        if (!email_regex.test(inputText)) {
            //display error classes/msg
            $('.email-error, .email-valid').remove();
            $('#inputEmail').addClass('error');
            $('#inputEmail').before('<p class=email-error>Please enter a valid email address (eg: "John.Doe@hotmail.com")</p>');
            //if input field is currently empty, remove error classes
        } else if ($('#inputEmail').val()=='') {
            $('.email-valid, .email-error').remove();
            $('#inputEmail').removeClass('error');
            //if user email string matches regular expression display validation pass message
        } else {
            $('p').remove('.email-error');
            $('#inputEmail').removeClass('error');
            $('.email-valid').remove();
        }
    }

    //OPEN DELETE MODAL HANDLER
    $('body').on('click', '#delete-ad-btn', function (e){
        //check to see if Modal exists before appending to prevent duplication
        if (!$('#myModal').length) {
            $(this).append(`<!-- The Modal -->
            <form id="confirm-delete-form" ACTION="/profile" METHOD="POST">
            <input type="hidden" value="${$(this).parent().children().attr('href').substring($(this).parent().children().attr('href').indexOf('=') +1)}" name="ad_id" />
                <div id="myModal" class="modal">
                    <!-- Modal content -->
                    <div class="modal-content">
                        <div class="modal-header">
                            <span class="close">&times;</span>
                            <h2>Delete Ad</h2>
                        </div>
                        <div class="modal-body">
                            <p style="color:black !important">Are you sure you want to delete this ad?</p>
                            <input id="delete-movie-submit" type="submit" class="btn btn-primary" name="confirmDelete" value="confirm">Confirm</input>
                            <button id="delete-movie-cancel" class="btn btn-danger">Cancel</button>
                        </div>   
                    </div>
                </div></form>`)
        }
        $('#myModal').show();
    })

    //CLOSE DELETE MODAL HANDLER
    $(window).on('click', function (e){
        if(e.target === $('#myModal')[0] || e.target === $('#delete-movie-cancel')[0] || e.target === $('.close')[0]){
            $('#myModal').hide();
        }
    })

    $('body').on('click', '#delete-movie-cancel', function(e) {
        e.preventDefault();
    });

});