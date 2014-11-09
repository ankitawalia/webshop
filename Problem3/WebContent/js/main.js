// The root URL for the RESTful services
var rootURL = "api";
var attributeApiUrl = rootURL+ "/attributes/group"

var currentWine;

// Nothing to delete in initial application state
$('#btnDelete').hide();

// Register listeners
$('#btnSearch').click(function() {
	search($('#searchKey').val());
	return false;
});

// Trigger search when pressing 'Return' on search key input field
$('#searchKey').keypress(function(e){
	if(e.which == 13) {
		search($('#searchKey').val());
		e.preventDefault();
		return false;
    }
});

$('#btnAdd').click(function() {
	newWine();
	return false;
});

$('#btnSave').click(function() {
	if ($('#wineId').val() == '')
		addWine();
	else
		updateWine();
	return false;
});

$('#btnDelete').click(function() {
	deleteWine();
	return false;
});

//$('#wineList a').live('click', function() {
	//findById($(this).data('identity'));
//});

// Replace broken images with generic wine bottle
$("img").error(function(){
  $(this).attr("src", "pics/generic.jpg");

});

function search(searchKey) {
	if (searchKey == '') 
		findAll();
	else
		findByName(searchKey);
}

function newWine() {
	$('#btnDelete').hide();
	currentWine = {};
	renderDetails(currentWine); // Display empty form
}

function findAllAttributeGroups() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL+"/attributes/group",
		dataType: "json", // data type of response
		success: renderAttributeGroups
	});
}

function findAttriburesForAttributeGroup(attributeGroupId) {
	$.ajax({
		type: 'GET',
		url: attributeApiUrl+ "/"+ attributeGroupId,
		dataType: "json",
		success: renderAttributeList
	});
}

function findById(id) {
	console.log('findById: ' + id);
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + id,
		dataType: "json",
		success: function(data){
			$('#btnDelete').show();
			console.log('findById success: ' + data.name);
			currentWine = data;
			renderDetails(currentWine);
		}
	});
}

function addWine() {
	console.log('addWine');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Wine created successfully');
			$('#btnDelete').show();
			$('#wineId').val(data.id);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addWine error: ' + textStatus);
		}
	});
}

function updateWine() {
	console.log('updateWine');
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: rootURL + '/' + $('#wineId').val(),
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Wine updated successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('updateWine error: ' + textStatus);
		}
	});
}

function deleteWine() {
	console.log('deleteWine');
	$.ajax({
		type: 'DELETE',
		url: rootURL + '/' + $('#wineId').val(),
		success: function(data, textStatus, jqXHR){
			alert('Wine deleted successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteWine error');
		}
	});
}


function renderAttributeGroups(data) {
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#selectmenu option').remove();
	$.each(list, function(index, attributeGroup) {
		$('#selectmenu').append('<option value=' + attributeGroup.attributeId+ '>'+attributeGroup.attributeName+'</option>');
	});
	$( "#selectmenu" ).on( "selectmenuselect", function( event, ui ) {
		var value = ui.item.value;
		findAttriburesForAttributeGroup(value)
	} );
}

function renderAttributeList(data) {
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	$('#sortable h3').remove();
	$('#sortable li').remove();
	$('#sortable').append('<h3> Attribute Name</h3>');
	$.each(list, function(index, attributeGroup) {
		$('#sortable').append('<li> ' + attributeGroup.childId.attributeName + "</li></br>");
	});
}


function renderDetails(wine) {
	$('#wineId').val(wine.id);
	$('#name').val(wine.name);
	$('#grapes').val(wine.grapes);
	$('#country').val(wine.country);
	$('#region').val(wine.region);
	$('#year').val(wine.year);
	$('#pic').attr('src', 'pics/' + wine.picture);
	$('#description').val(wine.description);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var wineId = $('#wineId').val();
	return JSON.stringify({
		"id": wineId == "" ? null : wineId, 
		"name": $('#name').val(), 
		"grapes": $('#grapes').val(),
		"country": $('#country').val(),
		"region": $('#region').val(),
		"year": $('#year').val(),
		"picture": currentWine.picture,
		"description": $('#description').val()
		});
}
