/*$.getJSON('leftmenu', {},
        function (response) {
            let supercategory = document.createElement('a');
            supercategory.className = 'list-group-item';
            supercategory.href = '#';
            let jsonArray = response;

            supercategory.innerHTML = response;
            document.getElementById('supercategories').appendChild(supercategory);
        })*/

let ajaxRequest = function () {
    /*$.getJSON('GetSupercategoriesServlet', {}, function (response) {
        for (let i = 0; i < 3; i++) {
            let supercategory = document.createElement('a');
            supercategory.className = 'list-group-item';
            supercategory.href = '#';

            //let jsonArray = eval("(" + response + ")");
            // let fashion = jsonArray[0];
            //supercategory.innerHTML = "notfashion";
            supercategory.innerHTML = response;
            document.getElementById('supercategories').appendChild(supercategory);
        }
    })*/
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "leftmenu",
        dataType: "json",
        success: function (response) {
            //let json = eval("(" + ${jsonArray} +")");
            let supercategory = document.createElement('a');
            supercategory.className = 'list-group-item';
            supercategory.href = '#';
            supercategory.innerHTML = response; //json[0];
            document.getElementById('supercategories').appendChild(supercategory);
        }
    })
}