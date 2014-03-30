package fm.ask.steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import fm.ask.page.GmailAccountPage
import fm.ask.page.GmailServiceLogin
import geb.Browser

import static fm.ask.properties.AccountsProperties.*

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)
this.metaClass.mixin(Browser)

Given(~'Mailbox has no messages') { ->
	to GmailServiceLogin
	at GmailServiceLogin
    loginIntoGmail(mailboxUsername, mailboxPassword)
    at GmailAccountPage
    noNewEmails() ?: deleteAllEmails()
}

Then(~'I should receive an email with password recovery link') { ->
    to GmailAccountPage
    at GmailAccountPage
    expectChangePasswordEmail()
}

When(~'I open the email and follow the link') { ->
    openChangePasswordEmail()
    followViaChangePasswordLink()
}