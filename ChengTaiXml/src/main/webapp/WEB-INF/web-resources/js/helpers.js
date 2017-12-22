/*
    @param: array of autocomplete list
    @param: id of input tag
     */
function myAutoComplete(list, tag) {
    $(tag).autocomplete({
        source: list
    });
}

function refresh() {
    location.reload(true);
}

function showDeleteWarning() {
    if(!(confirm('Are you sure you want to delete this'))) return false;
}