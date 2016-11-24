/**
 * Utility functions.
 */

/**
 * Gets URL.
 * @returns {String} The URL.
 */
function currentURL() {
    return location.protocol+'//'+location.hostname+(location.port ? ':'+location.port: '')+'/administrator';
}

$(function() {
    /*$('#loginForm').submit(function(event) {
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: currentURL() + '/app/login/signin',
            data: $('#loginForm').serialize(),
            error: function(){
                alert("failure");
            }
        });
    });*/
});