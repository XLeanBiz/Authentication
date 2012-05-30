package co.uniqueid.authentication.client.companies.change;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

public class CloseButton extends HTML {

	public CloseButton(final PopupPanel popup) {

		this.setHTML("<a href=#><img src='images/close.gif' border=0></a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				popup.hide();
			}
		});
	}
}
