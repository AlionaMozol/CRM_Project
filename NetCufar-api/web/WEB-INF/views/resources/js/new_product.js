/**
 * Register a listener on the form to detect changing the map's key
 */
$('form').on('change', 'input.pointMap', function(){
    var content = $(this).val();
    var id = $(this).attr('id');
    // have to travel the DOM for added elements to be accessed.
    // JQuery does not have visibility to the IDs of added elements
    $(this).parent().next().children('input').attr('name', 'pointsValueMap['+content+']');
    // if you are not dynamically adding key/values then
    // all fields are accessible by JQuery and you can update by:
    $('#'+id+'-value').attr('name', 'pointsValueMap['+content+']');
});