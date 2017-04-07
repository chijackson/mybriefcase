/**
 * 
 */
function disableEnterKey(e) {
	var key;
	if (window.event) {
		key = window.event.keyCode; //IE
	} else {
		key = e.which; //firefox
	}
 	return (key != 13);
}

function resetNewWebsiteProfileForm() {
	document.getElementById('frmNewWebsiteProfile:ws-name').value = '';
	document.getElementById('frmNewWebsiteProfile:ws-url').value = '';
	document.getElementById('frmNewWebsiteProfile:ws-userid').value = '';
	document.getElementById('frmNewWebsiteProfile:ws-password').value = '';
	document.getElementById('frmNewWebsiteProfile:ws-notes').value = '';
}

function resetNewWirelessProfileForm() {
	document.getElementById('frmNewWirelessProfile:wl-ipaddress').value = '';
	document.getElementById('frmNewWirelessProfile:wl-device').value = '';
	document.getElementById('frmNewWirelessProfile:wl-gigahertz').value = '';
}

function resetNewDvdProfileForm() {
	document.getElementById('frmNewDvdProfile:title').value = '';
	document.getElementById('frmNewDvdProfile:serial').value = '';
}