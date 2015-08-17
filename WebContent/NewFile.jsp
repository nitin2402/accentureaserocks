<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
        $("p").toggle();
    });
});
</script>


<script><link href="templatemo_style.css" rel="stylesheet" type="text/css" ></script>

<script >
$(function() {
    $('#mytable').on('click', '.toggle', function () {
        //Gets all <tr>'s  of greater depth
        //below element in the table
        var findChildren = function (tr) {
            var depth = tr.data('depth');
            return tr.nextUntil($('tr').filter(function () {
                return $(this).data('depth') <= depth;
            }));
        };

        var el = $(this);
        var tr = el.closest('tr'); //Get <tr> parent of toggle button
        var children = findChildren(tr);

        //Remove already collapsed nodes from children so that we don't
        //make them visible. 
        //(Confused? Remove this code and close Item 2, close Item 1 
        //then open Item 1 again, then you will understand)
        var subnodes = children.filter('.expand');
        subnodes.each(function () {
            var subnode = $(this);
            var subnodeChildren = findChildren(subnode);
            children = children.not(subnodeChildren);
        });

        //Change icon and hide/show children
        if (tr.hasClass('collapse')) {
            tr.removeClass('collapse').addClass('expand');
            children.hide();
        } else {
            tr.removeClass('expand').addClass('collapse');
            children.show();
        }
        return children;
    });
});
</script>
<script type="text/javascript">
$('.expander').simpleexpand();</script>
</head>
<body>


<button id="a">Toggle</button>

<p>This is a paragraph with little content.</p>
<p>This is another small paragraph.</p>

</body>
<button id="b">ggle</button>

<p>This is a paragraph with little content.</p>
<p>This is another small paragraph.</p>

</body>
<button id="c">Tole</button>

<p>This is a paragraph with little content.</p>
<p>This is another small paragraph.</p>

</body>

</body>
</html>