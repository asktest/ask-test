package fm.ask.page

import geb.Page

class PasswordRecoveryPage extends Page {

	static at = {
        header.displayed
	}

	static content = {
        header(wait: true) { $('a', text:'password recovery') }
		recoveryEmailInput(wait: true) { $("#reset_request_email") }
		submitButton(wait: true) { $("#reset_request_submit") }
	}

    void typeEmailAndSubmit() {
        recoveryEmailInput.value('ask.sergejsn@gmail.com')
        submitButton.click()
    }

}