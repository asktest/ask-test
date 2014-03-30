package fm.ask.steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import fm.ask.page.*
import fm.ask.utils.NewPassword
import geb.Browser

import static fm.ask.properties.AccountsProperties.*

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)
this.metaClass.mixin(Browser)

Given(~'I am on Ask.fm homepage') { ->
    to HomePage
    at HomePage
}

When(~'I visit password recovery page') { ->
    openLoginBox()
    clickOnForgotPasswordLink()
}

When(~'I apply for password recovery') { ->
    at PasswordRecoveryPage
    typeEmailAndSubmit()
}

Then(~'I should see password recovery confirmation') { ->
    at PasswordRecoverySendPage
    expectSuccessfulMessage()
}

When(~'I enter new password twice') { ->
    at PasswordRecoveryResetPage
    enterNewPasswordTwice(NewPassword.generate())
}

When(~'I press save new password') { ->
    submitNewPassword()
}

Given(~'I should see password change confirmation') { ->
    at PasswordRecoveryUpdatePage
    expectPasswordSuccessfullyChangedMessage()
}

Given(~'I should be able to login with new password') { ->
    to HomePage
    logIn(askFmUsername, NewPassword.lastGenerated())
    at ProfileWallPage
}