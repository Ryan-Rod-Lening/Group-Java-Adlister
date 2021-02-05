$('.pre-edit-form button').click(function(e) {
    e.preventDefault();
    $('.pre-edit-form').hide();
    $('.pre-edit-form').parent().append(
        `<form class="edit-form">
            <h4>Edit Profile</h4>
            <div className="mb-3">
                <label htmlFor="exampleInputEmail1" className="form-label">Email address</label>
                <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
            </div>
            <div className="mb-3">
                <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
                <input type="password" className="form-control" id="exampleInputPassword1">
            </div>
            <div className="mb-3 form-check">
                <input type="checkbox" className="form-check-input" id="exampleCheck1">
                    <label className="form-check-label" htmlFor="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" className="btn btn-primary">Save Edit</button>
            <button type="submit" class="cancel-edit" className="btn btn-danger">Cancel Edit</button>
        </form>`
    );
});

$('body').on('click', '.cancel-edit', function(e) {
    e.preventDefault();
    $('form').remove('.edit-form');
    $('.pre-edit-form').show();

});