/**
 * 
 */

function myFunction() {
   document.getElementById("employeeDetails").innerHTML = "Testing on click of click me button";
}

$('#employeeModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var recipient = button.data('whatever');
	  var first = button.data('first');
	  // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this);
	  modal.find('.modal-title').text(recipient);
	  document.getElementById("first").innerHTML = first;
	})
