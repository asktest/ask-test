package fm.ask.page

import geb.Page

class GmailServiceLogin extends Page {

    static url = 'https://accounts.google.com/ServiceLogin?&service=mail&continue=https://mail.google.com/mail/'

	static at = {
        waitFor { title == 'Gmail' }
	}

	static content = {
		emailInput(wait: true) { $(id: 'Email') }
		passwordInput(wait: true) { $(id: 'Passwd') }
		signInButton(wait: true) { $(id: 'signIn') }
	}

	void loginIntoGmail(String login, String password) {
        emailInput.displayed
        emailInput.value(login)
        passwordInput.value(password)
        signInButton.click()
	}

}