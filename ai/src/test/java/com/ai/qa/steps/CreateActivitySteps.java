package com.ai.qa.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateActivitySteps {
	

	@Given("^User logged in to system and clicks on add activity$")
	public void user_logged_in_to_system_and_clicks_on_add_activity() throws Throwable {
		System.out.println("Given");
	    }

	@When("^User enter activity details$")
	public void user_enter_activity_details() throws Throwable {
		System.out.println("Then");
	}

	@When("^User click on publish button$")
	public void user_click_on_publish_button() throws Throwable {
		System.out.println("When");
	}

	@Then("^Activity added and displayed in myactivities list$")
	public void activity_added_and_displayed_in_myactivities_list() throws Throwable {
		System.out.println("Then");
		}
}
