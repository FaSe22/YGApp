package com.example.project.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CardControllerTest {

	private CardController cardController;

	@Before
	public void setup() {
		this.cardController = new CardController();
	}

	@Test
	public void shouldGetAllCards() {
		ResponseEntity<List<Card>> actualValue = cardController.getAllCards();

		// TODO: assert scenario
	}

	@Test
	public void shouldGetAllCards() {
		// TODO: initialize args
		Long id;

		ResponseEntity<Optional<Card>> actualValue = cardController.getAllCards(id);

		// TODO: assert scenario
	}

	@Test
	public void shouldHome() {
		String actualValue = cardController.home();

		// TODO: assert scenario
	}

	@Test
	public void shouldCreateCard() {
		// TODO: initialize args
		Card card;

		Card actualValue = cardController.createCard(card);

		// TODO: assert scenario
	}

	@Test
	public void shouldDeleteCard() {
		// TODO: initialize args
		Long id;

		Boolean actualValue = cardController.deleteCard(id);

		// TODO: assert scenario
	}
}
