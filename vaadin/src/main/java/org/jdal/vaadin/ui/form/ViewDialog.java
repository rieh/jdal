/*
 * Copyright 2008-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdal.vaadin.ui.form;

import javax.annotation.PostConstruct;

import org.jdal.vaadin.ui.Box;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.VaadinView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

/**
 * Window used to show Views.
 * 
 * @author Jose Luis Martin 
 */
public class ViewDialog<T> extends Window {
	
	public static final int OK = 0;
	public static final int CANCEL= 1;
	
	private static final long serialVersionUID = 1L;
	private VaadinView<T> view;
	private ViewAction acceptAction = new ViewSaveAction();
	private ViewAction cancelAction = new CancelAction(); 
	private Button acceptButton;
	private Button cancelButton;
	private int windowWidth = 750;
	private int windowHeight = 750;
	private int value = CANCEL;
	
	public ViewDialog() {

	}

	public ViewDialog(VaadinView<T> view) {
		setView(view);
	}

	@PostConstruct
	public void init() {
		acceptAction.setView(view);
		cancelAction.setView(view);
		
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.row();
		fb.setElastic();
		
		if (view != null)
			fb.add(view.getPanel());
		fb.row();
		fb.add(createButtonBox());
		
		this.setContent(fb.getForm());
	}

	/**
	 * Create box with accept/cancel buttons
	 * @return new button box
	 */
	protected Component createButtonBox() {
		acceptButton = FormUtils.newButton(acceptAction);
		cancelButton = FormUtils.newButton(cancelAction);
		HorizontalLayout hl = new HorizontalLayout();
		Box.addHorizontalGlue(hl);
		hl.addComponent(acceptButton);
		hl.addComponent(Box.createHorizontalStrut(5));
		hl.addComponent(cancelButton);
	    Box.addHorizontalGlue(hl);
		
		return hl;
	}

	public VaadinView<T> getView() {
		return view;
	}

	public void setView(VaadinView<T> view) {
		this.view = view;
	}

	public ViewAction getAcceptAction() {
		return acceptAction;
	}

	public void setAcceptAction(ViewAction acceptAction) {
		this.acceptAction = acceptAction;
		this.acceptAction.setView(view);
	}

	public ViewAction getCancelAction() {
		return cancelAction;
	}

	public void setCancelAction(ViewAction cancelAction) {
		this.cancelAction = cancelAction;
		cancelAction.setView(view);
	}
	
	public boolean isAccepted() {
		return value == OK;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the windwoWidth
	 */
	public int getWindwoWidth() {
		return windowWidth;
	}

	/**
	 * @param windwoWidth the windwoWidth to set
	 */
	public void setWindwoWidth(int windwoWidth) {
		this.windowWidth = windwoWidth;
	}

	/**
	 * @return the windowHeight
	 */
	public int getWindowHeight() {
		return windowHeight;
	}

	/**
	 * @param windowHeight the windowHeight to set
	 */
	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	/**
	 * @return the windowWidth
	 */
	public int getWindowWidth() {
		return windowWidth;
	}

	/**
	 * @param windowWidth the windowWidth to set
	 */
	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

}
