$(document).ready(function(){
	var menu = $('#cssmenu');
	var menuList = menu.find('ul:first');
	var listItems = menu.find('li').not('#responsive-tab');
	
	menuList.prepend('<li id="responsive-tab"><a href="#">Menu</a></li>');
	
	menu.on('click', '#responsive-tab', function(){
		listItems.slideToggle('fast');
		listItems.addClass('collapsed');
	});
});