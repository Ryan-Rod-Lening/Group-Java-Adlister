$(document).ready(function() {
$('.pre-edit-form button').click(function(e) {
    e.preventDefault();
    $('.pre-edit-form').hide();
    $('.validation-fail-div').remove();
    $('.pre-edit-form').parent().append(
        `<form ACTION="/profile" METHOD="POST" class="edit-form mt-2" style="border-style: groove; padding: 5px">
            <h4 class="mb-3">Edit Profile</h4>
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
})