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

$('body').on('click', '.cancel-edit', function(e) {
    e.preventDefault();
    $('form').remove('.edit-form');
    $('.pre-edit-form').show();

});

$('body').on('click', '.submit-edit-profile', function(e) {
   e.preventDefault();
});

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
    // $(window).on('click', '#confirm-delete-form', function(e) {
    //     $(this).unbind('submit').submit();
    // })
});