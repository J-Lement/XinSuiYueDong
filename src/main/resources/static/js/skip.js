$(document).ready(function() {
    $('.btn').click(function(){
        var url = $(this).href;
        window.location.href = url;
    });
});