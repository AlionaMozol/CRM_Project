$(document).ready(function () {
    $.getJSON('GetSupercategoriesServlet', {}, function (response) {
        let supercategory = document.createElement('a');
        supercategory.className = 'list-group-item';
        supercategory.href = '#';
        //let jsonArray = eval("(" + response + ")");

        supercategory.innerHTML = response;//jsonArray[0];
        document.getElementById('supercategories').appendChild(supercategory);
    })
});