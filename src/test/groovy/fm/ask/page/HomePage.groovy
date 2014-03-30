package fm.ask.page

import geb.Page

class HomePage extends Page {
	
	static url = 'http://ask.fm'

	static at = {
        logo.displayed
        signUpSlogan.displayed
		assert title == 'Ask.fm'
        assert signUpSlogan.text() == 'Ask and answer'

	}

	static content = {
		logo(wait: true) { $("#logo") }
		loginButton(wait: true) { $("[data-rlt-aid='tlb_login']") }
		loginInput(wait: true) { $("#logBox #login") }
		passwordInput(wait: true) { $("#logBox #password") }
        logBoxSubmitButton(wait: true) { $("#logBox #logBox_submit-button") }
		signUpSlogan(wait: true) { $("#signupSlogan") }
		signUpButton(wait: true) { $("#signupSlogan [href='/signup']") }
		forgotPasswordLink(wait: true) { $("#logBox [href='/remind/request']") }

	}

    void logIn(String username, String password) {
        loginButton.click()
        loginInput.value(username)
        passwordInput.value(password)
        logBoxSubmitButton.click()
    }

	void openLoginBox() {
		loginButton.click()
	}

    void clickOnForgotPasswordLink() {
        forgotPasswordLink.click()
	}

}