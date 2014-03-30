package fm.ask.page

import fm.ask.properties.AccountsProperties
import geb.Page

class ProfileWallPage extends Page {
	
	static at = {
		assert title == 'Ask.fm'
        shareYourLinkBox.displayed
        yourLink.displayed
	}

	static content = {
        shareYourLinkBox(wait: true) { $("#share_your_link_box") }
        yourLink(wait: true) { $('a', text: 'ask.fm/' + AccountsProperties.askFmUsername) }
	}

}