/*
 * Copyright 2008-2011 the original author or authors.
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
package info.joseluismartin.gui;

import info.joseluismartin.gui.action.ViewAction;
import info.joseluismartin.gui.bind.ControlChangeListener;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import org.springframework.validation.BindingResult;

/**
 * A JFrame for use as View Container
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class ViewFrame extends JFrame implements View<Object>, Editor {


	private static final long serialVersionUID = 1L;
	private View<Object> view;
	private ViewAction acceptAction;
	private ViewAction cancelAction;
	private JButton acceptButton;
	private JButton cancelButton;
	private int windowWidth;
	private int windowHeight;
	private EventListenerList listenerList = new EventListenerList();

	/**
	 * Default Ctor
	 */
	public ViewFrame() {
		super();
	}
	
	/**
	 * Compatibility ctor with ViewDialog.
	 * @param owner
	 */
	public ViewFrame(Frame owner) {
		super();
	}

	public void init() {
		add(view.getPanel(), BorderLayout.CENTER);
		add(createButtonBox(), BorderLayout.SOUTH);
		setTitle(view.getModel().toString());
		setLocationRelativeTo(null);
		setSize(new Dimension(windowWidth, windowHeight));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CloseListener());
	//	pack();
	}

	protected Component createButtonBox() {
		acceptButton = new JButton(acceptAction);
		cancelButton = new JButton(cancelAction);
		JPanel p = new JPanel();
		p.add(acceptButton);
		p.add(cancelButton);
		
		return p;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void save() {
		Object[] listeners = listenerList.getListenerList();
		EditorEvent e = null;

		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == EditorListener.class) {
				if (e == null) {
					e = new EditorEvent(this, getModel());
				}
				((EditorListener)listeners[i+1]).modelChanged(e);
			}	       
		}
		
	}

	public View<Object> getView() {
		return view;
	}

	public void setView(View<Object> view) {
		this.view = view;
	}

	public ViewAction getAcceptAction() {
		return acceptAction;
	}

	public void setAcceptAction(ViewAction acceptAction) {
		this.acceptAction = acceptAction;
		this.acceptAction.setView(view);
		this.acceptAction.setDialog(this);
	}

	public ViewAction getCancelAction() {
		return cancelAction;
	}

	public void setCancelAction(ViewAction cancelAction) {
		this.cancelAction = cancelAction;
		cancelAction.setDialog(this);
		cancelAction.setView(view);
	}

	public Object getModel() {
		return view.getModel();
	}

	public JComponent getPanel() {
		return view.getPanel();
	}

	public void refresh() {
		view.refresh();
		setTitle(view.getModel().toString());
	}

	public void setModel(Object model) {
		view.setModel(model);
	}

	public void update() {
		view.update();
	}

	
	public void clear() {
		view.clear();
	}

	public boolean validateView() {
		return view.validateView();
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
	 * {@inheritDoc}
	 */
	public void addEditorListener(EditorListener l) {
		listenerList.add(EditorListener.class, l);
		
	}
	 
	public void removeEditorListener(EditorListener l) {
		listenerList.remove(EditorListener.class, l);
	}


	/**
	 * {@inheritDoc}
	 */
	public void cancel() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void setClean() {

	}

	/**
	 * {@inheritDoc}
	 */
	public void setDirty() {

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isDirty() {
		return view.isDirty();
	}

	/**
	 * {@inheritDoc}
	 */
	public void enableView(boolean enabled) {
		view.enableView(enabled);
		acceptButton.setEnabled(enabled);
	}

	/**
	 * {@inheritDoc}
	 */
	public BindingResult getBindingResult() {
		return view.getBindingResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getErrorMessage() {
		return view.getErrorMessage();
	}
	
	private class CloseListener extends WindowAdapter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void windowClosing(WindowEvent e) {
			cancelAction.actionPerformed(null);
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void addControlChangeListener(ControlChangeListener listener) {
		view.addControlChangeListener(listener);
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeControlChangeListener(ControlChangeListener listener) {
		view.removeControlChangeListener(listener);
	}
}
