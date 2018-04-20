$('#deleteStudentModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget); // Button that triggered the modal
	  var thisBsn = button.data('bsn'); // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this);
	  document.getElementById("Bsn").style.visibility = "hidden";
	  document.getElementById("Bsn").innerHTML = thisBsn;
	})
	
	$('#editStudentModal').on('show.bs.modal', function (eventn) {
	  var buttonn = $(eventn.relatedTarget); // Button that triggered the modal
	  var thisBsnn = buttonn.data('bsnn'); // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modaln = $(this);
	  document.getElementById("bSn").innerHTML = thisBsnn;
	})