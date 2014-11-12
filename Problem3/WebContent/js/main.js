// The root URL for the RESTful services
var rootURL = "api";
var attributeApiUrl = rootURL+ "/attributes/group";
var productApiUrl = rootURL+ "/product/getallproducts";
var organisationApiUrl = rootURL+ "/organisation";
var customerApiUrl = rootURL+ "/cart/details";

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

$("img").error(function(){
  $(this).attr("src", "pics/generic.jpg");

});

function search(searchKey) {
	if (searchKey == '') 
		findAll();
	else
		findByName(searchKey);
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


function findChildOrganisations(attributeGroupId) {
	$.ajax({
		type: 'GET',
		url: organisationApiUrl+ "/child/"+ attributeGroupId,
		dataType: "json",
		success: renderChildOrganisations
	});
}

function renderChildOrganisations(data) {
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	$('#sortable h3').remove();
	$('#sortable li').remove();
	$('#sortable br').remove();
	$('#sortable').append('<h3> Attribute Name</h3>');
	$.each(list, function(index, attributeGroup) {
		$('#sortable').append('<li> ' + attributeGroup.childId.attributeName + "</li></br>");
	});
}

function findAllOrganisations() {
	$.ajax({
		type: 'GET',
		url: organisationApiUrl+"/all",
		dataType: "json", // data type of response
		success: renderOrganisations
	});
}

function findAllProducts() {
	console.log('findAllAttributes');
	$.ajax({
		type: 'GET',
		url: rootURL+"/product/getallproducts",
		dataType: "json", // data type of response
		success: renderProductList
	});
}

function findAllAttributesForProduct(productId) {
	$.ajax({
		type: 'GET',
		url: productApiUrl+ "/"+ productId,
		dataType: "json",
		success: renderProductAttributeList
	});
}

function findAllCarts(){
	console.log('findAllCarts');
	$.ajax({
		type: 'GET',
		url: rootURL+"/cart/details",
		dataType: "json", // data type of response
		success: renderCartList
	});
}

function findCustomerForOrg(orgId){
	console.log('findCustomerForOrg');
	$.ajax({
		type: 'GET',
		url: customerApiUrl+ "/"+ orgId,
		dataType: "json", // data type of response
		success: renderCustomerData
	});
}

function findCartById(cartId){
	$("#customer").empty();
	$("#customerAdd").empty();
	$("#cartproducts").empty();
	$("#organization").empty();
	$("#customerTitle").show();
	$("#customerAddress").show();
	$("#organizationTitle").show();
	$("#customer").show();
	$("#customerAdd").show();
	$("#cartproducts").show();
	$("#organization").show();
	console.log('findcartById');
	$.ajax({
		type: 'GET',
		url: rootURL+"/cart/details/" + cartId,
		dataType: "json", // data type of response
		success: renderCartData
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
		findAttriburesForAttributeGroup(value);
	} );
}

function renderOrganisations(data) {
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	var maxRows = list[list.length-1].maxRow;
	var maxColumns = list[list.length-1].maxColumn;
	
	var table = $('<table><tbody>');
	
	for(var i=1; i<=maxRows; i++){
		var row = $('<tr></tr>').addClass('row' + i);
		table.append(row);
		for(var j=1; j<=maxColumns; j++) {
		var column = $('<td></td>').addClass('col' + j);
		row.append(column);
		}
	}
	table.append("</tbody></table>");
	
	$('#orgDiv').append(table);

	/*$('#orgselectmenu option').remove();
	$.each(list, function(index, attributeGroup) {
		$('#orgselectmenu').append('<option value=' + attributeGroup.id+ '>'+attributeGroup.orgName+'</option>');
	});
	$( "#orgselectmenu" ).on( "selectmenuselect", function( event, ui ) {
		var value = ui.item.value;
		findChildOrganisations(value);
	} );*/
	$.each(list, function(index, orgDto) {
		var orgName = orgDto.orgName;
		var row = orgDto.row;
		var column = orgDto.column;
		$(".row"+row + " .col"+column).text(orgName);
	});
}

function renderAttributeList(data) {
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	$('#sortable h3').remove();
	$('#sortable li').remove();
	$('#sortable br').remove();
	$('#sortable').append('<h3> Attribute Name</h3>');
	$.each(list, function(index, attributeGroup) {
		$('#sortable').append('<li> ' + attributeGroup.childId.attributeName + "</li></br>");
	});
}

function renderProductList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#productselectmenu option').remove();
	$.each(list, function(index, productList) {
		$('#productselectmenu').append('<option value =' + productList.productId+ '>'+productList.productName+'</option>');
	});
	$( "#productselectmenu" ).on( "selectmenuselect", function( event, ui ) {
		var value = ui.item.value;
		findAllAttributesForProduct(value);
	} );
	
}

function renderProductAttributeList(data){
	
	var attr = data.attributeDTOs == null ? [] : (data.attributeDTOs instanceof Array ? data.attributeDTOs : [data.attributeDTOs]);
	$('#products h3').remove();
	$('#products ul').remove();
	$('#products div').remove();
	$('#products').append('<h3> Products and its Attribute</h3>');
	$('#products').append('<div>'+data.productName+'</div>');
	$('#products').append('<ul class="productattrGroup">');
	$.each(attr, function(index, attrDto) {
		renderProductAttributesStructureInProducts(index, attrDto, '.productattrGroup');
	});
	$('#products').append('</ul>');
}

function renderProductAttributesStructureInProducts() {
	var attrDto = arguments[1];
	var index = arguments[0];
	var groupClass = arguments[2];
var attrChildAttribs = attrDto.childAttributes == null ? [] : (attrDto.childAttributes instanceof Array ? attrDto.childAttributes : [attrDto.childAttributes]);
var attrValue = attrDto.attributeValue != null ? attrDto.attributeValue : " ";
var li;
if(attrDto.attributeValue) {
	 li =  $('<li>'+attrDto.attributeName+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+attrValue+'</li>');
} else {
	 li =  $('<li class=productchildAttrGroup'+index+'><br/>'+attrDto.attributeName+'</li>');
}
$('#products ul'+groupClass).append(li);
$('#products ul li.productchildAttrGroup'+index).append('<ul>');
for(var i=0;i<attrChildAttribs.length;i++) {
	var j = index+1;
	renderProductAttributesStructureInProducts(j, attrChildAttribs[i], ' li.productchildAttrGroup'+ (index));
}
$('#products ul li.productchildAttrGroup'+index).append('</ul>');
}



function renderCartProductAttributeList(data){
	var attr = data.attributeDTOs == null ? [] : (data.attributeDTOs instanceof Array ? data.attributeDTOs : [data.attributeDTOs]);
	$('#cartproducts h3').remove();
	$('#cartproducts ul').remove();
	$('#cartproducts div').remove();
	$('#cartproducts').append('<h3> Products and its Attribute</h3>');
	$('#cartproducts').append('<div>'+data.productName+'</div>');
	$('#cartproducts').append('<ul class="attrGroup">');
	$.each(attr, function(index, attrDto) {
		renderProductAttributesStructure(index, attrDto, '.attrGroup');
	});
	$('#cartproducts').append('</ul>');
}


function renderProductAttributesStructure() {
	var attrDto = arguments[1];
	var index = arguments[0];
	var groupClass = arguments[2];
var attrChildAttribs = attrDto.childAttributes == null ? [] : (attrDto.childAttributes instanceof Array ? attrDto.childAttributes : [attrDto.childAttributes]);
var attrValue = attrDto.attributeValue != null ? attrDto.attributeValue : " ";
var li;
if(attrDto.attributeValue) {
	 li =  $('<li>'+attrDto.attributeName+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+attrValue+'</li>');
} else {
	 li =  $('<li class=childAttrGroup'+index+'><br/>'+attrDto.attributeName+'</li>');
}
$('#cartproducts ul'+groupClass).append(li);
$('#cartproducts ul li.childAttrGroup'+index).append('<ul>');
for(var i=0;i<attrChildAttribs.length;i++) {
	var j = index+1;
	renderProductAttributesStructure(j, attrChildAttribs[i], ' li.childAttrGroup'+ (index));
	//$('#cartproducts ul li.childAttrGroup'+index+' ul').append('<li >'+attrChildAttribs[i].attributeName+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+attrChildAttribs[i].attributeValue+'</li>');
}
$('#cartproducts ul li.childAttrGroup'+index).append('</ul>');

}
function renderCartList(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#cartselectmenu option').remove();
	$.each(list, function(index, attributeGroup) {
		$('#cartselectmenu').append('<option value='+attributeGroup.cartId+'>'+attributeGroup.cartId+'</option>');
	});
	$( "#cartselectmenu" ).on( "selectmenuselect", function( event, ui ) {
		var value = ui.item.value;
		findCartById(value);
	} );
}

function renderCustomerData(data){
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	$('#sortable h3').remove();
	$('#sortable li').remove();
	$('#sortable br').remove();
	$('#sortable').append('<h3> Customer Details</h3>');
	$.each(list, function(index, attributeGroup) {
		$('#sortable').append('<h3> Customer Name</h3>'+'<li> ' + attributeGroup.customerId.customerName + "</li></br>");
		$('#sortable').append('<h3> Customer Address</h3>'+'<li> ' + attributeGroup.customerId.customerAddress + "</li></br>");
	});
}

function renderCartData(data){
	$('#sortable h3').remove();
	$('#sortable li').remove();
	$('#sortable br').remove();
	$('#customer').append(data.customer.customerName);
	$('#customerAdd').append(data.customer.customerAddress);
	$('#organization').append(data.org.orgName);
	renderCartProductAttributeList(data.productDetailsDTO);
}
